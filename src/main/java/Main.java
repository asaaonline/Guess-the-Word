
import UI.CommandLineInterface;
import UI.UI;
import games.GameFactory;

import games.gameimpl.GuessTheWordGameImpl;

public class Main {

    public static void main(String[] args) {
        GuessTheWordGameImpl guessTheWordGame = (GuessTheWordGameImpl) GameFactory.getInstance().getGame(GameFactory.gameType.GUESSTHEWORD);
        String[] test ={"mother", "father", "country", "running", "watching"};

        UI commandLineInterface = new CommandLineInterface();
        guessTheWordGame.run(test,commandLineInterface);
    }
}
