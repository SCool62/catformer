package com.scool.tilegame.states;

import com.scool.tilegame.Handler;
import com.scool.tilegame.tiles.Tile;
import com.scool.tilegame.world.World;

import java.awt.*;

public class GameState extends State {

    private World world;
    public int level;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "resources/worlds/world"+ level +".txt");
        handler.setWorld(world);
    }

    @Override
    public void tick() {
        world.tick();
        if (handler.getWorld().getTile((int) handler.getWorld().getEntityManager().getPlayer().getX(),
                (int) handler.getWorld().getEntityManager().getPlayer().getY()) == Tile.lavaTile)
            State.setState(handler.getGame().endState);
    }

    @Override
    public void render(Graphics g) { world.render(g); }
}
