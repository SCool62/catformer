package dev.scool.tilegame.gfx;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {

    public static Font font28;

    public static BufferedImage dirt, grass, stone, tree, wall, player_idle;
    public static BufferedImage[] player_down, player_up, player_left, player_right;
    public static BufferedImage[] btn_start;

    private static final int width = 32, height = 32;


    public static void init() {


        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
        SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/textures/sheet_old1.png"));


        // Init Animations
        player_left = new BufferedImage[2];
        player_down = new BufferedImage[2];
        player_up = new BufferedImage[2];
        player_right = new BufferedImage[2];
        btn_start = new BufferedImage[2];

        // Player
        player_down[0] = sheet.crop(width * 4, 0, width, height);
        player_down[1] = sheet.crop(width * 5, 0, width, height);
        player_up[0] = sheet.crop(width * 6, 0, width, height);
        player_up[1] = sheet.crop(width * 7, 0, width, height);
        player_right[0] = sheet.crop(width * 4, height, width, height);
        player_right[1] = sheet.crop(width * 5, height, width, height);
        player_left[0] = sheet.crop(width * 6, height, width, height);
        player_left[1] = sheet.crop(width * 7, height, width, height);
        player_idle = sheet1.crop(width * 4, 0, width, height);

        // Tiles
        dirt = sheet.crop(width, 0, width, height);
        grass = sheet.crop(width * 2, 0, width, height);
        wall = sheet.crop(width * 3, 0, width, height);

        // Start Button
        btn_start[0] = sheet.crop(width * 6, height * 4, width * 2, height);
        btn_start[1] = sheet.crop(width * 6, height * 5, width * 2, height);
    }

}