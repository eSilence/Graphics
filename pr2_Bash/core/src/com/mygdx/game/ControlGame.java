package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class ControlGame {
    Model model;
    BitmapFont bmf;
    int countChosen;
    Gamer gamer1;
    Gamer gamer2;
    Gamer curentGamer;
    Gamer nextGamer;
    enum Status {START, GO, FINISH};
    Status isGo;


    public ControlGame(Model model) {
        this.model = model;
        bmf = new BitmapFont(Gdx.files.internal("myfont.fnt"), Gdx.files.internal("myfont.png"), false);
        countChosen = 0;
        gamer1 = new Human(model, new String("Human Bill"));
        gamer2 = new Computer(model, new String("Comuter Dolly"));
        curentGamer = gamer2;
        nextGamer = gamer1;
        isGo = Status.START;
    }

    public void go(){
        Vector2 v;
        if (curentGamer instanceof Human) {
            if (InputHandler.isClicked()) {
                v = InputHandler.getMousePosition();
                v.y = Gdx.graphics.getHeight() - v.y;
                int n = model.inSticks(v);
                if (n != -1)
                    updateChoice(n);
                else {
                    if (model.inOk(v)) {     // кнопка "ОК"
                      //  updateDelete();     // for Demo
                        if (countChosen != 0)
                            updateDelete();         // убрать для Demo
                    }
                }
            }
        }
        else{
            if (countChosen == 0){      //< model.getM()) {
                int[] c = curentGamer.choiceStikcs();
                model.choiceSticks(c);
                countChosen = c.length; // model.getM();    // компьютер сделал выбор
               // System.out.println(" ctrl::Go");
               // for (int a : c) System.out.print(a + ", ");
               // System.out.println();
            }
            else{
                if (InputHandler.isClicked()) {
                    v = InputHandler.getMousePosition();
                    v.y = Gdx.graphics.getHeight() - v.y;
                    if (model.inOk(v)) {
                        updateDelete();
                    }
                }
            }
        }
    }

    public void update(){
        if (isGo == Status.START && InputHandler.isClicked()) {
            isGo = Status.GO;
        }
        if (isGo == Status.GO && model.getN() == 0)
            isGo = Status.FINISH;
        if (isGo == Status.GO) go();
     //   if (isGo == Status.FINISH && InputHandler.isClicked())
             // end game    доделать!
    }


    public void clearChose(){   countChosen = 0; }

    public void updateChoice(int  k) {
        if (!model.getStick(k).isStatusChoice()) {
            if (countChosen < model.getM()) {
                countChosen++;
                model.choiceStick(k);
            }
        }
        else  {
                countChosen--;
                model.choiceStick(k);
            }
    }

    public void updateDelete() {
        model.delSticks();
        clearChose();

        Gamer tmp;
        tmp = nextGamer;
        nextGamer = curentGamer;
        curentGamer = tmp;
    }

    public void render(SpriteBatch batch){
        model.render(batch, bmf);

       if (isGo == Status.START )
           bmf.draw(batch, "Start", 10, 100);
       else if(isGo == Status.GO) {
           bmf.draw(batch, curentGamer.getName()+ ": "+ countChosen, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()-50);
           bmf.draw(batch, "Всего:"+ model.getN(), 100, Gdx.graphics.getHeight()-50 );
       }
        else {
           Texture panel = new Texture("victory.png");
           Vector2 pos = new Vector2(Gdx.graphics.getWidth() /3,  Gdx.graphics.getHeight()/3);
           batch.draw(panel, pos.x, pos.y);
           bmf.draw(batch, "Победа - " + nextGamer.getName()+"!", pos.x + panel.getWidth()/20, pos.y + panel.getHeight()/3);
       }
    }
}
