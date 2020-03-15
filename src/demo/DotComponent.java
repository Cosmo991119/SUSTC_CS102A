/**
 * Copyright (C),2015-2019,XXX
 * FlieName:DotComponent
 * Author:zhang
 * Date: {DATE}16:23
 * Description:
 * History:
 * <Author>    <Time>    <Vesion>    <Desc>
 * 作者姓名    修改时间   版本号      描述
 */
package demo;

import javax.swing.*;
import java.awt.*;

public class DotComponent extends JComponent {
    public DotComponent(int x, int y, int size) {
        super();
        setLocation(x, y);
        setSize(size, size);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        g2d.fillOval(0, 0, getWidth(), getHeight());
    }
}
