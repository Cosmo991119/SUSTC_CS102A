
package frames;


import project.Main;
import project.UserSignAndLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RegistorFrame extends JFrame {

    private String num = Main.numcode();
    private JTextField usernameField;
    private JTextField pwdsignT;
    private JTextField pwdcofriT;
    private JTextField codepromotField;
    private JLabel codePrompt;

    private ImageIcon successful = new ImageIcon(AmiyaWins.basicLoad+"/pictuer/success.jpg");

    private JPanel prosP = new JPanel();
    private JLabel cong=new JLabel("back to log in......");
    private JLabel success = new JLabel(successful);
    private Font bigFont = new Font("Comic Sans MS", Font.ITALIC, 21);

    public RegistorFrame() {
        setLayout(null);

        Font titFont = new Font("Comic Sans MS", Font.ITALIC, 35);

        ImageIcon background = new ImageIcon(AmiyaWins.basicLoad+"/pictuer/load.jpg");
        ImageIcon rollback = new ImageIcon(AmiyaWins.basicLoad+"/pictuer/rollback.png");


        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 1000, 700);

        JLabel titLabel = new JLabel("signing");
        titLabel.setForeground(Color.WHITE);
        titLabel.setFont(titFont);
        titLabel.setBounds(450, 70, 200, 60);

        JLabel nameLable = new JLabel("username:");
        nameLable.setForeground(Color.WHITE);
        nameLable.setFont(bigFont);
        nameLable.setBounds(360, 190, 100, 40);

        JLabel pwdLable = new JLabel("password:");
        pwdLable.setForeground(Color.WHITE);
        pwdLable.setFont(bigFont);
        pwdLable.setBounds(360, 250, 100, 40);

        JLabel pwdforLable = new JLabel("confirm:");
        pwdforLable.setForeground(Color.WHITE);
        pwdforLable.setFont(bigFont);
        pwdforLable.setBounds(370, 310, 100, 40);

        JLabel codpromotforLable = new JLabel("code:");
        codpromotforLable.setForeground(Color.WHITE);
        codpromotforLable.setFont(bigFont);
        codpromotforLable.setBounds(390, 360, 80, 40);

        codePrompt = new JLabel();
        codePrompt.setForeground(Color.WHITE);
        codePrompt.setFont(bigFont);
        codePrompt.setText(num);
        codePrompt.setBounds(570, 365, 70, 40);

        usernameField = new JTextField(26);
        usernameField.setFont(bigFont);
        usernameField.setBorder(null);
        usernameField.setBounds(480, 197, 150, 30);
        requestFocus();


        pwdsignT = new JPasswordField(26);
        pwdsignT.setFont(bigFont);
        pwdsignT.setBorder(null);
        pwdsignT.setBounds(480, 257, 150, 30);


        pwdcofriT = new JPasswordField(26);
        pwdcofriT.setFont(bigFont);
        pwdcofriT.setBorder(null);
        pwdcofriT.setBounds(480, 317, 150, 30);

        codepromotField = new JPasswordField(26);
        codepromotField.setFont(bigFont);
        codepromotField.setBorder(null);
        codepromotField.setBounds(480, 370, 75, 30);


        JButton sign = new JButton("sign");
        sign.setBounds(460, 450, 100, 40);
        sign.setFont(bigFont);
        sign.addActionListener(this::registor);

        JLabel backLabel=new JLabel(rollback);
        backLabel.setIcon(new ImageIcon(rollback.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT )));
        backLabel.setBounds(10,0,80,60);

        Color backColor=new Color(156,199,241);

        JButton back = new JButton();
        back.add(backLabel);
        back.setBackground(backColor);
        back.setBorder(null);
        back.setBounds(10, 600, 60, 60);
        back.addActionListener(this::backSignFrame);



        cong.setFont(bigFont);
        cong.setForeground(Color.white);
        cong.setBounds(400, 200, 300, 100);
        success.setBounds(350, 200, 300, 100);
        success.setVisible(false);
        cong.setVisible(false);

        add(back);
        add(cong);
        add(success);

        add(titLabel);
        add(nameLable);
        add(usernameField);
        add(pwdLable);
        add(pwdsignT);
        add(pwdcofriT);
        add(pwdforLable);
        add(codpromotforLable);
        add(codepromotField);
        add(sign);
        add(prosP);
        add(codePrompt);

        add(backgroundLabel);

        setLocation(160, 20);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void backSignFrame(ActionEvent event) {
        setVisible(false);
        Main.sign.setVisible(true);
    }

    private void registor(ActionEvent event) {
        String name = usernameField.getText();
        String pwd = pwdsignT.getText();
        String cod = pwdcofriT.getText();
        String codepromot = codepromotField.getText();

        if (name.equals("") || pwd.equals("") || cod.equals("")) {
            JOptionPane.showMessageDialog(null, "please finish the form");
        } else if (pwd.equals(cod)) {
            if (codepromot.equals(num)) {
                UserSignAndLogin U = new UserSignAndLogin(name, pwd);
                if (U.getUserExist()) {
                    JOptionPane.showMessageDialog(null, "username already existed!");
                } else {

                    success.setVisible(true);
                    cong.setVisible(true);
                    new Thread(() -> {

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        showSignFrame();


                    }).start();


                }
            } else {
                JOptionPane.showMessageDialog(null, "error code");
                num = Main.numcode();
                codePrompt.setText(num);
            }


        } else {
            JOptionPane.showMessageDialog(null, "please input same password!");
        }
    }

    private void showSignFrame() {

        Main.sign.setVisible(true);
        setVisible(false);
    }

}
