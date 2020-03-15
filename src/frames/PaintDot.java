/**
 * Copyright (C),2015-2019,XXX
 * FlieName:dot
 * Author:zhang
 * Date: {DATE}20:06
 * Description:
 * History:
 * <Author>    <Time>    <Vesion>    <Desc>
 * 作者姓名    修改时间   版本号      描述
 */
package frames;

import javax.swing.*;
import java.awt.*;

public class PaintDot extends JComponent {
    private int xLocation;
    private int yLocation;

    public PaintDot(int x, int y) {
        xLocation = x;
        yLocation = y;
        setSize(30, 30);
        setLocation(x, y);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        Color setColor = new Color(255, 246, 143);

//       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(setColor);
        g2d.fillOval(10, 10, 20, 20);
    }
}
