/**
 * Copyright (C),2015-2019,XXX
 * FlieName:UserSignAndLogin
 * Author:zhang
 * Date: {DATE}10:22
 * Description:
 * History:
 * <Author>    <Time>    <Vesion>    <Desc>
 * 作者姓名    修改时间   版本号      描述
 */
package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class UserSignAndLogin {
    private String userName="";
    private String userPassword="";
    static final public String basicLoad=System.getProperty("user.dir");
    static final private String userListLoad=basicLoad+"/user.txt";
    private boolean userExist=false;
    private File userList=null;
    public UserSignAndLogin(String userName,String userPassword) {
        try {
        this.userList=new File(userListLoad);
        if (FindUser(userName,userList)){
            FileWriter fileWriter=new FileWriter(userList,true);
            fileWriter.write(userName+" "+userPassword+"\r\n");
            fileWriter.close();
            File userData=new File(basicLoad+"/"+userName);
            if (!userData.exists()){
                userData.mkdirs();}
        }
        else {userExist=true;}}catch (IOException E){}
    }
    private boolean FindUser(String userName,File userList) {
        try {
            if (!userList.exists()){
                userList.createNewFile();
            }
            Scanner scanner=new Scanner(userList);
            while (scanner.hasNext()){
                if (scanner.nextLine().equals(userName)){
                    return false;}//User exist,Sign Error
            }
            return true;
        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean getUserExist(){return this.userExist;}
    public String getUserName(){return this.userName;}
    static public int UserSignTest (String userName,String userPassword){
        try {
        File userList=new File(userListLoad);
        Scanner scanner=new Scanner(userList);
        String readedUserName,readedUserPassword;
        boolean nameError=true,passwordError=true;
        //0:no username.   1: all right.   2:userpassword error
        while (scanner.hasNext()){
            readedUserName=scanner.next();
            readedUserPassword=scanner.next();
            if (readedUserName.equals(userName)){
                nameError=false;
                if (readedUserPassword.equals(userPassword)){passwordError=false;}
            }
        }
        if (nameError){return 0;}
        else if (passwordError){return 2;}
        return 1;}catch (FileNotFoundException E){return -1;}
    }
    static public void delUser(){try {
        FileWriter fileWriter=new FileWriter(userListLoad);
        fileWriter.write("");
        fileWriter.close();}catch (IOException E){}
    }
}
