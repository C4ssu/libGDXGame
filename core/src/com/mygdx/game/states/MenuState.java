package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.objects.Button2D;

/**
 * Created by Kassu on 9.11.2017.
 */

public class MenuState extends State implements InputProcessor {

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
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void update(float dt) {

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

    //-------------------------- Inputs
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        System.out.println(screenX+", "+screenY+" : "+pointer+", "+button);
        if(this.button.contains(screenX, screenY))
            gsm.set(new PlayState(gsm));
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
