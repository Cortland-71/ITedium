package com.tutorial.main;

import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y, ID id) {
        super(x, y, id);
        setVelX(1);
    }

    @Override
    public void tick() {
        x += getVelX();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 50, 50);
    }
}
