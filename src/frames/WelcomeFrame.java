package frames;

import project.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class WelcomeFrame extends JFrame {

    public WelcomeFrame() {

        setTitle("welcome to the game");

        setLayout(null);

        ImageIcon background = new ImageIcon(AmiyaWins.basicLoad+"/pictuer/timg.jpg");

        ImageIcon play = new ImageIcon(AmiyaWins.basicLoad+"/pictuer/start.png");
        //背景图；

        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 1000, 700);
        backgroundLabel.setIcon(new ImageIcon(background.getImage().getScaledInstance(1096, 700, Image.SCALE_DEFAULT )));

        JLabel playLabel =  new JLabel(play);
        playLabel.setBounds(480, 200, 100, 100);
        playLabel.setIcon(new ImageIcon(play.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT )));


        JButton button = new JButton();
        button.add(playLabel);
        Color backColor=new Color(156,199,241);
        button.setBackground(backColor);
        button.setBorderPainted(false);
        button.setBounds(480, 200, 130, 110);
        button.addActionListener(this::showSignFrame);

        JButton music=new JButton();
        music.setBorder(null);
        music.setBackground(backColor);
        music.setBounds(0,650,100,100);

        add(music);
        add(button);
        add(backgroundLabel);

        setLocation(160, 20);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showSignFrame(ActionEvent event) {
        Main.sign.setVisible(true);
        setVisible(false);
    }
}
