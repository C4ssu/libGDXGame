package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Kassu on 9.11.2017.
 */

public class Button2D {
    private Texture texture;
    public Vector2 pos;
    public Vector2 scale;

    public Button2D(String texture, Vector2 pos, float scale){
        this.texture = new Texture(texture);
        this.scale = new Vector2(
                this.texture.getWidth(),
                this.texture.getHeight()
        ).scl(scale);
        this.pos = pos.sub(this.scale.cpy().scl(0.5f));
    }

    public Texture getTexture(){ return texture; }

    public boolean contains(float x, float y){
        return x >= pos.x && y >= pos.y
                && x <= pos.x+scale.x && y <= pos.y+scale.y;
    }

    public void dispose(){
        texture.dispose();
    }
}
