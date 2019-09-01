import games.gameimpl.Word;
import org.junit.Test;

import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WordTest {

    @Test
    public void should_ReturnFirstPositionFilledArray_when_AWordIsGiven(){
        Word word = new Word("Kamal", 10);
        Character[] expected = new Character[]{'K','*', '*', '*', '*'};
        assertThat(word.get(), arrayContaining(expected));
    }

    @Test
    public void should_ApplyTheCharacterToTheWord_when_aValidCharacterIsGiven(){
        Word word = new Word("Kamal", 10);
        Character[] expected = new Character[]{'K','A', '*', 'A', '*'};
        Character newChar = 'a';
        assertThat(word.fill(newChar), is(true));
        assertThat(word.get(), arrayContaining(expected));
    }

    @Test
    public void should_ReduceLevelBy1_when_anInvalidCharacterIsGiven(){
        Word word = new Word("Kamal", 10);
        Character[] expected = new Character[]{'K','*', '*', '*', '*'};
        Character newChar = 'c';
        assertThat(word.fill(newChar), is(false));
        assertThat(word.get(), arrayContaining(expected));
        assertThat(word.getRemainingAttempts(), is(9));

    }

    @Test(expected = games.gameimpl.GameOverException.class)
    public void should_ThrowAnExceptionOnFill_when_AttemtsAreOver(){
        Word word = new Word("Kamal", 0);
        Character newChar = 'c';
        word.fill(newChar);
    }
}
