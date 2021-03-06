package com.scool.tilegame.display;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Display {
    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width, height;
    private ImageIcon icon;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        System.out.println("Creating Window");
        icon = new ImageIcon("/textures/icon.jpg");

        createDisplay();

        System.out.println("Created Window");

    }


    // Init window
    private void createDisplay() {
        frame = new JFrame(title);
        frame.setIconImage(icon.getImage());
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }

}
