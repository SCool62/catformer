package com.scool.tilegame.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    // STATIC STUFF HERE
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);
    public static Tile wallTile = new WallTile(2);
    public static Tile lavaTile = new LavaTile(3);
    public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;


    // CLASS
    protected BufferedImage texture;
    protected final int id;


    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;
        tiles[id] = this;
    }

    public int getId() { return id; }

    public void tick() {}
    public void render(Graphics g, int x, int y) { g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null); }

    public boolean isSolid() { return true; }

}
