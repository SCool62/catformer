package com.scool.tilegame.states;

import com.scool.tilegame.Handler;
import com.scool.tilegame.gfx.Assets;
import com.scool.tilegame.gfx.Text;
import com.scool.tilegame.ui.ClickListener;
import com.scool.tilegame.ui.UIImageButton;
import com.scool.tilegame.ui.UIManager;

import java.awt.*;

public class EndState extends State{

    private UIManager uiManager;

    public EndState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.btn_restart, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
    }

    @Override
    public void tick() {
        // TODO uncomment 'uiManger.tick()' when textures created
        //  -uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        Text.drawString(g, "Game over", 200, 100, true, new Color(0, 0, 0), Assets.font28);
        uiManager.render(g);
    }
}
