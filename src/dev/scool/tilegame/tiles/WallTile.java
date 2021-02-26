package dev.scool.tilegame.tiles;


import dev.scool.tilegame.gfx.Assets;

public class WallTile extends Tile{
    public WallTile(int id) {
        super(Assets.wall, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
