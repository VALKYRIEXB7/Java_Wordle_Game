import java.util.Scanner;

public class WordGameRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordGame wordGame = new WordGame();
        wordGame.playGame();
        scanner.close();
    }
}
