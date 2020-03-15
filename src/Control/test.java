/**
 * Copyright (C),2015-2019,XXX
 * FlieName:test
 * Author:zhang
 * Date: {DATE}18:27
 * Description:
 * History:
 * <Author>    <Time>    <Vesion>    <Desc>
 * 作者姓名    修改时间   版本号      描述
 */
package Control;

public class test {
    public static void main(String[] args) {
        LANServer lanServer = new LANServer();
        System.out.println(lanServer.setSocket());
        while (true) {
            byte[] bytes = new byte[8];
            for (int i=0;i<8;i++){
                bytes[i]=(byte) (i+10);
            }
            lanServer.LANWrite(bytes);
        }
    }
}
