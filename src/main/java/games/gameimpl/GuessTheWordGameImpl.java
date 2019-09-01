package games.gameimpl;

import UI.UI;
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

    public void run(String[] words, UI ui) {
        boolean isWin = true;


        try {
            for (int i = 0; i < LevelFactory.GuessTheWordlevels.values().length; i++) {
                guessTheWordLevels = (GuessTheWordLevels) LevelFactory.getInstance().getLevel(LevelFactory.gameType.GUESSTHEWORD, LevelFactory.GuessTheWordlevels.values()[i]);
                guessTheWordLevels.setWord(words[i].toUpperCase());

                RunLevel runLevel = new RunLevel();
                int run = runLevel.run(guessTheWordLevels, ui);

                if (run == 0) {
                    isWin = false;
                    break;
                }

                if (i < LevelFactory.GuessTheWordlevels.values().length - 1) {
                    ui.show("next");
                }

            }

            if (isWin) {
                ui.show("He wins!");
            } else {
                ui.show("He lost!");

            }

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("array out of bound");
        }


    }


}
