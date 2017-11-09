package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.mygdx.game.objects.Button2D;

/**
 * Created by Kassu on 9.11.2017.
 */

public class MenuState extends State {

    private Texture background;
    private Button2D button;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false);
        background = new Texture("background.jpg");
        button = new Button2D(
                "play.png",
                new Vector2(
                        cam.viewportWidth / 2,
                        cam.viewportHeight / 2
                ),
                cam.viewportWidth * 0.02f);
    }

    @Override
    protected void handleInput() {
        Vector2 pos = new Vector2(Gdx.input.getX(), Gdx.input.getY());
        if(Gdx.input.justTouched() && button.contains(pos)){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0, cam.viewportWidth, cam.viewportHeight);
        sb.draw(button.getTexture(), button.pos.x, button.pos.y, button.scale.x, button.scale.y);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        button.dispose();
    }
}
