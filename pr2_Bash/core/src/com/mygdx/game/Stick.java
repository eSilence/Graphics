package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;



public class Stick {
    Vector2 position;
    private static Texture myTexture;
    private boolean statusChoice;
    private boolean statusDel;

    public Stick(Vector2 position) {
        this.position = position;
        statusChoice = true;
        statusDel = false;
    }

    public boolean isStatusChoice() {
        return statusChoice;
    }

    public boolean isStatusDel() {
        return statusDel;
    }

    public static Texture getMyTexture() {
        return myTexture;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void choiceStick(){
        statusChoice = !statusChoice;
        if (!statusChoice)
            position.y =  position.y - myTexture.getHeight()*1/5;
        else
            position.y =  position.y + myTexture.getHeight()*1/5;
    }

    public void delStick(){
        if (!statusChoice) {
            statusDel = true;
            setTexture(new Texture("fon.jpg"));
        }
    }

    public static void setTexture(Texture texture){
        Stick.myTexture = texture;
    }

//    public void update(){
//        if (status == Status.Yes)
//            setTexture(new Texture("stick.jpg"));
//        else
//            setTexture(new Texture("fon.jpg"));
//    }

    public void render(SpriteBatch batch){
        batch.draw(myTexture, position.x, position.y);
    }
}
