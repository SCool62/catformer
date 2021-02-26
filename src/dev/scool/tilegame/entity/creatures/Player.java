package dev.scool.tilegame.entity.creatures;

import dev.scool.tilegame.Handler;
import dev.scool.tilegame.entity.Entity;
import dev.scool.tilegame.gfx.Animation;
import dev.scool.tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    //private Animation animDown, animUp, animLeft, animRight;
    //private int animSpeed = 500;
    // Attacks
    private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
    // Inventory


    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x = 22;
        bounds.y = 44;
        bounds.width = 19;
        bounds.height = 19;

        // Animations
        //animDown = new Animation(animSpeed, Assets.player_down);
        //animUp = new Animation(animSpeed, Assets.player_up);
        //animLeft = new Animation(animSpeed, Assets.player_left);
        //animRight = new Animation(animSpeed, Assets.player_right);


    }

    @Override
    public void tick() {
        //animDown.tick();
        //animUp.tick();
        //animLeft.tick();
        //animRight.tick();
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        // Attack
        checkAttacks();
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;
        if(handler.getKeyManager().up) yMove = -speed;
        if(handler.getKeyManager().down) yMove = speed;
        if(handler.getKeyManager().left) xMove = -speed;
        if(handler.getKeyManager().right) xMove = speed;
    }

    @Override
    public void render(Graphics g) {
        //g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }


    @Override
    public void die() {
        System.out.println("You Died. \nGame Over.");
    }

    /*private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {
            return animLeft.getCurrentFrame();
        } else if (xMove > 0) {
            return animRight.getCurrentFrame();
        } else if (yMove < 0) {
            return animUp.getCurrentFrame();
        } else if (yMove > 0) {
            return animDown.getCurrentFrame();
        } else {
            return Assets.player_idle;
        }
    }*/

    private void checkAttacks() {
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if (attackTimer < attackCooldown) return;


        Rectangle cb = getCollisionBounds(0f, 0f);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;
        if (handler.getKeyManager().aUp) {
            ar.x = cb.x + width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
        } else if(handler.getKeyManager().aDown) {
            ar.x = cb.x + width / 2 - arSize / 2;
            ar.y = cb.y - cb.height;
        } else if(handler.getKeyManager().aLeft) {
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else if(handler.getKeyManager().aRight) {
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else {
            return;
        }

        attackTimer = 0;

        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this)) continue;
            if (e.getCollisionBounds(0, 0).intersects(ar)) {
                e.hurt(1);
                return;
            }
        }

    }


}