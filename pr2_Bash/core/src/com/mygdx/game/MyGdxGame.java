package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {

	SpriteBatch batch;
	Model model;
	Texture myFon;
	Texture myOk;
	ControlGame ctrlGame;
	//int


	@Override
	public void create () {
		batch = new SpriteBatch();
		model = new Model(20, 4);
		ctrlGame = new ControlGame(model);
		myFon = new Texture("fon.jpg");
		myOk = new Texture("ok2.jpg");
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		batch.draw(myFon, 0, 0);
		batch.draw(myOk, Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()*1/50);
		model.render(batch);

		batch.end();
	}
	public void update(){

		Vector2 v;

		if (InputHandler.isClicked()) {
			v = InputHandler.getMousePosition();
			v.y = Gdx.graphics.getHeight()- v.y;
			int n = model.inSticks(v);
			if ( n != -1)
				ctrlGame.c
			else{
				Vector2 vec = v.cpy().sub(myOk);
				if (vec.x >= 0 && vec.x <= myOk.getWidth() && vec.y >= 0 && vec.y <= myOk.getWidth())
					if (ctrlGame.)

			}
//			System.out.println(n);
//			if(n!=-1) {
//				model.choiceStick(n);
//			}

//			System.out.println("sub "+ v.cpy().sub(model.getSticks(0)));
//			System.out.println("0 "+model.getSticks(0));
//			System.out.println("mouse "+v+"\n");
		//}

		//model.update;

	}
	

}
