package Control;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class OnlinePlay {
    private LANCilent cilent = null;
    private LANServer server = null;
    public String IPofServer;

    public void setServer() {
        server = new LANServer();
        //
        IPofServer = getIPofServer();//must print
        //after this place, it will stop until linked.
        server.setSocket();
    }

    public void setCilent(String IpAddress) {
        //

        //after this place, it will stop until lin
        cilent = new LANCilent(IpAddress);
    }

    public void serverOUT(int out) {
        try {
                server.outputStream.write(intBreakToByte(out));
    
            server.outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int serverIN() {
        byte[] bytes = new byte[8];
        int in = 0;
        try {
            server.inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        in=byteConnectToInt(bytes);
        return in;
    }
    public void cilentOUT(int out){
            try {

                    cilent.outputStream.write(intBreakToByte(out));
                cilent.outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    public int cilentIN(){
        byte[] bytes=new byte[8];
        int ints=0;
            try {
                cilent.inputStream.read(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ints=byteConnectToInt(bytes);
            return ints;
    }
    public String getIPofServer(){
        try {
            return InetAddress.getLocalHost().toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    private byte[] intBreakToByte(int in){
        byte[] re=new byte[8];
        for (int i=0;i<7&&(in-i*126)>0;i++){
            if (in-i*126>126){
                re[i]=126;
            }
            else {re[i]=(byte)(in-i*126);}
        }
        return re;
    }
    private int byteConnectToInt(byte[] in){
        int re=0,i;
        for ( i=0;in[i]!=0&&i<8;i++){
            re+=in[i];
        }
        return re;
    }
}
