package UI;

import java.util.Scanner;

public class CommandLineInterface implements UI {

    Scanner sc = new Scanner(System.in);

    public void show(String s) {
        System.out.print(s);
    }

    public void show(Character[] characters) {
        StringBuilder sb = new StringBuilder();
        for (Character ch : characters
        ) {
            sb.append(ch);
        }

        System.out.print(sb);
    }

    public char getUserReading() {
        return sc.next().charAt(0);
    }

    public void nextScrean() {
        System.out.print(System.getProperty("line.separator"));
    }
}
