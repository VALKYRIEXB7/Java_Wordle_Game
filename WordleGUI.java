import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class WordleGUI extends JFrame {
    JPanel mainPnl;
    JPanel gridPnl;
    JPanel bottomPnl;
    JButton quit;
    JButton genWord;
    private WordleTile[][] tiles;
    private int currentRow = 0;
    private int currentCol = 0;
    private String targetWord;
    private static final int MAX_GUESSES = 6;
    private static final int WORD_LENGTH = 5;
    private WordGame wordGame;
    private int numLets;

    public WordleGUI() {
        wordGame = new WordGame();
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        JLabel title = new JLabel("Wordle GUI");
        title.setFont(new Font("Impact", Font.PLAIN, 36));
        mainPnl.add(title, BorderLayout.NORTH);

        createGrid();
        mainPnl.add(gridPnl, BorderLayout.CENTER);

        createBottom();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);
        add(mainPnl);

        setTitle("Wordle Hard???");
        setSize(600, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        numLets = wordGame.pickRandomNumLetters();

        // Set up keyboard input
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }
        });
        setFocusable(true);
        requestFocus();

        // Initialize game
        targetWord = fetchWord();
    }

    private void handleKeyPress(KeyEvent e) {
        if (currentRow >= MAX_GUESSES) return;

        char keyChar = e.getKeyChar();
        if (keyChar >= 'a' && keyChar <= 'z') {
            // Handle letter input
            if (currentCol < WORD_LENGTH) {
                tiles[currentRow][currentCol].setText(String.valueOf(keyChar).toUpperCase());
                currentCol++;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            // Handle backspace
            if (currentCol > 0) {
                currentCol--;
                tiles[currentRow][currentCol].setText("");
            }
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            // Handle enter
            if (currentCol == WORD_LENGTH) {
                checkGuess();
            }
        }
    }

    private void checkGuess() {
        StringBuilder guess = new StringBuilder();
        for (int i = 0; i < WORD_LENGTH; i++) {
            guess.append(tiles[currentRow][i].getText().toLowerCase());
        }

        // Use WordGame's checker method
        String result = wordGame.checker(guess.toString(), targetWord, WORD_LENGTH);
        String[] results = result.trim().split("\\s+");

        // Update tile colors based on WordGame's checker results
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (results[i].equals("G")) {
                tiles[currentRow][i].setBackground(Color.GREEN);
            } else if (results[i].equals("Y")) {
                tiles[currentRow][i].setBackground(Color.YELLOW);
            } else {
                tiles[currentRow][i].setBackground(Color.GRAY);
            }
        }

        // Check if won
        if (guess.toString().equals(targetWord)) {
            JOptionPane.showMessageDialog(this, "Congratulations! You won!");
            resetGame();
        } else {
            currentRow++;
            currentCol = 0;
            if (currentRow >= MAX_GUESSES) {
                JOptionPane.showMessageDialog(this, "Game Over! The word was: " + targetWord);
                resetGame();
            }
        }
    }

    private void resetGame() {
        currentRow = 0;
        currentCol = 0;
        targetWord = fetchWord();
        for (int row = 0; row < MAX_GUESSES; row++) {
            for (int col = 0; col < WORD_LENGTH; col++) {
                tiles[row][col].setText("");
                tiles[row][col].setBackground(null);
            }
        }
    }

    private void createGrid() {
        gridPnl = new JPanel();
        gridPnl.setLayout(new GridLayout(MAX_GUESSES, WORD_LENGTH));
        tiles = new WordleTile[MAX_GUESSES][WORD_LENGTH];

        for (int row = 0; row < MAX_GUESSES; row++) {
            for (int col = 0; col < WORD_LENGTH; col++) {
                tiles[row][col] = new WordleTile(row, col, "");
                tiles[row][col].setFont(new Font("Impact", Font.PLAIN, 36));
                tiles[row][col].setFocusable(false);
                gridPnl.add(tiles[row][col]);
            }
        }
    }

    private String fetchWord() {
        // Use WordGame's word list for 5-letter words
        int rando = wordGame.pickRandomNumLetters();
        ArrayList<String> list = new ArrayList<String>();
        list = wordGame.selectWordList(rando);
        return wordGame.pickRandomWord(list);
    }

    private void createBottom() {
        bottomPnl = new JPanel();
        bottomPnl.setLayout(new GridLayout(1, 2));

        quit = new JButton("QUIT");
        quit.addActionListener((ActionEvent ae) -> System.exit(0));

        genWord = new JButton("NEW GAME");
        genWord.addActionListener((ActionEvent ae) -> resetGame());

        bottomPnl.add(quit);
        bottomPnl.add(genWord);
    }
}
