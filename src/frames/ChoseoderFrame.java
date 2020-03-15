/**
 * Copyright (C),2015-2019,XXX
 * FlieName:ChoseoderFrame
 * Author:zhang
 * Date: {DATE}16:07
 * Description:
 * History:
 * <Author>    <Time>    <Vesion>    <Desc>
 * 作者姓名    修改时间   版本号      描述
 */
package frames;


import project.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ChoseoderFrame extends JFrame {

    public ChoseoderFrame(){
        setLayout(null);

        Color backgroundColor=new Color(108,131,185);

        ImageIcon background = new ImageIcon(AmiyaWins.basicLoad+"/pictuer/chose.jpg");
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

        add(first);
        add(late);
        add(gamep);

        setLocation(160, 20);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void first(ActionEvent event){


        Main.menu.chosePlayer="player1";
        System.out.println(Main.menu.chosePlayer);

        PvMFrame pvMFrame=new PvMFrame();
        pvMFrame.setVisible(true);

        pvMFrame.getJudge().map.getPlayer1().clearScore();
        pvMFrame.getJudge().map.getPlayer2().clearScore();

        this.dispose();
    }

    private void  late(ActionEvent event){


        Main.menu.chosePlayer="player2";
        System.out.println(Main.menu.chosePlayer);

        PvMFrame pvMFrame=new PvMFrame();
        pvMFrame.setVisible(true);

        pvMFrame.getJudge().map.getPlayer1().clearScore();
        pvMFrame.getJudge().map.getPlayer2().clearScore();

        this.dispose();

    }

}
