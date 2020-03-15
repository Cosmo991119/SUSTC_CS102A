package frames;

import Control.Judge;
import Control.OnlinePlay;
import project.Main;
import project.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PvPOnline extends JFrame {

    protected Color color1;
    protected Color color2;

    private Judge judge;
    private boolean wait;
    private Boolean isStart = true;
    private OnlinePlay onlinePlay;
    private boolean type;
    private boolean isFirst;
    private Player choesPlayer;

    public int x;
    public int y;
    private int xsize;
    private int ysize;

    public PvPOnline(int x1, int y1, Boolean type, OnlinePlay onlinePlay, Boolean isFirst) {
        this.isFirst = isFirst;
        this.type = type;
        this.onlinePlay = onlinePlay;
        this.xsize = x1;
        this.ysize = y1;

        judge = new Judge(this);

        judge.newMap(xsize, ysize);

        setLayout(null);

        ImageIcon background = new ImageIcon(AmiyaWins.basicLoad + "/pictuer/playbackground.jpg");
        ImageIcon Amiya = new ImageIcon(AmiyaWins.basicLoad + "/pictuer/阿米娅.jpg");
        ImageIcon Provences = new ImageIcon(AmiyaWins.basicLoad + "/pictuer/普罗旺斯.jpg");
        ImageIcon rollback = new ImageIcon(AmiyaWins.basicLoad + "/pictuer/rollback.png");

        JPanel backgroundp = new JPanel();
        backgroundp.add(new JLabel(background));
        backgroundp.setBounds(0, 0, 1000, 700);

        Color backColor = new Color(156, 199, 241);

        JLabel backLabel = new JLabel(rollback);
        backLabel.setIcon(new ImageIcon(rollback.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
        backLabel.setBounds(10, 0, 80, 60);

        JButton back = new JButton();
        back.add(backLabel);
        back.setBackground(backColor);
        back.setBounds(10, 600, 60, 60);
        back.addActionListener(this::showMenuFrame);


        JLabel newMap=new JLabel(Main.map);
        newMap.setIcon(new ImageIcon(Main.map.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT )));
        newMap.setBounds(0,0,80,80);

        JButton next = new JButton();
        next.add(newMap);
        next.setBackground(Color.white);
        next.setBounds(874, 540, 51, 51);
        next.addActionListener(this::newMap);

        Font bigFont = new Font("Comic Sans MS", Font.ITALIC, 20);

        JLabel player1 = new JLabel();
        player1.setBounds(810, 30, 100, 70);
        color1 = new Color(176, 224, 230);
        player1.setFont(bigFont);
        player1.setForeground(color1);
        player1.setText("Amiya");
        player1.setVisible(false);

        JLabel amiya = new JLabel(Amiya);
        amiya.setIcon(new ImageIcon(Amiya.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
        amiya.setBounds(790, 70, 150, 150);
        amiya.setVisible(false);


        Font eggFont = new Font("Comic Sans MS", Font.ITALIC, 14);

        JLabel release = new JLabel();
        release.setBounds(797, 3, 150, 70);
        release.setFont(eggFont);
        release.setForeground(Color.WHITE);

        JLabel player2 = new JLabel();
        player2.setBounds(810, 30, 100, 70);
        color2 = new Color(255, 182, 193);
        player2.setFont(bigFont);
        player2.setForeground(color2);

        player2.setText("Provence");
        player2.setVisible(false);

        JLabel provence = new JLabel(Provences);
        provence.setIcon(new ImageIcon(Provences.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
        provence.setBounds(790, 70, 150, 150);

        provence.setVisible(false);


        JLabel Score = new JLabel("Score:");
        Score.setBounds(797, 190, 70, 70);
        Score.setFont(bigFont);

        JLabel amiyaS = new JLabel("0");
        amiyaS.setFont(bigFont);
        amiyaS.setBounds(875, 215, 70, 70);

        JLabel provenceS = new JLabel("0");
        provenceS.setFont(bigFont);
        provenceS.setBounds(875, 215, 70, 70);
        provenceS.setVisible(false);

        JButton toProvence = new JButton("Provence");
        toProvence.setBounds(810, 400, 100, 60);
        toProvence.addActionListener(this::nextProvence);
        toProvence.setVisible(false);

        JButton toAmiya = new JButton("Amiya");
        toAmiya.setBounds(810, 400, 100, 60);
        toAmiya.addActionListener(this::nextAmiya);
        toAmiya.setVisible(false);

        if (isFirst) {
            choesPlayer = judge.map.getPlayer1();
            amiya.setVisible(true);
            player1.setVisible(true);
            System.out.println("Amiya");
            toProvence.setVisible(true);
            System.out.println("toProvenc");

        } else {
            choesPlayer = judge.map.getPlayer2();
            provence.setVisible(true);
            player2.setVisible(true);
            System.out.println("Provence");
            toAmiya.setVisible(true);
            System.out.println("toAmiya");
        }

        isFirst = false;

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();

                if (type) {
                    System.out.println("Amiya Click");
                    if (judge.map.currentPlayer() == choesPlayer) {
                        judge.paintAfterClick(x, y);
                        System.out.println("Amiya Paint");
                        amiyaS.setText(String.valueOf(judge.map.getPlayer1().getScore()));
                        judge.result(xsize - 1, ysize - 1);
                    }else {
                        System.out.println("Amiya wating");
                        int xin = onlinePlay.serverIN(), yin = onlinePlay.serverIN();
                        System.out.println("Amiya received");
                        judge.paintAfterClick(xin, yin);
                        System.out.println("xin: " + xin + " yin: " + yin);
                        System.out.println("Amiya get Provence Paint");
                        judge.result(xsize - 1, ysize - 1);
                    }
                } else {
                    System.out.println("Provence Click");

                    if (judge.map.currentPlayer() == choesPlayer) {
                        judge.paintAfterClick(x, y);
                        System.out.println("Provence paint");
                        provenceS.setText(String.valueOf(judge.map.getPlayer2().getScore()));
                        judge.result(xsize - 1, ysize - 1);
                    }else {
                        System.out.println("Provence wating");
                        int xin = onlinePlay.cilentIN(), yin = onlinePlay.cilentIN();
                        System.out.println("Provence received");
                        judge.paintAfterClick(xin, yin);
                        System.out.println("Provence get Amiya Paint");
                        judge.result(xsize - 1, ysize - 1);
                    }

                }

            }
        });


        add(toAmiya);
        add(toProvence);
        add(amiyaS);
        add(provenceS);

        add(Score);
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
        this.dispose();
        Main.menu.setVisible(true);
    }

    private void newMap(ActionEvent event) {
        int xsize = (int) (Math.random() * 8 + 3);
        int ysize = (int) (Math.random() * 6 + 3);

        System.out.println("setMap " + xsize + " " + ysize);
        onlinePlay.serverOUT(xsize);
        onlinePlay.serverOUT(ysize);
        System.out.println("sendMap");

        PvPOnline pvPOnline = new PvPOnline(xsize, ysize, type, onlinePlay, isFirst);
        pvPOnline.setVisible(true);


        this.dispose();
    }

    private void nextProvence(ActionEvent event) {
        onlinePlay.serverOUT(x);
        onlinePlay.serverOUT(y);
        System.out.println("Amiya Sending");

        if (judge.map.isShouldChangePlayer())
            System.out.println("change player ,waiting for receive");
        else
            System.out.println("don't change player ,waiting for click");

        if (judge.map.isShouldChangePlayer()) {
            System.out.println("Amiya wating");
            int xin = onlinePlay.serverIN(), yin = onlinePlay.serverIN();
            System.out.println("Amiya received");
            judge.paintAfterClick(xin, yin);
            System.out.println("xin: " + xin + " yin: " + yin);
            System.out.println("Amiya get Provence Paint");
            judge.result(xsize - 1, ysize - 1);
        }

    }

    private void nextAmiya(ActionEvent event) {
        onlinePlay.cilentOUT(x);
        onlinePlay.cilentOUT(y);
        System.out.println("Provence Sending");

        if (judge.map.isShouldChangePlayer())
            System.out.println("change player ,waiting for receive");
        else
            System.out.println("don't change player ,waiting for click");

        if (judge.map.isShouldChangePlayer()) {
            System.out.println("Provence wating");
            int xin = onlinePlay.cilentIN(), yin = onlinePlay.cilentIN();
            System.out.println("Provence received");
            judge.paintAfterClick(xin, yin);
            System.out.println("Provence get Amiya Paint");
            judge.result(xsize - 1, ysize - 1);
        }

    }

    public Judge getJudge() {
        return judge;
    }
}

