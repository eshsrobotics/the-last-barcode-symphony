package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.FPSLogger;

public class TheLastBarcodeSymphony extends Game
{
    private static final TheLastBarcodeSymphony INSTANCE = new TheLastBarcodeSymphony();

    public static final String TAG = TheLastBarcodeSymphony.class.getSimpleName();
    public static final FPSLogger FPS_LOGGER = new FPSLogger();

    PlayScreen playScreen;
    PauseScreen pauseScreen;
    QuitScreen quitScreen;
    MainMenu mainMenu;
    LosingScreen losingScreen;

    Music music;
    Highscores highscore;

    @Override
    public void create() 
    {
        getInstance().playScreen = new PlayScreen();
        getInstance().losingScreen = new LosingScreen();
        getInstance().quitScreen = new QuitScreen();
        getInstance().mainMenu = new MainMenu();
        getInstance().pauseScreen = new PauseScreen();
        Gdx.app.log(TAG, "Instantiated screens!");

        getInstance().playScreen.create();
        getInstance().mainMenu.create();
        Gdx.app.log(TAG, "Called mysterious create method on appropriate screens.");

        getInstance().highscore = Highscores.getInstance();
        getInstance().highscore.loadHighscores();

        getInstance().music = Gdx.audio.newMusic(Gdx.files.internal("Beethoven5th.mp3"));
        getInstance().music.play();
        getInstance().music.pause();
        Gdx.app.log(TAG, "Started playing music.");

        getInstance().setScreen(getInstance().mainMenu);
        Gdx.app.log(TAG, "Set screen to main menu.");
    }
    
    @Override
    public void render()
    {
        getInstance().getScreen().render(Gdx.graphics.getDeltaTime());
        FPS_LOGGER.log();

        if(getInstance().getScreen() == getInstance().pauseScreen)
        {
            if(Gdx.input.isKeyPressed(Keys.P))
            {
                getInstance().setScreen(getInstance().playScreen);
                Gdx.app.log(TAG, "Set screen to play screen.");
            }
        }
        else
        {
            if(Gdx.input.isKeyPressed(Keys.P) && getInstance().getScreen() != getInstance().mainMenu)
            {
                getInstance().setScreen(getInstance().pauseScreen);
                Gdx.app.log(TAG, "Set screen to pause screen.");
            }
        }
    }

    public static TheLastBarcodeSymphony getInstance()
    {
        return INSTANCE;
    }
}
