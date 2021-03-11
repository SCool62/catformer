package com.scool.tilegame.entity;

import com.scool.tilegame.Handler;

import java.awt.*;

public abstract class Entity {

    protected Handler handler;
    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;
    protected int heath;
    protected boolean active = true;
    public static final int DEFAULT_HEATH = 10;

    public Entity(Handler handler, float x, float y, int width, int height) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        heath = DEFAULT_HEATH;

        bounds = new Rectangle(0, 0, width, height);
    }


    // Abstract Methods
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void die();

    public void hurt(int amt) {
        heath -= amt;
        if (heath <= 0) {
            active = false;
            die();
        }
    }

    public boolean checkEntityCollisions(float xOffset, float yOffset) {
        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this)) continue;
            if (e.getCollisionBounds(0, 0).intersects(getCollisionBounds(xOffset, yOffset)))
                return true;
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset) {
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
    }

    // Getters and Setters
    public float getX() { return x; }
    public void setX(float x) { this.x = x; }

    public float getY() { return y; }
    public void setY(float y) { this.y = y; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getHeath() { return heath; }
    public void setHeath(int heath) { this.heath = heath; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
