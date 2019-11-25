package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

        x += getVelX();
        y += getVelY();
        x = Game.clamp(x, 0, Game.WIDTH-16);
        y = Game.clamp(y, 0, Game.HEIGHT-38);

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 15, 15);
    }
}
