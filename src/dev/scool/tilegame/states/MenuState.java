package dev.scool.tilegame.states;

import dev.scool.tilegame.Handler;
import dev.scool.tilegame.gfx.Assets;
import dev.scool.tilegame.ui.ClickListener;
import dev.scool.tilegame.ui.UIImageButton;
import dev.scool.tilegame.ui.UIManager;

import java.awt.*;

public class MenuState extends State{

    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.btn_start, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();

        // TODO Temporarily automatically enter the gameState for Dev perpeses
        //handler.getMouseManager().setUiManager(null);
        //State.setState(handler.getGame().gameState);
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }
}
