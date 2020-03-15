
package Control;

import frames.*;
import project.Game;
import project.GameMap;
import project.Player;

import javax.swing.*;
import java.util.ArrayList;

public class Judge {
    public GameMap map;
    private Game game;

    private Boolean hasVLeft = false;
    private Boolean hasHLeft = false;

    private ArrayList<PaintEage> horizontalEdge = new ArrayList<>();
    private ArrayList<PaintEage> verticalEdge = new ArrayList<>();

    private JFrame frame;
    public int result;
    private int eggSquare;

    public Judge(JFrame frame) {
        this.frame = frame;
    }

    public void newMap(int x, int y) {

        game = new Game(Player.BLUE, Player.RED, x, y, SignFrame.nameT);
        map = new GameMap(game, frame);

        map.getPlayer1().clearScore();
        map.getPlayer2().clearScore();

        for (int i = 0; i < map.dots.size(); i++) {
            frame.add(map.dots.get(i));
        }

        for (int i = 0; i < map.getXsize() - 1; i++) {
            for (int j = 0; j < map.getYsize(); j++) {
                frame.add(map.horEages[i][j]);
                horizontalEdge.add(map.horEages[i][j]);
            }
        }

        for (int i = 0; i < map.getXsize(); i++) {
            for (int j = 0; j < map.getYsize() - 1; j++) {
                frame.add(map.verEages[i][j]);
                verticalEdge.add(map.verEages[i][j]);
            }
        }

        for (int i = 0; i < map.getXsize() - 1; i++) {
            for (int j = 0; j < map.getYsize() - 1; j++) {
                frame.add(map.squares[i][j]);
            }
        }

    }

    public void paintAfterClick(int x, int y) {
        for (int i = 0; i < map.getXsize() - 1; i++) {

            for (int j = 0; j < map.getYsize(); j++) {

                if (40 + map.horEages[i][j].getxLocation() <= x
                        && x <= 90 + map.horEages[i][j].getxLocation()
                        && 40 + map.horEages[i][j].getyLocation() <= y
                        && y <= 60 + map.horEages[i][j].getyLocation()
                        && !map.horEages[i][j].hasOwner()) {
                    map.horEages[i][j].click();
                }
            }
        }

        for (int i = 0; i < map.getXsize(); i++) {
            for (int j = 0; j < map.getYsize() - 1; j++) {
                if (map.verEages[i][j].getxLocation() + 20 <= x
                        && x <= 40 + map.verEages[i][j].getxLocation()
                        && map.verEages[i][j].getyLocation() + 60 <= y
                        && y <= 110 + map.verEages[i][j].getyLocation()
                        && !map.verEages[i][j].hasOwner()) {
                    map.verEages[i][j].click();

                }
            }
        }
    }

    public void checkleft() {
        hasVLeft = false;
        hasHLeft = false;

        for (int i = 0; i < verticalEdge.size(); i++) {
            if (!verticalEdge.get(i).hasOwner()) {
                hasVLeft = true;
            }
        }

        for (int i = 0; i < horizontalEdge.size(); i++) {
            if (!horizontalEdge.get(i).hasOwner()) {
                hasHLeft = true;

            }
        }
    }

    public int choseVEdge() {
        int x;

        x = (int) (Math.random() * verticalEdge.size());

        while (verticalEdge.get(x).hasOwner()) {
            verticalEdge.remove(x);
            x = (int) (Math.random() * verticalEdge.size());

        }

        return x;
    }

    public int choseHEgde() {
        int x;
        x = (int) (Math.random() * horizontalEdge.size());

        while (horizontalEdge.get(x).hasOwner()) {
            horizontalEdge.remove(x);
            x = (int) (Math.random() * horizontalEdge.size());

        }

        return x;
    }


    public void pvMMachineAction() {
        int x;

        int isV;

        if (hasHLeft) {

            if (!hasVLeft)
                isV = 0;
            else
                isV = (int) (Math.random() * 2);


        } else {
            if (hasVLeft)
                isV = 1;

            else
                isV = -1;

        }

        if (isV == 1) {
            x = choseVEdge();
            verticalEdge.get(x).click();
            verticalEdge.remove(x);
        }
        if (isV == 0) {
            x = choseHEgde();
            horizontalEdge.get(x).click();
            horizontalEdge.remove(x);
        }
    }

    public void setEgg() {

        Boolean player1 = false;
        Boolean player2 = false;

        int x;
        int isV = (int) (Math.random() * 2);

        int P = (int) (Math.random() * 100);

        if (P >= 70)
            player1 = true;

        int S = (int) (Math.random() * 100);

        if (S >= 60)
            player2 = true;

        if (player1 && (!player2)) {
            result = 1;

            if (isV == 1) {
                x = choseVEdge();
                verticalEdge.get(x).eggplayer1();
                frame.repaint();
                verticalEdge.remove(x);

            } else if (isV == 0) {
                x = choseHEgde();
                horizontalEdge.get(x).eggplayer1();
                frame.repaint();
                horizontalEdge.remove(x);
            }
        } else if ((!player1) && player2) {
            result = 2;
            if (isV == 1) {
                x = choseVEdge();
                verticalEdge.get(x).eggplayer2();
                frame.repaint();
                verticalEdge.remove(x);

            } else if (isV == 0) {

                x = choseHEgde();
                horizontalEdge.get(x).eggplayer2();
                frame.repaint();
                horizontalEdge.remove(x);

            }
        } else if (player1 && player2)
            result = 0;
        else
            result = -1;


    }

    public void result(int x,int y) {
        if (map.getPlayer1().getScore() + map.getPlayer2().getScore() == x * y) {

            if (map.getPlayer1().getScore() > map.getPlayer2().getScore())
                showAmiyaWins();
            else if (map.getPlayer1().getScore() < map.getPlayer2().getScore())
                showProvenceWins();
            else
                showEven();

            map.getPlayer1().clearScore();
            map.getPlayer2().clearScore();
        }
    }

    public void showAmiyaWins() {
        frame.setVisible(false);
        AmiyaWins amiyaWins = new AmiyaWins(frame);
        amiyaWins.setVisible(true);
    }

    public void showProvenceWins() {

        ProvenceWins provenceWins = new ProvenceWins(frame);
        provenceWins.setVisible(true);

        frame.setVisible(false);
    }

    public void showEven() {

        Even even = new Even(frame);
        even.setVisible(true);

        frame.setVisible(false);
    }

    public void setEggSquare() {

        int rod = (int) (Math.random() * 100);

//        if (rod>=95)
//            eggSquare=1;
//        else
//            eggSquare=0;
        eggSquare = 1;

        if (eggSquare == 1) {
            int i = (int) (Math.random() * map.getXsize() - 1);
            int j = (int) (Math.random() * map.getYsize() - 1);

            map.squares[i][j].setEgg(true);
        }
    }


    public Boolean getHasVLeft() {
        return hasVLeft;
    }

    public Boolean getHasHLeft() {
        return hasHLeft;
    }
}
