import gameutils.guesstheword.RunLevel;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RunLevelTest {

    @Test
    public void should_returnTrueWhenAnyCharactorNotEqualStar() {
        RunLevel runLevel = new RunLevel();
        Method method ;


        try {
            method = RunLevel.class.getDeclaredMethod("isSelectedForNextLevel", Character[].class);
            method.setAccessible(true);
            Character[] characters = {'f','f','i','g'};
            Object[] param ={characters};
            boolean output = (boolean) method.invoke(runLevel, param);

            assertThat(output,is(true));

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void should_returnFalseWhenAnyCharactorEqualStar() {
        RunLevel runLevel = new RunLevel();
        Method method ;


        try {
            method = RunLevel.class.getDeclaredMethod("isSelectedForNextLevel", Character[].class);
            method.setAccessible(true);
            Character[] characters = {'f','f','*','g'};
            Object[] param ={characters};
            boolean output = (boolean) method.invoke(runLevel, param);

            assertThat(output,is(false));

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void should_returnFalseWhenAllCharactorEqualStar() {
        RunLevel runLevel = new RunLevel();
        Method method ;


        try {
            method = RunLevel.class.getDeclaredMethod("isSelectedForNextLevel", Character[].class);
            method.setAccessible(true);
            Character[] characters = {'*','*','*','*'};
            Object[] param ={characters};
            boolean output = (boolean) method.invoke(runLevel, param);

            assertThat(output,is(false));

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
