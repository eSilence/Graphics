package com.mygdx.game;

/*
 Баше — математическая игра, в которой два игрока из кучки, содержащей первоначально N предметов,
 по очереди берут не менее одного и не более М предметов. Проигравшим считается тот, кому нечего брать.
 https://ru.wikipedia.org/wiki/%D0%91%D0%B0%D1%88%D0%B5_(%D0%B8%D0%B3%D1%80%D0%B0)
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Model {
    final int N;
    int n;
    int m;
    Stick [] sticks;
    int space ;

    public Model(int n, int m) {
        this.N = n;
        this.n = n;
        this.m = m;
        sticks = new Stick[n];
        space = (Gdx.graphics.getWidth() - 20)  / n;
        for (int i = 0; i < n; i++) {
            sticks[i] = new Stick(new Vector2(i * space +20,Gdx.graphics.getHeight()*1/4) );
            sticks[i].setTexture(new Texture("stick.jpg"));
        }
    }

    public Vector2 getSticks(int i) {
        return sticks[i].getPosition();
    }

    public int inSticks(Vector2 vect){
        for (int i = 0; i < N ; i++) {
            Vector2 v = vect.cpy().sub(sticks[i].getPosition());
            if (v.x >= 0 && v.x <= Stick.getMyTexture().getWidth() && v.y >= 0 && v.y <= Stick.getMyTexture().getHeight())
                return i;
        }
        return -1;
    }

    public int getN(){return n;}

    public int getM() {return m; }

    public void delSticks(int[] delStiks){
        for (int i = 0; i < delStiks.length ; i++) {
            delStick(i);
        }
    }

    public void delStick(int num){
        sticks[num].delStick();
        n--;
    }

    public void choiceSticks(int[] delStiks){
        for (int i = 0; i < delStiks.length ; i++) {
            choiceStick(i);
        }
    }

    public void choiceStick(int num){
        sticks[num].choiceStick();
    }


    public int[] getRandSticks(int count){
        Random rand = new Random();
        int []result = new int[count];
        int []indx = new int[n];

        for (int i = 0, k = 0; i < N; i++) {
            if (!sticks[i].isStatusDel())
                indx[k++] = i;
        }

        int k;
        for (int i = 0; i < n; i++) {
            do {
                k = rand.nextInt(n);
            }
            while (indx[k] != -1);
            result[i] = indx[k];
            indx[k] = -1;
        }
            return result;
    }

    public void render(SpriteBatch batch){
        for (int i = 0; i < N; i++) {
            sticks[i].render(batch);
        }

    }
}
