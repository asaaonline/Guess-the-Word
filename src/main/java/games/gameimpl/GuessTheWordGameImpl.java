package games.gameimpl;

import gameutils.guesstheword.RunLevel;
import games.GuessTheWordGame;
import levels.GuessTheWordLevels;
import levels.LevelFactory;
import levels.SuperLevel;


public class GuessTheWordGameImpl implements GuessTheWordGame {
    private GuessTheWordLevels guessTheWordLevels;




    public SuperLevel getLevel() {
        return guessTheWordLevels;
    }

    public void run(String[] words) {
        boolean isWin = true;

        try {
            for (int i = 0; i < LevelFactory.GuessTheWordlevels.values().length; i++) {
                guessTheWordLevels = (GuessTheWordLevels) LevelFactory.getInstance().getLevel(LevelFactory.gameType.GUESSTHEWORD, LevelFactory.GuessTheWordlevels.values()[i]);
                guessTheWordLevels.setWord(words[i].toUpperCase());

                RunLevel runLevel = new RunLevel();
                int run = runLevel.run(guessTheWordLevels);

                if (run == 0) {
                    isWin = false;
                    break;
                }
            }

            if (isWin) {
                System.out.println("He wins!");
            }else
            {
                System.out.println("He lost!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("array out of bound");
        }


    }


}
