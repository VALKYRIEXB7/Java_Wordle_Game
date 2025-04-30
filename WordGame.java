import java.util.ArrayList;
import java.util.Scanner;

public class WordGame {

    ArrayList<String> letter3 = new ArrayList<>();
    ArrayList<String> letter4 = new ArrayList<>();
    ArrayList<String> letter5 = new ArrayList<>();
    ArrayList<String> letter6 = new ArrayList<>();
    ArrayList<String> letter7 = new ArrayList<>();
    ArrayList<String> letter8 = new ArrayList<>();
    ArrayList<String> letter9 = new ArrayList<>();
    ArrayList<String> letter10 = new ArrayList<>();

    public WordGame() {
        fillWords();
    }

    public void playGame(){
        Scanner s = new Scanner(System.in);
        int winCt = 0;
        int numLetters = pickRandomNumLetters();
        String word = pickRandomWord(selectWordList(numLetters));
        for(int i = 0; i < 6; i++){
            System.out.println("You have " + (6-i) + " guesses to guess the " + numLetters + " letter word.");
            System.out.println("Guess: ");
            String guess = s.nextLine();
            if(guess.length() != numLetters){
                System.out.println("Please enter " + numLetters + " letter word.");
                i--;
                continue;
            }
            if(!checker(guess, word, numLetters).contains("B") && !checker(guess, word, numLetters).contains("Y")){
                System.out.println(checker(guess, word, numLetters));
                System.out.println("You guessed the word!");
                winCt++;
                break;
            }
            else{
                System.out.println(checker(guess, word, numLetters));
            }
        }
        if(winCt == 0){
            System.out.println("The word was " + word + " You should play again!");
        }
    }

    public String checker(String guess, String word, int numLett){
        String out = "";
        for(int i = 0; i < numLett; i++){
            String letter = guess.substring(i, i+1);
            if(word.substring(i, i+1).equals(letter)){
                out += " G ";
            }
            else if(word.contains(letter)){
                // Count how many times this letter appears in the guess up to this point
                int countInGuess = 0;
                for(int j = 0; j < i; j++){
                    if(guess.substring(j, j+1).equals(letter)){
                        countInGuess++;
                    }
                }
                // Check if there's another occurrence of this letter in the word
                if(findNthOccurrence(word, letter, countInGuess + 1) != -1){
                    out += " Y ";
                }
                else{
                    out += " B ";
                }
            }
            else{
                out += " B ";
            }
        }
        return out;
    }

    public int pickRandomNumLetters(){
        int randomNum = (int) (Math.random() * 8) + 3;
        return randomNum;
    }

    public String pickRandomWord(ArrayList<String> list){
        int randomIndex = (int) (Math.random() * list.size());
        return list.get(randomIndex);
    }

    public ArrayList<String> selectWordList(int numLetters) {
        switch(numLetters) {
            case 3:
                return letter3;
            case 4:
                return letter4;
            case 5:
                return letter5;
            case 6:
                return letter6;
            case 7:
                return letter7;
            case 8:
                return letter8;
            case 9:
                return letter9;
            case 10:
                return letter10;
            default:
                return letter5; // default to 5 letter words if something goes wrong
        }
    }

    public int findNthOccurrence(String str, String target, int n) {
        int count = 0;
        int index = -1;
        
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals(target)) {
                count++;
                if (count == n) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    public void fillWords() {
        /* adds basic list of letter-respective words to ArrayList */

        /* adds three letter words to ArrayList */
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

        /* adds four letter words to ArrayList */
        letter4.add("word");
        letter4.add("play");
        letter4.add("game");
        letter4.add("book");
        letter4.add("time");
        letter4.add("life");
        letter4.add("work");
        letter4.add("home");
        letter4.add("love");
        letter4.add("mind");
        letter4.add("hand");
        letter4.add("head");
        letter4.add("face");
        letter4.add("body");
        letter4.add("soul");

        /* adds five letter words to ArrayList */
        letter5.add("world");
        letter5.add("happy");
        letter5.add("music");
        letter5.add("dream");
        letter5.add("peace");
        letter5.add("heart");
        letter5.add("light");
        letter5.add("smile");
        letter5.add("brain");
        letter5.add("space");
        letter5.add("earth");
        letter5.add("water");
        letter5.add("power");
        letter5.add("story");
        letter5.add("float");

        letter6.add("heaven");
        letter6.add("report");
        letter6.add("anyway");
        letter6.add("during");
        letter6.add("center");
        letter6.add("number");
        letter6.add("zigzag");
        letter6.add("jinxed");
        letter6.add("raptor");
        letter6.add("forest");
        letter6.add("helper");
        letter6.add("jungle");
        letter6.add("nachos");
        letter6.add("delete");
        letter6.add("random");
        
        letter7.add("clapped");
        letter7.add("evening");
        letter7.add("million");
        letter7.add("flowers");
        letter7.add("conduct");
        letter7.add("meaning");
        letter7.add("densely");
        letter7.add("circuit");
        letter7.add("desktop");
        letter7.add("smashed");
        letter7.add("sneaker");
        letter7.add("blocked");
        letter7.add("forfeit");
        letter7.add("renewed");
        letter7.add("refresh");

        letter8.add("abnormal");
        letter8.add("blizzard");
        letter8.add("graphite");
        letter8.add("notebook");
        letter8.add("outreach");
        letter8.add("bookmark");
        letter8.add("elevator");
        letter8.add("landmine");
        letter8.add("sprinter");
        letter8.add("sneakers");
        letter8.add("overcome");
        letter8.add("hydrogen");
        letter8.add("vagabond");
        letter8.add("calendar");
        letter8.add("tangible");

        letter9.add("adventure");
        letter9.add("butterfly");
        letter9.add("handstand");
        letter9.add("dangerous");
        letter9.add("nightfall");
        letter9.add("telephone");
        letter9.add("voluntary");
        letter9.add("overgrown");
        letter9.add("steamboat");
        letter9.add("tailoring");
        letter9.add("waterfall");
        letter9.add("signature");
        letter9.add("fireproof");
        letter9.add("grayscale");
        letter9.add("evergreen");

        letter10.add("historical");
        letter10.add("adventures");
        letter10.add("chocolates");
        letter10.add("dissension");
        letter10.add("monumental");
        letter10.add("telescoped");
        letter10.add("volleyball");
        letter10.add("nightlight");
        letter10.add("rectangles");
        letter10.add("crocodiles");
        letter10.add("telepathic");
        letter10.add("millennium");
        letter10.add("tremendous");
        letter10.add("regulation");
        letter10.add("motivation");
    }

}
