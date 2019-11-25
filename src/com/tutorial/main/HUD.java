package com.tutorial.main;

import java.awt.*;

public class HUD {

    public static int HEALTH = 100;

    public void tick() {
        HEALTH = Game.clamp(HEALTH, 0, 100);

    }
    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(20,20,200, 12);

        g.setColor(Color.GREEN);
        g.fillRect(20,20,HEALTH*2, 12);

        g.setColor(Color.WHITE);
        g.drawRect(20,20,200, 12);
    }
}
