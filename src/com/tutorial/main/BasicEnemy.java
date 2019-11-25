package com.tutorial.main;

import java.awt.*;

public class BasicEnemy extends GameObject {
    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
        x += getVelX();
        y += getVelY();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 12,12);
    }
}
