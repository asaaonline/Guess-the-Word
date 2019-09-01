
import UI.CommandLineInterface;
import UI.UI;

import datasource.CSVDatasource;
import datasource.DataSource;
import games.GameFactory;

import games.gameimpl.GuessTheWordGameImpl;
import levels.LevelFactory;

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        GuessTheWordGameImpl guessTheWordGame = (GuessTheWordGameImpl) GameFactory.getInstance().getGame(GameFactory.gameType.GUESSTHEWORD);

        DataSource csvDatasource = new CSVDatasource();

        String[] wordArray = csvDatasource.getWordArray("test.csv");
        String[] strings = Arrays.copyOfRange(wordArray, 0, LevelFactory.GuessTheWordlevels.values().length - 1);

        UI commandLineInterface = new CommandLineInterface();
        guessTheWordGame.run(strings, commandLineInterface);
    }
}
