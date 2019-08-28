package gameutils.guesstheword;

import levels.GuessTheWordLevels;

import java.util.Arrays;
import java.util.Scanner;

public class RunLevel {


    private RunLevel() {
    }

    public static int run(GuessTheWordLevels guessTheWordLevels) {
        int currentAttempt = 0;


        String secreatWord = guessTheWordLevels.getWord();
        int totalAttempts = guessTheWordLevels.getAtTotalAttempts();
        char[] diaplayWordCharArray;
        String tempStringWord = secreatWord;


        System.out.println("Guess The Word:");

        tempStringWord = tempStringWord.replaceAll("\\B[A-Z]", "*");

        System.out.println(tempStringWord);

        diaplayWordCharArray = tempStringWord.toCharArray();

        Scanner sc = new Scanner(System.in);

        while (currentAttempt <= totalAttempts) {

            char enteredCharacter = sc.next().charAt(0);
            char[] tempCharArray = chageWordToPrint(diaplayWordCharArray, secreatWord, Character.toUpperCase(enteredCharacter));

            if (isSelectedForNextLevel(tempCharArray)) {

                System.out.println("Go to the next level");
                return 1;
            } else {

                if (currentAttempt - totalAttempts >= 0) {
                    System.out.println("you are lost");
                    return 0;
                } else {
                    if (Arrays.equals(tempCharArray, diaplayWordCharArray)) {
                        currentAttempt++;
                        System.out.println(totalAttempts - currentAttempt + " attempts remaining");
                    } else {
                        System.out.println(totalAttempts - currentAttempt + " attempts remaining");
                    }
                }

            }
            diaplayWordCharArray = tempCharArray;
            System.out.println(diaplayWordCharArray);
        }

        return 3;
    }


    private static char[] chageWordToPrint(char[] displayWordArray, String secreatWord, char character) {
        char[] tempArray = new char[displayWordArray.length];
        tempArray[0] = secreatWord.charAt(0);
        for (int i = 1; i < secreatWord.length(); i++) {
            tempArray[i] = displayWordArray[i];
            if (secreatWord.charAt(i) == character) {
                tempArray[i] = secreatWord.charAt(i);
            }
        }
        return tempArray;
    }

    private static boolean isSelectedForNextLevel(char[] wordToPrint) {
        int count = 0;
        for (char c : wordToPrint) {
            if (c == '*') {
                count++;
            }
        }

        return count == 0;

    }
}
