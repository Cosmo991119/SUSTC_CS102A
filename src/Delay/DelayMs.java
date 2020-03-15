/**
 * Copyright (C),2015-2019,XXX
 * FlieName:DelayMs
 * Author:zhang
 * Date: {DATE}19:44
 * Description:
 * History:
 * <Author>    <Time>    <Vesion>    <Desc>
 * 作者姓名    修改时间   版本号      描述
 */
package Delay;

import java.awt.*;

public class DelayMs {
    private Robot robot;
   public DelayMs(){
        try {
            robot=new Robot();
        }catch (AWTException E){}
    }
    public boolean delay(int time){
        robot.delay(time);
        return true;
    }
}
