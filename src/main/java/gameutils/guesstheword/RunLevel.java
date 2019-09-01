package gameutils.guesstheword;

import UI.UI;
import games.gameimpl.Word;
import levels.GuessTheWordLevels;




public class RunLevel {


    public int run(GuessTheWordLevels guessTheWordLevels, UI ui) {


        Word word = new Word(guessTheWordLevels.getWord(), guessTheWordLevels.getAtTotalAttempts());

        ui.show("Guess The Word:");

        Character[] characters = word.get();
        ui.nextScrean();
        ui.show(characters);

        while (word.getRemainingAttempts() > 0) {
            char userReading = ui.getUserReading();
            word.fill(userReading);
            ui.show("remaining attempts" + word.getRemainingAttempts());

            if (isSelectedForNextLevel(word.get())) {

                return 1;
            }
            ui.nextScrean();
            ui.show(word.get());
        }
        if (word.getRemainingAttempts() == 0) {
            return 0;

        } else {
            return 1;
        }


    }


    private boolean isSelectedForNextLevel(Character[] wordToPrint) {
        int count = 0;
        for (char c : wordToPrint) {
            if (c == '*') {
                count++;
            }
        }

        return count == 0;

    }
}
