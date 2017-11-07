package com.mygdx.game;

import java.util.Random;

/**
 * Created by elena on 05.11.2017.
 */
public class Computer extends Gamer{

    Random rand;

    public Computer(Model model) {
       super(model);
        rand = new Random();
    }

    public int[] choiceStikcs(){
        return model.getRandSticks(step(model.getN()));

    }

    public int[] choiceDel(){
        return model.getRandSticks(step(model.getN()));
    }

    private int step(int n){
        int s = n % (model.getM()+1);
        if (s != 0) return s;
        else
            return rand.nextInt(model.getM());
    }
}
