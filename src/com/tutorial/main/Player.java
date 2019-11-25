package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    private Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {

        x += getVelX();
        y += getVelY();
        x = Game.clamp(x, 0, Game.WIDTH-16);
        y = Game.clamp(y, 0, Game.HEIGHT-38);

        collision();
    }

    private void collision() {
        for (GameObject obj : handler.getObjects()) {
            if (obj.getId() == ID.Enemy) {
                if(getBounds().intersects(obj.getBounds())) {
                    HUD.HEALTH -= 2;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillOval(x, y, 15, 15);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 15,15);
    }
}
