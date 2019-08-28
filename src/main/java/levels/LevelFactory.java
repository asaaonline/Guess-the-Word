package levels;


import levels.levelimpl.*;

public class LevelFactory {
    private static LevelFactory factory;


    public enum gameType {
        GUESSTHEWORD,

    }

    public enum GuessTheWordlevels {
        ONE,TWO,THREE,FOUR,FIVE
    }

    private LevelFactory() {

    }

    public static LevelFactory getInstance() {
        if (factory == null) factory = new LevelFactory();
        return factory;
    }

    public SuperLevel getLevel(gameType type, GuessTheWordlevels level) {
        switch (type) {
            case GUESSTHEWORD:
                switch (level) {
                    case ONE:
                        return new GuessTheWordlevelOne();
                    case TWO:
                        return new GuessTheWordlevelTwo();
                    case THREE:
                        return new GuessTheWordlevelThree();
                    case FOUR:
                        return new GuessTheWordlevelFour();
                    case FIVE:
                        return new GuessTheWordlevelFive();
                    default:
                        return new GuessTheWordlevelOne();
                }
            default:
                return null;
        }
    }
}

