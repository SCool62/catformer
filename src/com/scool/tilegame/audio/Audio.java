package com.scool.tilegame.audio;


import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {

    private Clip clip;
    private String path;
    private File file;

    public Audio(String path) {

        this.path = path;

        file = new File(this.path);
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            System.exit(1);
        }


    }

    public void start() { clip.start(); }
    public void play() { start(); }
    public void stop() { clip.stop(); }
    public void restart() {
        stop();
        clip.setMicrosecondPosition(0);
        start();
    }
    public void close() {
        stop();
        clip.close();
    }
    public void loop(int count) { clip.loop(count); }
    public void loop() { clip.loop(999999999); }
    public void reload() {
        close();
        file = new File(this.path);
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    // GETTERS AND SETTERS
    public Clip getClip() { return clip; }
    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }
    public File getFile() { return file; }
}
