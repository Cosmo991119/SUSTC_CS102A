
package Control;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class LANServer {
    protected int port=9527;
    private ServerSocket serverSocket;
    private Socket socket;
    protected InputStream inputStream;
    protected OutputStream outputStream;
    public LANServer(int port){
        try {
            this.port=port;
            serverSocket=new ServerSocket(this.port);}
        catch (IOException E){
        }
    }
    public LANServer(){
        try {
            serverSocket=new ServerSocket(9527);}
        catch (IOException E){}
    }
    public String setSocket(){//Calling this method freezes the process until the link is successfully established
        try {
            this.socket = serverSocket.accept();
            inputStream=socket.getInputStream();
            outputStream=socket.getOutputStream();
            return "Socket set success";
        }catch (IOException e){
            return "Socket set error";
        }
    }
    public boolean LANWrite(byte[] bytes){
        try {
            outputStream.write(bytes.length);
            outputStream.write(bytes);
            outputStream.flush();
            return true;
        }catch (IOException e){
            return false;
        }
    }
    public byte[] LANread(){
        byte[] re=new byte[8];
        for (int i=0;i<8;i++){
            re[i]=-1;
        }
        try {
            int length=inputStream.read();
            for (int i=0;i<length;i++){
                re[i]=(byte)inputStream.read();
            }
            return re;
        }catch (IOException E){
            return re;
        }
    }
    public void closeAll(){
        try {
            inputStream.close();
            outputStream.close();
            socket.close();
            serverSocket.close();
        }catch (IOException E){}
    }
    static public String showLocalIPAddress(){
        try {
            return InetAddress.getLocalHost().toString();
        }catch (UnknownHostException e){
            return "Show local ip address error";
        }
    }
}
