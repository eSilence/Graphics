package com.mygdx.game;

import java.util.Random;

public class Computer extends Gamer{

    public Computer(Model model, String name) {
       super(model);
       this.name = name;
    }

    @Override
    public int[] choiceStikcs(){
        int []res =  model.getRandSticks(step(model.getN()));
        return res;
    }

    private int step(int n){
        Random rand = new Random();
        int s = n % (model.getM()+1);
        if (s != 0) return s;
        else
            return rand.nextInt(model.getM()-1)+1;
    }
}
