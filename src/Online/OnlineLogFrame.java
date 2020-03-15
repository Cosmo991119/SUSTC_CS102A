/**
 * Copyright (C),2015-2019,XXX
 * FlieName:OnlineLogFrame
 * Author:zhang
 * Date: {DATE}10:46
 * Description:
 * History:
 * <Author>    <Time>    <Vesion>    <Desc>
 * 作者姓名    修改时间   版本号      描述
 */
package Online;

import Control.OnlinePlay;
import frames.AmiyaWins;
import frames.PvPOnline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class OnlineLogFrame extends JFrame {

    private OnlinePlay onlinePlay = new OnlinePlay();
    private boolean type;
    private JTextField IPv=new JTextField();
    private boolean isFirst=false;

    public OnlineLogFrame(){
        setLayout(null);

        Color backgroundColor=new Color(108,131,185);

        ImageIcon background = new ImageIcon(AmiyaWins.basicLoad+"/pictuer/online.jpg");
        ImageIcon Amiya = new ImageIcon(AmiyaWins.basicLoad+"/pictuer/阿米娅.jpg");
        ImageIcon Provences = new ImageIcon(AmiyaWins.basicLoad+"/pictuer/普罗旺斯.jpg");

        JPanel gamep = new JPanel();
        gamep.add(new JLabel(background));
        gamep.setBounds(0, 0, 1000, 700);

        JLabel amiya = new JLabel(Amiya);
        amiya.setIcon(new ImageIcon(Amiya.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
        amiya.setBounds(0, 0, 150, 150);
        amiya.setVisible(true);

        JLabel provence = new JLabel(Provences);
        provence.setIcon(new ImageIcon(Provences.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
        provence.setBounds(0, 0, 150, 150);

        JButton first = new JButton();
        first.add(amiya);
        first.setBorder(null);
        first.setBackground(backgroundColor);
        first.setBounds(250, 250, 150, 150);
        first.addActionListener(this::first);

        JButton late = new JButton();
        late.add(provence);
        late.setBorder(null);
        late.setBackground(backgroundColor);
        late.setBounds(470, 250, 150, 150);
        late.addActionListener(this::late);

        IPv.setBounds(350, 450, 150, 30);
        IPv.setVisible(true);

        add(IPv);
        add(first);
        add(late);
        add(gamep);

        setLocation(160, 20);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void first(ActionEvent event){
        System.out.println("Chose Server");
        isFirst=true;
        onlinePlay.setServer();
        type=true;
        System.out.println("Server S");
         int xsize = (int) (Math.random() * 8 + 3);
         int ysize = (int) (Math.random() * 6 + 3);

        System.out.println("setMap "+xsize+" "+ysize);
        onlinePlay.serverOUT(xsize);
        onlinePlay.serverOUT(ysize);
        System.out.println("sendMap");

        PvPOnline pvPOnline=new PvPOnline(xsize,ysize,type,onlinePlay,isFirst);
        pvPOnline.setVisible(true);

        System.out.println("login Frame S");

        this.dispose();
    }

    private void  late(ActionEvent event){
        System.out.println("Chose XXX");
        String Ipv=IPv.getText();
        System.out.println(Ipv);

        onlinePlay.setCilent(Ipv);// input ip
        type=false;

        System.out.println("XXX S");

        int xsize=onlinePlay.cilentIN();
        int ysize=onlinePlay.cilentIN();
        System.out.println("getMap"+xsize+" "+ysize);

        PvPOnline pvPOnline=new PvPOnline(xsize,ysize,type,onlinePlay,isFirst);
        pvPOnline.setVisible(true);
        System.out.println("login frame X");

        pvPOnline.getJudge().map.getPlayer1().clearScore();
        pvPOnline.getJudge().map.getPlayer2().clearScore();

        this.dispose();

    }
}
