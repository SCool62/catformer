package dev.scool.tilegame;


public class Launcher {
    // TODO rename main package to com.scool.tilegame
    public static String version = "v Alpha 1.0";
    public static void main(String[] args) {
        Game game = new Game("Tile Game! " + version, 640, 480);
        game.start();
    }



}
