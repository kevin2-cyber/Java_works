package com.digerati.upmap;

import java.awt.*;

public class UgMap extends Canvas {

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.CYAN);
        Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage("C:/Users/Kimi/Desktop/github/Java_works/JavaFx/App/src/com/digerati/upmap/map_info.png");
        g.drawImage(i, 10,10,this);
    }
}
