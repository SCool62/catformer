package dev.scool.tilegame.states;

import dev.scool.tilegame.Handler;
import dev.scool.tilegame.world.World;

import java.awt.*;

public class GameState extends State {

    private World world;
    private int worldNumber = 1;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "resources/worlds/world"+ worldNumber +".txt");
        handler.setWorld(world);
    }

    @Override
    public void tick() {
        world.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }
}
