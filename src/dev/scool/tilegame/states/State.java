package dev.scool.tilegame.states;

import dev.scool.tilegame.Handler;

import java.awt.*;

public abstract class State {

    protected Handler handler;

    public State(Handler handler) {
        this.handler = handler;
    }

    // Universal for all states
    public abstract void tick();
    public abstract void render(Graphics g);


    private static State currentState = null;

    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() { return currentState; }



}
