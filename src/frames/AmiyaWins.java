/**
 * Copyright (C),2015-2019,XXX
 * FlieName:AmiyaWins
 * Author:zhang
 * Date: {DATE}12:32
 * Description:
 * History:
 * <Author>    <Time>    <Vesion>    <Desc>
 * 作者姓名    修改时间   版本号      描述
 */
package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AmiyaWins extends JFrame {
    private JFrame frame;
    static final public String basicLoad=System.getProperty("user.dir");
    public AmiyaWins(JFrame frame){
        this.frame=frame;
        setLayout(null);

        ImageIcon amiyaw = new ImageIcon(basicLoad+"/pictuer/Awins.jpg");
        ImageIcon rollback = new ImageIcon(basicLoad+"/pictuer/rollback.png");

        JLabel wins=new JLabel(amiyaw);
        wins.setBounds(0, 0, 1000, 700);

        JLabel backLabel=new JLabel(rollback);
        backLabel.setIcon(new ImageIcon(rollback.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT )));
        backLabel.setBounds(10,0,80,60);

        Color backColor=new Color(156,199,241);

        JButton back = new JButton();
        back.add(backLabel);
        back.setBackground(backColor);
        back.setBorder(null);
        back.setBounds(10, 600, 60, 60);
        back.addActionListener(this::showPGF);

        add(back);
        add(wins);
        setLocation(160, 20);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showPGF(ActionEvent event){
        setVisible(false);
        frame.setVisible(true);
    }

}
