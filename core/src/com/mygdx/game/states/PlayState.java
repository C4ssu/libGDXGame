package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by Kassu on 9.11.2017.
 */

public class PlayState extends State implements InputProcessor {

    private TiledMap map;
    private OrthographicCamera cam;
    private TiledMapRenderer tmr;

    protected PlayState(GameStateManager gsm) {
        super(gsm);

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        cam = new OrthographicCamera();
        cam.setToOrtho(false,w,h);
        cam.update();
        map = new TmxMapLoader().load("testi.tmx");
        tmr = new OrthogonalTiledMapRenderer(map);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cam.update();
        tmr.setView(cam);
        tmr.render();
    }

    @Override
    public void dispose() {
        map.dispose();
    }

    //-------------------------- Inputs
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch(keycode){
            case Input.Keys.LEFT:
                cam.translate(-32,0);
                break;
            case Input.Keys.RIGHT:
                cam.translate(32,0);
                break;
            case Input.Keys.UP:
                cam.translate(0,32);
                break;
            case Input.Keys.DOWN:
                cam.translate(0,-32);
                break;
            case Input.Keys.NUM_1:
                map.getLayers().get(0).setVisible(!map.getLayers().get(0).isVisible());
                break;
            case Input.Keys.NUM_2:
                map.getLayers().get(1).setVisible(!map.getLayers().get(1).isVisible());
                break;
            default:
                return false;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    private int touchX, touchY;
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touchX = screenX;
        touchY = screenY;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        cam.translate(touchX-screenX,screenY-touchY);
        touchX = screenX;
        touchY = screenY;
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
