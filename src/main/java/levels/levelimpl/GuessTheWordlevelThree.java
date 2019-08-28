package levels.levelimpl;

import levels.GuessTheWordLevels;

public class GuessTheWordlevelThree implements GuessTheWordLevels {
    private final int level=1;
    private String word;
    private int attempts = 10;

    public GuessTheWordlevelThree() {

        word="test";

    }

    public int getLevel() {
        return level;
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
