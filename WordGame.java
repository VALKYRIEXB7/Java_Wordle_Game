import java.util.ArrayList;

public class WordGame {

    ArrayList<String> letter3;
    ArrayList<String> letter4;
    ArrayList<String> letter5;
    ArrayList<String> letter6;
    ArrayList<String> letter7;
    ArrayList<String> letter8;
    ArrayList<String> letter9;
    ArrayList<String> letter10;

    public WordGame() {
        fillWords();
    }

    public void fillWords() {
        /* adds basic list of letter-respective words to ArrayList */
        letter3.add("cat");
        letter3.add("dog");
        letter3.add("bat");
        letter3.add("hat");
        letter3.add("sun");
        letter3.add("tin");
        letter3.add("bit");
        letter3.add("sip");
        letter3.add("pen");
        letter3.add("fix");
        letter3.add("top");
        letter3.add("net");
        letter3.add("bet");
        letter3.add("fan");
        letter3.add("sit");
    }
}
