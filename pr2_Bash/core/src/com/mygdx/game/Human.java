package com.mygdx.game;

public class Human extends Gamer{

    public Human(Model model, String name) {
       super(model); this.name = name;
    }

    @Override
    public int[] choiceStikcs() {
        return new int[0];
    }

//    public int getTake() {
//        return take;
//    }
//
//    public void clearTake(){
//        take = 0;
//    }
//
//    public void inkChoice(){
//        take++;
//    }


}
