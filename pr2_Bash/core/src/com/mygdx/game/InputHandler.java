package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by elena on 05.11.2017.
 */
public class InputHandler {
    public static boolean isClicked(){
        return Gdx.input.justTouched();
    }

    public static Vector2 getMousePosition(){
        return new Vector2(Gdx.input.getX(), Gdx.input.getY());
    }
}
