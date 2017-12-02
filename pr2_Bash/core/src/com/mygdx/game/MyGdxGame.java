package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MyGdxGame extends ApplicationAdapter {

	SpriteBatch batch;
	Model model;
	ControlGame ctrlGame;

	@Override
	public void create () {
		batch = new SpriteBatch();
		model = new Model(20, 4);
		ctrlGame = new ControlGame(model);

	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		ctrlGame.render(batch);

		batch.end();
	}
	public void update() {

        ctrlGame.update();

	}
}
