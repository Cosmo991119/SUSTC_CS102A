/**
 * Copyright (C),2015-2019,XXX
 * FlieName:LanSet
 * Author:zhang
 * Date: {DATE}17:45
 * Description:
 * History:
 * <Author>    <Time>    <Vesion>    <Desc>
 * 作者姓名    修改时间   版本号      描述
 */
package Control;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class LanSet {
    public static void main(String[] args) throws IOException{
        init();
    }
    static public void init() throws IOException{
        System.out.println(InetAddress.getLocalHost());
        ServerSocket serverSocket=new ServerSocket(9527);
        Socket socket=serverSocket.accept();
        InetAddress address=socket.getInetAddress();
        System.out.println(address.getHostAddress());
        new Server(socket).inout();
    }
    static class Server{
        Socket socket;

        public Server(Socket socket){
            this.socket=socket;
        }
        public void  inout()throws IOException {
            InputStream input=socket.getInputStream();
            OutputStream output=socket.getOutputStream();
            Scanner scanner=new Scanner(System.in);
            try {
                while (true){byte[] bytes=new byte[16];
                    input.read(bytes);
                    String s=new String(bytes);
                    String out="";
                    for (int i=0;i<s.length();i++){
                        if (s.charAt(i)!=0){out+=s.charAt(i);}
                    }
                    if (bytes[0]!=0) {
                        System.out.print(out);
                    }
                    if(out.equals("EEE")){break;}
                }
            }catch (IOException E){
                System.out.println("error");
            }
        }
    }
}
