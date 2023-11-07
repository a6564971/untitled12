package services;

import models.DtoResult;
import models.User;
import persistence.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PalindromeServices {

    private final UserRepository userRepository;

    public PalindromeServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public DtoResult checkPalindrome(String word, String login) {
        User user = Optional.ofNullable(userRepository.getUser(login))
                .orElseGet(() -> new User(login));
        Boolean isPalindrome = isPalindrome(word);
        if (isPalindrome) {
            user.setScore(user.getScore() + word.length());
        }
        user.setTotalGames(user.getTotalGames() + 1);
        userRepository.saveUser(user);
        DtoResult dtoResult = isPalindrome ?
                new DtoResult(isPalindrome, word.length())
                : new DtoResult(isPalindrome, 0);
        return dtoResult;
    }

    public List<User> getLeaderBoard(Integer top) {
        return userRepository.allUsers().stream()
                .sorted(Comparator.comparing(User::getScore))
                .limit(top)
                .collect(Collectors.toList());
    }


    private boolean isPalindrome(String word) {
        StringBuilder reverse = new StringBuilder(word).reverse();
        return word.equalsIgnoreCase(reverse.toString());
    }
}
