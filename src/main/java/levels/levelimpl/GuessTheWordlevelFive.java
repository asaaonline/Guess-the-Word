package levels.levelimpl;

import levels.GuessTheWordLevels;

public class GuessTheWordlevelFive implements GuessTheWordLevels {

    private String word;
    private int attempts = 10;
    private final static int LEVEL = 1;

    public GuessTheWordlevelFive() {
        word="test";
    }

    public int getLevel() {
        return LEVEL;
    }

    public int getAtTotalAttempts() {
        return attempts;
    }

    public void setATotalAttempts(int attempts) {
        this.attempts = attempts;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

}
