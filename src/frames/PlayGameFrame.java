/**
 * Copyright (C),2015-2019,XXX
 * FlieName:PlayGameFrame
 * Author:zhang
 * Date: {DATE}20:15
 * Description:
 * History:
 * <Author>    <Time>    <Vesion>    <Desc>
 * 作者姓名    修改时间   版本号      描述
 */
package frames;

import Control.Judge;
import project.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PlayGameFrame extends JFrame {

    protected Color color1;
    protected Color color2;

    private Judge judge;
//    public SaveLoadGame saveLoad;
    public Boolean isStart = true;

    public int x;
    public int y;

    JLabel player1 = new JLabel();
    JLabel amiya = new JLabel(Main.Amiya);
    JLabel player2 = new JLabel();
    JLabel provence = new JLabel(Main.Provences);
    JLabel amiyaS=new JLabel("0");
    JLabel provenceS=new JLabel("0");

    int xmap;
    int ymap;

//   public SaveLoadGame saveLoadGame;

    public static ArrayList<Integer> xList=new ArrayList<>();
    public static ArrayList<Integer> yList=new ArrayList<>();

    private static final ImageIcon Save = new ImageIcon(AmiyaWins.basicLoad+"/pictuer/save.png");

    public PlayGameFrame() {


        judge = new Judge(this);

        //        TODO
        xmap = (int) (Math.random() * 8 + 3);
        ymap = (int) (Math.random() * 6 + 3);

        judge.newMap(xmap, ymap);
        judge.setEgg();
        judge.setEggSquare();

//        saveLoadGame=new SaveLoadGame();
//        saveLoad.setName(judge.map.getGame().getPlayer1().getName());
//        saveLoad.setPlayGameFrame(this);
//        saveLoad.setGame(judge.map.getGame());

        setLayout(null);

        color1 = new Color(176, 224, 230);
        color2 = new Color(255, 182, 193);

        Font bigFont = new Font("Comic Sans MS", Font.ITALIC, 20);
        Font eggFont = new Font("Comic Sans MS", Font.ITALIC, 14);

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
//
        JLabel saveLog=new JLabel(Save);
        saveLog.setIcon(new ImageIcon(Save.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT )));
        saveLog.setBounds(0,0,80,80);

        JButton save = new JButton();
        save.add(saveLog);
        save.setBackground(Color.white);
        save.setBounds(874, 440, 51, 51);
        save.addActionListener(this::save);


        player1.setBounds(810, 30, 100, 70);
        player1.setFont(bigFont);
        player1.setForeground(color1);
        player1.setText("Amiya");
        player1.setVisible(true);

        amiya.setIcon(new ImageIcon(Main.Amiya.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
        amiya.setBounds(790, 70, 150, 150);
        amiya.setVisible(true);


        player2.setBounds(810, 30, 100, 70);
        player2.setFont(bigFont);
        player2.setForeground(color2);
        player2.setText("Provence");
        player2.setVisible(false);

        provence.setIcon(new ImageIcon(Main.Provences.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
        provence.setBounds(790, 70, 150, 150);
        provence.setVisible(false);

        JLabel release = new JLabel();
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


        if (judge.result == 1)
            release.setText("Amiya get the egg");
        else if (judge.result == 2)
            release.setText("peovence gets the egg");
        else if (judge.result == 0)
            release.setText("the egg cancellation");
        else
            release.setText("No one holds the egg");

        judge.result = 0;

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                xList.add(x);
                yList.add(y);

                judge.paintAfterClick(x, y);

                changePlayLabel();

                judge.result(xmap-1,ymap-1);

            }
        });


        add(save);

        add(back);
        add(next);

        add(amiyaS);
        add(provenceS);
        add(Score);

        add(release);
        add(provence);
        add(amiya);
        add(player1);
        add(player2);

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

        PlayGameFrame playGameFrame = new PlayGameFrame();

        playGameFrame.setVisible(true);
        playGameFrame.judge.map.getPlayer1().clearScore();
        playGameFrame.judge.map.getPlayer2().clearScore();

        this.dispose();

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

    public void save(ActionEvent event){
//        saveLoad.save();
    }


}
