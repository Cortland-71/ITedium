package com.tutorial.main;

import java.awt.*;

public class BasicEnemy extends GameObject {
    public BasicEnemy(int x, int y, ID id, int vel) {
        super(x, y, id);
        setVelX(vel);
        setVelY(vel);
    }

    @Override
    public void tick() {
        x += getVelX();
        y += getVelY();
        if (y <= 0 || y >= Game.HEIGHT-38) setVelY(getVelY() * -1);
        if (x <= 0 || x >= Game.WIDTH-16) setVelX(getVelX() * -1);

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 20,20);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 20,20);
    }
}
