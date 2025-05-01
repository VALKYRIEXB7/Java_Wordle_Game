import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class WordleGUI extends JFrame{
    JPanel mainPnl;
    JPanel gridPnl;
    JPanel bottomPnl;
    JButton quit;
    JButton genWord;
    //Random r;
    public WordleGUI(){
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        JLabel title = new JLabel("Wordle GUI");
        title.setFont(new Font("Impact", Font.PLAIN, 36));
        mainPnl.add(title, BorderLayout.NORTH);

        createGrid("test");
        mainPnl.add(gridPnl, BorderLayout.CENTER);

        createBottom();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);
        add(mainPnl);

        setTitle("Wordle Hard???");
        setSize(800, 1000); // Set a size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        //fetchWord();
    }

    private String fetchWord() {
        JOptionPane.showMessageDialog(this, "Implement later, IDK how to read files goodly");
        /*ArrayList<String> words = new ArrayList<>();
        String randomWord = ""; // Default value
        try {
            Path file = new File("src/ExampleWords").toPath();
            BufferedReader reader = Files.newBufferedReader(file);

            while (reader.ready()) {
                words.add(reader.readLine().toLowerCase());
            }
            reader.close();

            if (!words.isEmpty()) {
                int randomItem = r.nextInt(words.size());
                randomWord = words.get(randomItem);
                System.out.println(randomWord);
            }

        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return randomWord;*/
        return "Stinky";
    }


    private void createGrid(String exampleWord){
        int WIDTH = exampleWord.length();
        int HEIGHT = 6;
        String letter = " ";
        gridPnl = new JPanel();
        gridPnl.setLayout(new GridLayout(HEIGHT, WIDTH));

        for(int col=0; col < HEIGHT; col++)
        {
            for(int row=0; row < WIDTH; row++)
            {
                WordleTile tile = new WordleTile(row, col, letter);
                gridPnl.add(tile);

                tile.setFont(new Font("Impact", Font.PLAIN, 10));
            }
        }
        System.out.println("works!!!");
    }

    private void createBottom(){
        bottomPnl = new JPanel();
        bottomPnl.setLayout(new GridLayout(1,2));

        quit = new JButton("QUIT");
        quit.addActionListener((ActionEvent ae) -> System.exit(0));

        genWord = new JButton("GEN WORD");
        genWord.addActionListener((ActionEvent gen) -> fetchWord());

        bottomPnl.add(quit);
        bottomPnl.add(genWord);

    }
}
