package games;

import games.gameimpl.GuessTheWordGameImpl;

public class GameFactory {
    private static GameFactory factory;


    public enum gameType{
        GUESSTHEWORD,

    }

    private GameFactory(){

    }

    public static GameFactory getInstance(){
        if(factory==null) factory=new GameFactory();
        return factory;
    }

    public SuperGame getGame(gameType type){
        switch(type){
            case GUESSTHEWORD:return new GuessTheWordGameImpl();

            default:return null;
        }
    }
}

