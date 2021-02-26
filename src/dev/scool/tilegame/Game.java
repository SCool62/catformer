package dev.scool.tilegame;

import dev.scool.tilegame.display.Display;
import dev.scool.tilegame.gfx.Assets;
import dev.scool.tilegame.gfx.GameCamera;
import dev.scool.tilegame.input.KeyManager;
import dev.scool.tilegame.input.MouseManager;
import dev.scool.tilegame.states.GameState;
import dev.scool.tilegame.states.MenuState;
import dev.scool.tilegame.states.SettingsState;
import dev.scool.tilegame.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

    // Stuff for the display and game
    private Display display;
    private int width, height;
    public String title;
    private BufferStrategy bs;
    private Graphics g;
    private KeyManager keyManager;
    private MouseManager mouseManager;

    // Camera
    private GameCamera gameCamera;

    private Handler handler;

    // Run Stuff
    private boolean running = false;
    private Thread thread;

    // States
    public State gameState;
    public State menuState;
    public State settingsState;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    // Initialize Game
    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0, 0);

        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        settingsState = new SettingsState(handler);
        State.setState(menuState);
    }

    // Tick the game
    private void tick() {
        keyManager.tick();

        if (State.getState() != null) State.getState().tick();
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        // Before Drawing
        g.clearRect(0, 0, width, height);
        // Draw
        if (State.getState() != null) State.getState().render(g);
        // End drawing
        bs.show();
        g.dispose();

    }

    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running) {

            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            if (timer >= 1000000000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    public KeyManager getKeyManager() { return keyManager; }

    public MouseManager getMouseManager() { return mouseManager; }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public GameCamera getGameCamera() { return gameCamera; }


    public synchronized void start() {
        if(running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop() {
        if(!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
