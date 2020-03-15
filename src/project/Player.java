
package project;

import java.awt.*;

public class Player {

    protected Color color;
    protected int score=0;
    protected int winPvM=0;
    private String name;
    public Boolean isRelease;


    public static final Player BLUE = new Player() {
        {
            color = new Color(176, 224, 230);
        }
    };

    public static final Player RED = new Player() {
        {
            color = new Color(255, 182, 193);
        }
    };

    public void clearScore(){
        score=0;
    }

    public void setWinPvM() {
        winPvM+= 1;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }

    public int getWin() {
        return winPvM;
    }

    public Color getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
