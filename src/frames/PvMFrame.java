/**
 * Copyright (C),2015-2019,XXX
 * FlieName:PvMFrame
 * Author:zhang
 * Date: {DATE}16:06
 * Description:
 * History:
 * <Author>    <Time>    <Vesion>    <Desc>
 * 作者姓名    修改时间   版本号      描述
 */
package frames;

import Control.Judge;
import Delay.DelayMs;
import project.Main;
import project.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PvMFrame extends JFrame {

    protected Color color1;
    protected Color color2;

    private static final ImageIcon PM = new ImageIcon(AmiyaWins.basicLoad+"/pictuer/PMplay.png");

    public Player chosePlayer;
    private DelayMs delayMs=new DelayMs();

    public int x;
    public int y;

    private Judge judge;
    private JButton start=new JButton();

    JLabel player1 = new JLabel();
    JLabel amiya = new JLabel(Main.Amiya);
    JLabel player2 = new JLabel();
    JLabel provence = new JLabel(Main.Provences);
    JLabel amiyaS=new JLabel("0");
    JLabel provenceS=new JLabel("0");

    int xmap;
    int ymap;


    public PvMFrame() {

        //        TODO
        xmap = (int) (Math.random() * 8 + 3);
        ymap = (int) (Math.random() * 6 + 3);

        judge=new Judge(this);
        judge.newMap(xmap,ymap);
        judge.setEgg();
        judge.setEggSquare();

        setLayout(null);

        color1 = new Color(176, 224, 230);
        color2 = new Color(255, 182, 193);

        Font bigFont = new Font("Comic Sans MS", Font.ITALIC, 20);

        JPanel backgroundp = new JPanel();
        backgroundp.add(new JLabel(Main.background));
        backgroundp.setBounds(0, 0, 1000, 700);

        JLabel backLabel=new JLabel(Main.back);
        backLabel.setIcon(new ImageIcon(Main.back.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT )));
        backLabel.setBounds(0,0,80,80);

        JLabel newMap=new JLabel(Main.map);
        newMap.setIcon(new ImageIcon(Main.map.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT )));
        newMap.setBounds(0,0,80,80);

        JButton back = new JButton();
        back.add(backLabel);
        back.setBackground(Color.WHITE);
        back.setBounds(807, 540, 51, 51);
        back.addActionListener(this::showMenuFrame);

        JButton next = new JButton();
        next.add(newMap);
        next.setBackground(Color.white);
        next.setBounds(874, 540, 51, 51);
        next.addActionListener(this::newMap);


        JLabel PMstart = new JLabel();
        PMstart.setIcon(new ImageIcon(PM.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT )));
        PMstart.setBounds(0,0,50,50);
        start.add(PMstart);
        start.setBounds(837, 400, 60, 60);
        start.setVisible(false);
        start.addActionListener(this::start);

        player1.setBounds(810, 30, 100, 70);
        player1.setFont(bigFont);
        player1.setForeground(color1);
        player1.setText("Amiya");
        player1.setVisible(true);

        amiya.setIcon(new ImageIcon(Main.Amiya.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT )));
        amiya.setBounds(790, 70, 150, 150);
        amiya.setVisible(true);

        player2.setBounds(810, 30, 100, 70);
        player2.setFont(bigFont);
        player2.setForeground(color2);
        player2.setText("Provence");
        player2.setVisible(false);

        provence.setIcon(new ImageIcon(Main.Provences.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT )));
        provence.setBounds(790, 70, 150, 150);
        provence.setVisible(false);


        Font eggFont=new Font("Comic Sans MS", Font.ITALIC, 14);

        JLabel release=new JLabel();
        release.setBounds(797, 3, 150, 70);
        release.setFont(eggFont);
        release.setForeground(Color.WHITE);

        JLabel Score = new JLabel("Score:");
        Score.setBounds(797, 190, 70, 70);
        Score.setFont(bigFont);

        amiyaS.setFont(bigFont);
        amiyaS.setBounds(875, 215, 70, 70);

        provenceS.setFont(bigFont);
        provenceS.setBounds(875, 215, 70, 70);
        provenceS.setVisible(false);

        if (judge.result==1)
            release.setText("Amiya get the egg");
        else if (judge.result==2)
            release.setText("peovence gets the egg");
        else if (judge.result==0)
            release.setText("the egg cancellation");
        else
            release.setText("No one holds the egg");

        judge.result=0;

        if (Main.menu.chosePlayer.equals("player2")) {
            chosePlayer = judge.map.getPlayer2();
            start.setVisible(true);
            player1.setVisible(false);
            amiya.setVisible(false);
            player2.setVisible(true);
            provence.setVisible(true);
        }
        else{
            chosePlayer=judge.map.getPlayer1();
            player1.setVisible(true);
            amiya.setVisible(true);
            player2.setVisible(false);
            provence.setVisible(false);
        }


        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();

                if (judge.map.currentPlayer() == chosePlayer){
                    judge.paintAfterClick(x,y);
                    changePlayLabel();
                    judge.result(xmap-1,ymap-1);
                }

                new Thread(() -> {

                    judge.checkleft();

                    while (judge.map.currentPlayer() != chosePlayer && (judge.getHasVLeft() || judge.getHasHLeft())) {

                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException c) {
                            c.printStackTrace();
                        }

                        judge.pvMMachineAction();
                        changePlayLabel();
                        judge.checkleft();
                    }
                    judge.result(xmap-1,ymap-1);

                }).start();


            }
        });


        add(amiyaS);
        add(provenceS);
        add(Score);

        add(start);
        add(release);
        add(provence);
        add(amiya);

        add(player1);
        add(player2);

        add(back);
        add(next);
        add(backgroundp);

        setLocation(160, 20);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void showMenuFrame(ActionEvent event) {
        Main.menu.setVisible(true);
        this.dispose();
    }

    private void newMap(ActionEvent event) {
        Main.chose.setVisible(true);
        this.dispose();
    }


    private void start(ActionEvent event){

        judge.checkleft();

        delayMs.delay(800);

        judge.pvMMachineAction();

        start.setVisible(false);
    }

    public void changePlayLabel(){

        if (judge.map.currentPlayer() == judge.map.getPlayer1()) {
            player1.setVisible(true);
            amiya.setVisible(true);
            player2.setVisible(false);
            provence.setVisible(false);
            provenceS.setVisible(false);

            amiyaS.setText(String.valueOf(judge.map.getPlayer1().getScore()));
            amiyaS.setVisible(true);

        } else {
            player1.setVisible(false);
            amiya.setVisible(false);
            player2.setVisible(true);
            amiyaS.setVisible(false);
            provence.setVisible(true);

            provenceS.setText(String.valueOf(judge.map.getPlayer2().getScore()));
            provenceS.setVisible(true);

        }
    }

    public Judge getJudge() {
        return judge;
    }

}
