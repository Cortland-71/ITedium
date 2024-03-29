package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (GameObject obj : handler.getObjects()) {
            if (obj.getId() == ID.Player) {
                if (key == KeyEvent.VK_UP) obj.setVelY(-3);
                if (key == KeyEvent.VK_DOWN) obj.setVelY(3);
                if (key == KeyEvent.VK_RIGHT) obj.setVelX(3);
                if (key == KeyEvent.VK_LEFT) obj.setVelX(-3);
            }
        }
        if (key == KeyEvent.VK_ESCAPE) System.exit(0);
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (GameObject obj : handler.getObjects()) {
            if (obj.getId() == ID.Player) {
                if (key == KeyEvent.VK_UP) obj.setVelY(0);
                if (key == KeyEvent.VK_DOWN) obj.setVelY(0);
                if (key == KeyEvent.VK_RIGHT) obj.setVelX(0);
                if (key == KeyEvent.VK_LEFT) obj.setVelX(0);
            }
        }
    }
}
