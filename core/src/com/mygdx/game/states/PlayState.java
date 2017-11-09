package com.mygdx.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Kassu on 9.11.2017.
 */

public class PlayState extends State {

    protected PlayState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
