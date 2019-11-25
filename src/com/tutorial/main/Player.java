package com.tutorial.main;

import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y, ID id, int vel) {
        super(x, y, id);
        setVelX(vel);
    }

    int state = 0;
    @Override
    public void tick() {

        System.out.println("X: " + x);
        if (state == 0) {
            x += getVelX();
            if (x > Game.WIDTH-10) {
                state = 1;
            }
        }

        if (state == 1) {
            x += -getVelX();
            if (x < 0) {
                state = 0;
            }
        }

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 10, 10);
    }
}
