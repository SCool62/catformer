package com.scool.tilegame.audio;

public class AudioAssets {

    public static Audio hurtSound;

    public static void init() {

        // Player sounds
        hurtSound = new Audio("/resources/sounds/catformer_hurt_sound.wav");
    }

}
