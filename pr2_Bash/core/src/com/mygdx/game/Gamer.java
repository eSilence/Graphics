package com.mygdx.game;

/**
 * Created by elena on 05.11.2017.
 */
public abstract class Gamer {
    Model model;

    public Gamer(Model model) {
        this.model = model;
    }
    public abstract int[] choiceDel();

    public abstract int[] choiceStikcs();

}
