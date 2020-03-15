
package frames;


import project.Main;
import project.UserSignAndLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class SignFrame extends JFrame {

    private String num = Main.numcode();
    private JTextField nameField;
    private JTextField codeField;
    private JTextField pwdField;
    private JLabel codePrompt;
    public static String nameT;

    private ImageIcon successful = new ImageIcon(AmiyaWins.basicLoad+"/pictuer/success.jpg");

    private JLabel cong = new JLabel(" log in......");
    private JLabel success = new JLabel(successful);
    private Font bigFont = new Font("Comic Sans MS", Font.ITALIC, 21);
    Font titFont = new Font("Comic Sans MS", Font.ITALIC, 35);


    public SignFrame() {

        setLayout(null);

        ImageIcon background = new ImageIcon(AmiyaWins.basicLoad+"/pictuer/sgin.jpg");

        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 1000, 700);

        JLabel titLabel = new JLabel("logging");
        titLabel.setForeground(Color.WHITE);
        titLabel.setFont(titFont);
        titLabel.setBounds(450, 70, 200, 60);

        JLabel nameLabel = new JLabel("name:");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(bigFont);
        nameLabel.setBounds(380, 190, 100, 40);

        JLabel pwdLabel = new JLabel("passward:");
        pwdLabel.setForeground(Color.WHITE);
        pwdLabel.setFont(bigFont);
        pwdLabel.setBounds(360, 260, 100, 40);

        JLabel codeLabel = new JLabel("code:");
        codeLabel.setForeground(Color.WHITE);
        codeLabel.setFont(bigFont);
        codeLabel.setBounds(380, 330, 80, 40);


        codePrompt = new JLabel();
        codePrompt.setForeground(Color.WHITE);
        codePrompt.setFont(bigFont);
        codePrompt.setText(num);
        codePrompt.setBounds(570, 330, 70, 40);

        nameField = new JTextField(26);
        nameField.setFont(bigFont);
        nameField.setBorder(null);
        nameField.setBounds(480, 197, 150, 30);
        requestFocus();

        pwdField = new JPasswordField(26);
        pwdField.setFont(bigFont);
        pwdField.setBorder(null);
        pwdField.setBounds(480, 267, 150, 30);

        codeField = new JTextField(10);
        codeField.setFont(bigFont);
        codeField.setBorder(null);
        codeField.setBounds(480, 337, 65, 30);

        cong.setFont(titFont);
        cong.setForeground(Color.white);
        cong.setBounds(400, 200, 300, 100);
        success.setBounds(350, 200, 300, 100);
        success.setVisible(false);
        cong.setVisible(false);

        JButton signButton = new JButton("log in");
        signButton.setFont(bigFont);
        signButton.setBackground(Color.white);
        signButton.setBounds(380, 432, 90, 40);
        signButton.addActionListener(this::sign);

        JButton registerButton = new JButton("sign ");
        registerButton.setBackground(Color.white);
        registerButton.setFont(bigFont);
        registerButton.setBounds(530, 432, 90, 40);
        registerButton.addActionListener(this::showRegisterFrame);


        add(cong);
        add(success);
        add(signButton);
        add(registerButton);

        add(codePrompt);
        add(codeField);
        add(pwdField);
        add(nameField);


        add(titLabel);
        add(codeLabel);
        add(pwdLabel);
        add(nameLabel);
        add(signButton);
        add(backgroundLabel);

        setLocation(160, 20);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void sign(ActionEvent event) {
        nameT = nameField.getText();
        String pwd = pwdField.getText();
        String cod = codeField.getText();
        //验证码；
        if (cod.equals(num)) {
            switch (UserSignAndLogin.UserSignTest(nameT, pwd)) {
                case 0:
                    JOptionPane.showMessageDialog(null, "no username!");
                    break;
                case 1:

                    success.setVisible(true);
                    cong.setVisible(true);
                    new Thread(() -> {

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        showMenuFrame();


                    }).start();


                break;
                case 2:
                    JOptionPane.showMessageDialog(null, "wrong password!");
                default:
                    JOptionPane.showMessageDialog(null, "wrong username/password!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "error code");
            num = Main.numcode();
            codePrompt.setText(num);
        }
    }

    private void showRegisterFrame(ActionEvent event) {

        Main.registor.setVisible(true);
        setVisible(false);
    }

    private void showMenuFrame () {

        Main.menu.setVisible(true);
        setVisible(false);
    }

}
