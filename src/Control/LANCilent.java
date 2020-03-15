package Control;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LANCilent extends LANServer {
    private Socket socket=null;
    protected InputStream inputStream=null;
    protected OutputStream outputStream=null;
    public LANCilent(String ipAddress){
        try {
            socket=new Socket(ipAddress,port);
            inputStream =socket.getInputStream();
            outputStream=socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
