package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by elena on 05.11.2017.
 */
public class Human extends Gamer{
    Model model;
    int take;
    int [] choiceSticks;

    public Human(Model model) {
       super(model);
    }

    @Override
    public int[] choiceStikcs() {
        return new int[0];
    }

    @Override
    public int[] choiceDel() {
//        Vector2 vect;
//        if (InputHandler.isClicked()) {
//            vect = InputHandler.getMousePosition();
//            vect.y = Gdx.graphics.getHeight() - vect.y;
//            int n = model.inSticks(vect);
//            System.out.println(n);
//            if (n != -1) {
//                model.choiceStick(n);
//            }
//        }
//
    return new int[0];
 }

    public int getTake() {
        return take;
    }

    public void clearTake(){
        take = 0;
    }

    public void inkChoice(){
        take++;
    }


}
