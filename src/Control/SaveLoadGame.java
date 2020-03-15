package project;

import frames.PlayGameFrame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SaveLoadGame {
    private Game game=null;
    private Date date=new Date();
    private String name="";
    private File gameList=new File(Game.basicLoad+"/"+this.name+"/"+"gameList.txt");
    private PlayGameFrame playGameFrame;

    private ArrayList<String> playerList=new ArrayList<>();
    private ArrayList<String> gameLi=new ArrayList<>();
    private ArrayList<Integer> xLyList=new ArrayList<>();
    private ArrayList<Integer> yList=new ArrayList<>();
    private File gamefile=new File(Game.basicLoad+"/"+this.name+"/"+date.toString()+".txt");
    public void save(){
        try {
            FileWriter fileWriter=new FileWriter(gamefile);
            FileWriter fileWriter1=new FileWriter(gameList);
            fileWriter1.write(game.getPlayer1().getName()+" LOAD "+Game.basicLoad+"\\"+this.name+"\\"+date.toString()+".txt");
            fileWriter1.flush();
            for (int i=0;i<PlayGameFrame.xList.size();i++){
                fileWriter.write(PlayGameFrame.xList.get(i));
                fileWriter.write(PlayGameFrame.yList.get(i));
                fileWriter.write("\r\n");
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadList(){
        String tran;
        try {
            Scanner scanner=new Scanner(gameList);
            while (scanner.hasNext()){
                tran=scanner.next();
                if (tran.equals("LOAD")){
                    scanner.nextLine();
                    gameLi.add(scanner.nextLine());
                }
                else {playerList.add(tran);}
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void loadGame(int i){
        Scanner scanner=new Scanner(gameLi.get(i));
        while (scanner.hasNext()){
            xLyList.add(scanner.nextInt());
            yList.add(scanner.nextInt());
        }
    }
    public void setName(String name){this.name=name;}
    public void setPlayGameFrame(PlayGameFrame playGameFrame){this.playGameFrame=playGameFrame;}
    public void setGame(Game game){this.game=game;}
}
