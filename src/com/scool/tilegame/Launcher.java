package com.scool.tilegame;


public class Launcher {
    public static String version = "v Alpha 1.0";
    public static void main(String[] args) {
        Game game = new Game("Catformer " + version, 640, 480);
        game.start();
    }



}
