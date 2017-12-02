package com.mygdx.game;

public abstract class Gamer {
    Model model;
    String name;

    public Gamer(Model model) {
        this.model = model;
    }

    public abstract int[] choiceStikcs();
    public String getName(){return name;}
}
