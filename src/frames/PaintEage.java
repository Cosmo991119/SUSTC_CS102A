/**
 * Copyright (C),2015-2019,XXX
 * FlieName:PaintEage
 * Author:zhang
 * Date: {DATE}14:35
 * Description:
 * History:
 * <Author>    <Time>    <Vesion>    <Desc>
 * 作者姓名    修改时间   版本号      描述
 */
package frames;

import project.GameMap;
import project.Player;

import javax.swing.*;
import java.awt.*;

public class PaintEage extends JComponent {
    private int xLocation;
    private int yLocation;

    private boolean isVertical;

    private int startX;
    private int startY;
    private int endX;
    private int endY;

    private GameMap map;
    private Player owner;
    private Boolean hasVLeft = false;
    private Boolean hasHLeft = false;
    private String Location;


    public Boolean isVedge = false;
    private JFrame frame;


    public PaintEage(GameMap map, int x, int y, boolean isVertical) {

        this.map = map;
        this.xLocation = x;
        this.yLocation = y;
        this.Location=x+","+y;
        this.isVertical = isVertical;
        setLocation(x, y);

        if (!isVertical) {
            setSize(81, 31);
            startX = 30;
            startY = 10;
            endX = 80;
            endY = 30;

        } else {
            setSize(31, 81);
            startX = 10;
            startY = 30;
            endX = 30;
            endY = 80;

        }

    }

    public void click() {
        owner = map.currentPlayer();

        map.nextTurn();
    }

    public void  eggplayer1(){
        owner = map.getPlayer1();
    }

    public void  eggplayer2(){
        owner = map.getPlayer2();
    }

    public boolean hasOwner() {
        return owner != null;
    }

    public int getxLocation() {
        return xLocation;
    }

    public int getyLocation() {
        return yLocation;
    }


    public String getCorrdinate() {
        return Location;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public Player getOwner() {
        return owner;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(255, 255, 255));

        if (!isVertical) {
            g.drawLine(startX, startY, endX, startY);
            g.drawLine(startX, endY, endX, endY);
        } else {
            g.drawLine(startX, startY, startX, endY);
            g.drawLine(endX, startY, endX, endY);
        }

        if (hasOwner()) {
            g.setColor(owner.getColor());
            g.fillRect(startX, startY, endX, endY);
            System.out.println("Edge Painting");
        }

    }

}
