package com.scool.tilegame;

import com.scool.tilegame.gfx.GameCamera;
import com.scool.tilegame.input.KeyManager;
import com.scool.tilegame.input.MouseManager;
import com.scool.tilegame.world.World;

public class Handler {

    private Game game;
    private World world;

    public Handler(Game game) {
        this.game = game;
    }

    public int getWidth() {
        return game.getWidth();
    }

    public int getHeight() {
        return game.getHeight();
    }

    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }

    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }

    public GameCamera getGameCamera() {
        return game.getGameCamera();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }


}
