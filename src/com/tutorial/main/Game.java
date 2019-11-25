package com.tutorial.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.nio.Buffer;
import java.util.Random;

public class Game extends Canvas implements Runnable{

    public static final int WIDTH = 640, HEIGHT = WIDTH/12 * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private Player player;
    private Random rand = new Random();

    public Game() {
        handler = new Handler();
        player = new Player(Game.WIDTH/2, Game.HEIGHT/2, ID.Player);

        handler.addObject(player);
        handler.addObject(new BasicEnemy(Game.WIDTH/2, Game.HEIGHT/2, ID.Enemy));
        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "GAME", this);

    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1_000_000_000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            boolean shouldRender = false;
            while (delta >= 1) {
                tick();
                delta--;
                shouldRender = true;
            }

            if (shouldRender) {
                render();
                frames++;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
    }
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0,0, WIDTH, HEIGHT);
        handler.render(g);

        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Game().start();
    }
}
