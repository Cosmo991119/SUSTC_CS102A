
package frames;

import project.GameMap;
import project.Player;

import javax.swing.*;
import java.awt.*;


public class PaintSquare extends JComponent {
    private int xLocation;
    private int yLocation;

    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Boolean isEgg=false;


    private GameMap map;
    private Player owner;


    public PaintSquare(GameMap map, int x, int y) {
        this.map = map;
        xLocation = x;
        yLocation = y;

        setLocation(x, y);

        setSize(78, 78);
        startX = 33;
        startY = 33;
        endX = 78;
        endY = 78;

    }

    public void setOwner(Player belongTo) {
        this.owner = belongTo;
    }

    public boolean hasOwner(){
        return owner != null;
    }

    public Boolean getEgg() {
        return isEgg;
    }

    public void setEgg(Boolean egg) {
        isEgg = egg;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!hasOwner()){
            return;
        }

        g.setColor(owner.getColor());
        g.fillRect(startX, startY, endX, endY);
    }
}
