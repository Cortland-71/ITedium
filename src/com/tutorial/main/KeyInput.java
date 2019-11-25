package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (GameObject obj : handler.getObjects()) {
            if (obj.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) obj.setVelY(-3);
                if (key == KeyEvent.VK_S) obj.setVelY(3);
                if (key == KeyEvent.VK_D) obj.setVelX(3);
                if (key == KeyEvent.VK_A) obj.setVelX(-3);

            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (GameObject obj : handler.getObjects()) {
            if (obj.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) obj.setVelY(0);
                if (key == KeyEvent.VK_S) obj.setVelY(0);
                if (key == KeyEvent.VK_D) obj.setVelX(0);
                if (key == KeyEvent.VK_A) obj.setVelX(0);

            }
        }
    }
}
