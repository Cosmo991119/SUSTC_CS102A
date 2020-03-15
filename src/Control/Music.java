/**
 * Copyright (C),2015-2019,XXX
 * FlieName:Music
 * Author:zhang
 * Date: {DATE}23:01
 * Description:
 * History:
 * <Author>    <Time>    <Vesion>    <Desc>
 * 作者姓名    修改时间   版本号      描述
 */
package Control;


import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Music extends JFrame {
    private File f;
    private URI uri;
    private URL url;
    private AudioClip aau;

    public Music() {
        try {
            System.out.println("start");
            f = new File(System.getProperty("user.dir")+"/Music/Summer.wav");
            uri = f.toURI();
            url = uri.toURL();

            aau = Applet.newAudioClip(url);

            aau.loop();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public void stopMusic(){
        aau.stop();
    }


}
