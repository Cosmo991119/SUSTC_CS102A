
package project;

import Control.Music;
import EggCardFrame.AmiyaInofr;
import EggCardFrame.ProvenceInfor;
import Online.OnlineLogFrame;
import frames.*;

import javax.swing.*;


public class Main extends JComponent {

    public static final WelcomeFrame welcome = new WelcomeFrame();
    public static final SignFrame sign = new SignFrame();
    public static final RegistorFrame registor = new RegistorFrame();
    public static final MenuFrame menu = new MenuFrame();
    public static final AmiyaInofr amiya=new AmiyaInofr();
    public static final ProvenceInfor provence=new ProvenceInfor();
    public static final ChoseoderFrame chose=new ChoseoderFrame();
    public static final OnlineLogFrame onlinlog=new OnlineLogFrame();
    public static final ImageIcon background = new ImageIcon(AmiyaWins.basicLoad+"/pictuer/playbackground.jpg");
    public static final ImageIcon Amiya = new ImageIcon(AmiyaWins.basicLoad+"/pictuer/阿米娅.jpg");
    public static final ImageIcon Provences = new ImageIcon(AmiyaWins.basicLoad+"/pictuer/普罗旺斯.jpg");
    public static final ImageIcon back = new ImageIcon(AmiyaWins.basicLoad+"/pictuer/back.png");
    public static final ImageIcon map = new ImageIcon(AmiyaWins.basicLoad+"/pictuer/map.png");


    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        welcome.setVisible(true);
        new Music();
    }


    public static String numcode() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int temp = (int) (Math.random() * 10);
            s.append(temp);
        }
        return s.toString();
    }

}

