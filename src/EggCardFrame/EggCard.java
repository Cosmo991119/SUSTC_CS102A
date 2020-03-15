/**
 * Copyright (C),2015-2019,XXX
 * FlieName:EggCard
 * Author:zhang
 * Date: {DATE}0:02
 * Description:
 * History:
 * <Author>    <Time>    <Vesion>    <Desc>
 * 作者姓名    修改时间   版本号      描述
 */
package EggCardFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EggCard extends JFrame {


    private JFrame frame;
    static final public String basicLoad=System.getProperty("user.dir");
    public EggCard(JFrame frame) {
        this.frame = frame;
        setLayout(null);

        ImageIcon A1 = new ImageIcon(basicLoad+"/pictuer/A-1.jpg");
        ImageIcon B1 = new ImageIcon(basicLoad+"/pictuer/B1.jpg");

        int chose = (int) (Math.random() * 2);

        JLabel story=new JLabel() ;
        if (chose == 0)
            story.setIcon(new ImageIcon(A1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT )));
        if (chose == 1)
            story .setIcon(new ImageIcon(B1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT )));

        story.setBounds(0,0,700,700);

        ImageIcon rollback = new ImageIcon(basicLoad+"/pictuer/rollback.png");

        Color backColor=new Color(156,199,241);

        JLabel backLabel=new JLabel(rollback);
        backLabel.setIcon(new ImageIcon(rollback.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT )));
        backLabel.setBounds(10,0,80,60);

        JButton back = new JButton();
        back.add(backLabel);
        back.setBackground(backColor);
        back.setBounds(5, 550, 50, 50);
        back.addActionListener(this::showPGF);

        add(back);

        add(story);

        setLocation(300, 0);
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void showPGF(ActionEvent event){
        setVisible(false);
        frame.setVisible(true);
    }
}
