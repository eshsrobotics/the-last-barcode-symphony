package com.eshsrobotics.the_last_barcode_symphony.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Highscores 
{
    private Preferences hS = Gdx.app.getPreferences("Highscores");
    public static Highscores instance = new Highscores();
    private int[] highscores = new int[5];
    private boolean isHighscore = false;
    
    public static Highscores getInstance()
    {
        return instance;
    }
    
    public void loadHighscores()
    {
        for(int i = 0; i <= 4; i++)
        {
            highscores[i] = hS.getInteger(Integer.toString(i), (i+1)*10000);
            
            /*Note: For now, uncomment the two lines below and comment out the
            line above if you need to clear your highscores.*/
            
            //hS.putInteger(Integer.toString(i), (i+1)*10000);
            //hS.flush();
        }
    }
    
    public void writeHighscore(int score)
    {
        for(int i = 4; i >= 0; i--)
        {
            if(score > highscores[i])
            {
                for(int index = i-1; index >= 0; index--)
                {
                    highscores[index] = highscores[index+1];
                    System.out.println("test3");
                }
                highscores[i] = score;
                isHighscore = true;
                break;
            }
        }
    }
    
    public void saveHighscore()
    {
        for(int i = 0; i <= 4; i++)
        {
            hS.putInteger(Integer.toString(i), highscores[i]);
            System.out.println(highscores[i]);
        }
        hS.flush();
    }

    public boolean isIsHighscore() 
    {
        return isHighscore;
    }

    public void setIsHighscore(boolean isHighscore) 
    {
        this.isHighscore = isHighscore;
    }
}
