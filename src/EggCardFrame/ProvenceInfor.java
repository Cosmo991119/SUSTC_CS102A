/**
 * Copyright (C),2015-2019,XXX
 * FlieName:ProvenceInfor
 * Author:zhang
 * Date: {DATE}2:19
 * Description:
 * History:
 * <Author>    <Time>    <Vesion>    <Desc>
 * 作者姓名    修改时间   版本号      描述
 */
package EggCardFrame;

import project.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProvenceInfor extends JFrame {
    static final public String basicLoad=System.getProperty("user.dir");
    public ProvenceInfor(){
        setLayout(null);

//        ImageIcon A1 = new ImageIcon(basicLoad+"/pictuer/AInfor.jpg");
        ImageIcon B1 = new ImageIcon(basicLoad+"/pictuer/PInfor.jpg");

        JLabel story=new JLabel() ;

        story.setIcon(new ImageIcon(B1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT )));

        story.setBounds(0,0,1000,700);

        ImageIcon rollback = new ImageIcon(basicLoad+"/pictuer/rollback.png");

        Color backColor=new Color(156,199,241);

        JLabel backLabel=new JLabel(rollback);
        backLabel.setIcon(new ImageIcon(rollback.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT )));
        backLabel.setBounds(10,0,80,60);

        JButton back = new JButton();
        back.add(backLabel);
        back.setBorder(null);
        back.setBackground(backColor);
        back.setBounds(5, 550, 55, 55);
        back.addActionListener(this::showMenu);

        add(back);

        add(story);

        setLocation(160, 20);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showMenu(ActionEvent event){
        Main.menu.setVisible(true);
        setVisible(false);
    }
}
