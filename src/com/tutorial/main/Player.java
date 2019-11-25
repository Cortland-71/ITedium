package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
    private Random rand = new Random();
    private int direction = 0;
    private int vel = 0;

    public Player(int x, int y, ID id, int vel) {
        super(x, y, id);
        this.vel = vel;

        setVelX(vel);
        setVelY(vel);
    }

    @Override
    public void tick() {
        if (direction == 0) {
            x += getVelX();
            y += getVelY();
            if (y > Game.HEIGHT - 30 || x > Game.WIDTH - 10) {
                direction = 1;
            }
        }



    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 10, 10);
    }
}
