
package project;

public class Game {
    public static final String basicLoad=System.getProperty("user.dir");
    private int width;
    private int height;

    private Player player1;
    private Player player2;
    private int x;
    private int y;

    private Player currentPlayer;

    private GameMap map;

    private int time;

    public Game(Player player1, Player player2, int width, int height, String name) {
        this.player1 = player1;
        this.player1.setName(name);
        this.player2 = player2;

        this.width = width;
        this.height = height;

        currentPlayer = player1;

    }

    public Player currentPlayer() {
        return currentPlayer;
    }

    public void nextPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

}
