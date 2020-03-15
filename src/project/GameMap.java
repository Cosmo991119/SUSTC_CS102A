
package project;


import EggCardFrame.EggCard;
import frames.PaintDot;
import frames.PaintEage;
import frames.PaintSquare;

import javax.swing.*;
import java.util.ArrayList;

public class GameMap {

    private Game game;

    private int xsize;
    private int ysize;
    public PaintEage[][] horEages;
    public PaintEage[][] verEages;

    public ArrayList<PaintDot> dots = new ArrayList<>();
    public PaintSquare[][] squares;
    
    public ArrayList<Integer> xlocation=new ArrayList<>();
    public ArrayList<Integer> ylocation=new ArrayList<>();

    private boolean shouldChangePlayer;

    private JFrame frame;

    public GameMap(Game game, JFrame frame) {
        this.game = game;
        this.frame = frame;
        this.xsize = game.getWidth();
        this.ysize = game.getHeight();

        setLocation(xsize,ysize);

        horEages = new PaintEage[xsize - 1][ysize];
        verEages = new PaintEage[xsize][ysize - 1];
        squares = new PaintSquare[xsize - 1][ysize - 1];

        setpaintingdot();
        setpaintingeage();
    }
    
    public void setLocation(int xsize,int ysize){
        for (int i = 0; i <xsize ; i++) {
            xlocation.add(xSart()+i*70);
        }
        for (int i = 0; i < ysize; i++) {
            ylocation.add(ySart()+i*70);
        }
    }

    private void setpaintingdot() {
        for (int i = 0; i < xsize; i++) {
            for (int j = 0; j < ysize; j++) {
                PaintDot dot = new PaintDot(xlocation.get(i), ylocation.get(j));
                dots.add(dot);
            }
        }
    }

    private void setpaintingeage() {

        for (int i = 0; i < xsize - 1; i++) {
            for (int j = 0; j < ysize; j++) {
                PaintEage eage = new PaintEage(this, xlocation.get(i), ylocation.get(j), false);
                horEages[i][j] = eage;
            }
        }

        for (int i = 0; i < xsize; i++) {
            for (int j = 0; j < ysize - 1; j++) {
                PaintEage eage = new PaintEage(this, xlocation.get(i), ylocation.get(j), true);
                verEages[i][j] = eage;
            }
        }

        for (int i = 0; i < xsize - 1; i++) {
            for (int j = 0; j < ysize - 1; j++) {
                PaintSquare square = new PaintSquare(this, xlocation.get(i), ylocation.get(j));
                squares[i][j] = square;
            }
        }
    }

    public Player currentPlayer() {
        return game.currentPlayer();
    }

    public Player getPlayer1(){
        return game.getPlayer1();
    }

    public Player getPlayer2(){
        return game.getPlayer2();
    }


    public void nextTurn() {
       shouldChangePlayer = true;

        for (int i = 0; i < xsize - 1; i++) {
            for (int j = 0; j < ysize - 1; j++) {
                PaintSquare square = squares[i][j];
                if (square.hasOwner()) {
                    continue;
                }
                if (horEages[i][j].hasOwner() && horEages[i][j + 1].hasOwner() &&
                        verEages[i][j].hasOwner() && verEages[i + 1][j].hasOwner()) {
                    shouldChangePlayer = false;


                    new Thread(() -> {

                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        if (square.getEgg())
                            showStory();

                    }).start();

                    square.setOwner(currentPlayer());
                    currentPlayer().setScore(1);

                }
            }
        }

        if (shouldChangePlayer){
            game.nextPlayer();
            System.out.println("change Player");
        }

        frame.repaint();
        System.out.println("painting");

    }

    private void showStory(){
        EggCard eggCard=new EggCard(frame);
        eggCard.setVisible(true);
    }



    private int xSart() {
        int xsart;
        if (xsize % 2 == 0) {
            xsart = 525 - (xsize / 2 - 1) * 90 - 120;
        } else {
            xsart = 525 - (xsize / 2) * 90 - 85;
        }
        return xsart;
    }

    private int ySart() {

        int ystart;

        if (ysize % 2 == 0) {
            ystart = 375 - (ysize / 2 - 1) * 90 - 80;
        } else {
            ystart = 375 - (ysize / 2) * 90 - 45;
        }
        return ystart;
    }

    public int getXsize() {
        return xsize;
    }

    public int getYsize() {
        return ysize;
    }

    public Game getGame() {
        return game;
    }



    public PaintEage[][] getHorEages() {
        return horEages;
    }

    public PaintEage[][] getVerEages() {
        return verEages;
    }

    public ArrayList<PaintDot> getDots() {
        return dots;
    }

    public PaintSquare[][] getSquares() {
        return squares;
    }

    public boolean isShouldChangePlayer() {
        return shouldChangePlayer;
    }
}
