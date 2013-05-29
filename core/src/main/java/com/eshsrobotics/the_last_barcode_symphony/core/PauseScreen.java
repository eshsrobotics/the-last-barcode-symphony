package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;


public class PauseScreen implements Screen
{
    private ShapeRenderer resumeButton = new ShapeRenderer();
    private ShapeRenderer mainMenuButton = new ShapeRenderer();

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        resumeButton.setColor(0, 1, 0, 1);
        resumeButton.begin(ShapeType.Filled);
        resumeButton.rect(Gdx.graphics.getWidth()/2-50, (3*Gdx.graphics.getHeight())/4-25, 100, 50);
        resumeButton.end();

        mainMenuButton.setColor(1, 0, 0, 1);
        mainMenuButton.begin(ShapeType.Filled);
        mainMenuButton.rect(Gdx.graphics.getWidth()/2-50, Gdx.graphics.getHeight()/4-25, 100, 50);
        mainMenuButton.end();
    }

    @Override
    public void resize(int width, int height)
    {

    }

    @Override
    public void show()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void pause()
    {

    }

    public void resume()
    {

    }

    public void dispose()
    {

    }
}

