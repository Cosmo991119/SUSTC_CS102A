
package frames;


import project.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuFrame extends JFrame {

    public Boolean isPvPoffline=false;
    public Boolean isPvPonline=false;
    public Boolean isPvM=false;
    public Boolean isMvM=false;
    public String chosePlayer;


    public MenuFrame() {
        setLayout(null);

        Font bigFont = new Font("Comic Sans MS", Font.ITALIC, 21);

        ImageIcon background = new ImageIcon(AmiyaWins.basicLoad+"/pictuer/meun.jpg");

//背景；
        JPanel backgroundp = new JPanel();
        backgroundp.add(new JLabel(background));
        backgroundp.setBounds(0, 0, 1000, 700);
//主菜单；
        JMenuBar menuBar = new JMenuBar();
        JMenu newgame = new JMenu("new game");
        newgame.setBackground(Color.white);
        newgame.setFont(bigFont);
        JMenuBar loadBar = new JMenuBar();
        JMenu loadsavegame = new JMenu("continue");
        loadsavegame.setBackground(Color.white);
        loadsavegame.setFont(bigFont);
        JMenuBar designerBar = new JMenuBar();
        JMenu disgnercheck = new JMenu("  roles ");
        disgnercheck.setBackground(Color.white);
        disgnercheck.setFont(bigFont);
        //读取存档；

        JMenuItem pvm = new JMenuItem(" P vs M ");
        pvm.setBackground(Color.white);
        pvm.setFont(bigFont);
        pvm.addActionListener(this::showPlayPvMGame);
        JMenuItem pvpo = new JMenuItem(" P vs P Online");
        pvpo.setBackground(Color.white);
        pvpo.setFont(bigFont);
        pvpo.addActionListener(this::showOlineLog);
        JMenuItem pvpf = new JMenuItem(" P vs P Offline");
        pvpf.setBackground(Color.white);
        pvpf.setFont(bigFont);
        pvpf.addActionListener(this::showPlayGame);
        JMenuItem mvm = new JMenuItem(" M vs M");
        mvm.setBackground(Color.white);
        mvm.setFont(bigFont);
        mvm.addActionListener(this::MvMPlay);

        JMenuItem deger = new JMenuItem("Amiya");
        deger.setFont(bigFont);
        deger.addActionListener(this::CheckAmiya);
        JMenuItem words = new JMenuItem("Provence");
        words.setFont(bigFont);
        words.addActionListener(this::CheckProvence);

        newgame.add(pvm);
        newgame.add(pvpo);
        newgame.add(pvpf);
        newgame.add(mvm);

        disgnercheck.add(deger);
        disgnercheck.add(words);

        designerBar.add(disgnercheck);
        menuBar.add(newgame);
        loadBar.add(loadsavegame);

        menuBar.setBounds(420, 120, 100, 40);
        loadBar.setBounds(420, 190, 100, 40);
        designerBar.setBounds(420, 260, 100, 40);

        add(designerBar);
        add(menuBar);
        add(loadBar);
        add(backgroundp);

        setLocation(160, 20);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void showPlayGame(ActionEvent event) {

        isPvPoffline=true;

        PlayGameFrame playGameFrame=new PlayGameFrame();
        playGameFrame.setVisible(true);

        setVisible(false);
    }

    private void showPlayPvMGame(ActionEvent event){
        isPvM=true;

        Main.chose.setVisible(true);

        setVisible(false);
    }

    private void MvMPlay(ActionEvent event){
        isMvM=true;

        MvMFrame mvMFrame=new MvMFrame();
        mvMFrame.setVisible(true);

        setVisible(false);

    }

    private void CheckAmiya(ActionEvent event){
        Main.amiya.setVisible(true);
    }

    private void CheckProvence(ActionEvent event){
        Main.provence.setVisible(true);
    }

    private void showOlineLog(ActionEvent event){
        isPvPonline=true;

        Main.onlinlog.setVisible(true);
        setVisible(false);
    }


}
