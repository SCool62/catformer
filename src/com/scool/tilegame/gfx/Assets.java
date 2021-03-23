package com.scool.tilegame.gfx;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {

    public static Font font28;

    public static BufferedImage dirt, grass, stone, tree, wall, lava;
    public static BufferedImage player_idle, enemy_idle;
    public static BufferedImage[] player_down, player_up, player_left, player_right;
    public static BufferedImage[] enemy_down, enemy_up, enemy_left, enemy_right;

    public static BufferedImage[] btn_start;
    public static BufferedImage[] btn_restart;

    private static final int width = 32, height = 32;


    public static void init() {

        font28 = FontLoader.loadFont("/resources/fonts/DotGothic.ttf", 28);

        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
        SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/textures/sheet_old1.png"));
        SpriteSheet tiles = new SpriteSheet(ImageLoader.loadImage("/textures/tiles.png"));


        // Init Animations
        player_left = new BufferedImage[2];
        player_down = new BufferedImage[2];
        player_up = new BufferedImage[2];
        player_right = new BufferedImage[2];
        enemy_left = new BufferedImage[2];
        enemy_down = new BufferedImage[2];
        enemy_up = new BufferedImage[2];
        enemy_right = new BufferedImage[2];
        btn_start = new BufferedImage[2];
        btn_restart = new BufferedImage[2];

        // Player
        player_idle = ImageLoader.loadImage("/textures/player/player_idle.png");
        player_down[0] = player_idle;
        player_down[1] = player_idle;
        player_up[0] = sheet.crop(width * 6, 0, width, height);
        player_up[1] = sheet.crop(width * 7, 0, width, height);
        player_right[0] = player_idle;
        player_right[1] = player_idle;
        player_left[0] = sheet.crop(width * 6, height, width, height);
        player_left[1] = sheet.crop(width * 7, height, width, height);


        // Enemy
        enemy_idle = ImageLoader.loadImage("/textures/enemy/enemy_idle.png");
        enemy_down[0] = enemy_idle;
        enemy_down[1] = enemy_idle;
        enemy_right[0] = enemy_idle;
        enemy_right[1] = enemy_idle;

        // Tiles
        dirt = tiles.crop(0, 0, width, height);
        wall = tiles.crop(width, 0, width, height);
        grass = tiles.crop(width * 2, 0, width, height);
        lava = tiles.crop(width * 3, 0, width, height);

        // Start Button
        btn_start[0] = ImageLoader.loadImage("/textures/buttons/start.png");
        btn_start[1] = ImageLoader.loadImage("/textures/buttons/start_clicked.png");
        // Restart button
        btn_restart[0] = ImageLoader.loadImage("/textures/buttons/restart.png");
        btn_restart[1] = ImageLoader.loadImage("/textures/buttons/restart_clicked.png");
    }

}
