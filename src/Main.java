import interfeces.Terminal;
import models.DtoResult;
import persistence.UserRepository;
import persistence.UserRepositoryImpl;
import services.PalindromeServices;

public class Main {

    public static void main(String[] args) {
        UserRepository userRepository = UserRepositoryImpl.getInstance();
        PalindromeServices palindromeServices = new PalindromeServices(userRepository);



        while (true) {
            String login = Terminal.getLogin();
            while (true) {
                String word = Terminal.getWord();
                DtoResult dtoResult = palindromeServices.checkPalindrome(word, login);
                System.out.printf("Результат: слово %s, является палиндромом %s, начислено очков: %d\n", word, dtoResult.getPalindrome(), dtoResult.getScore());
                System.out.println(palindromeServices.getLeaderBoard(5));
            }
        }
    }
}
