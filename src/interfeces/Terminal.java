package interfeces;

import java.util.Scanner;

public class Terminal {

    public static String getLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        return login;

    }

    public static String getWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите полиндом: ");
        String palindrome = scanner.nextLine();
        return palindrome;
    }

    private Terminal() {
        throw new RuntimeException("utility class");
    }
}
