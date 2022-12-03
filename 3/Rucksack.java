import java.util.ArrayList;
import java.util.List;

public class Rucksack {
    private List<List<String>> rucksack;
    private List<Character> repeatedChars;

    public Rucksack() {
        rucksack = new ArrayList<>();
        repeatedChars = new ArrayList<>();
    }

    public void addItems(String input) {
        String firstHalf = input.substring(0, input.length() / 2);
        String secondHalf = input.substring(input.length() / 2, input.length());
        List<String> compartiment = new ArrayList<>();
        compartiment.add(firstHalf);
        compartiment.add(secondHalf);
        rucksack.add(compartiment);
    }

    public void getRepeatedChar() {
        for (List<String> compartiment : rucksack) {
            char oneChar = compareChar(compartiment.get(0), compartiment.get(1));
            repeatedChars.add(oneChar);
        }
    }

    public char compareChar(String list1, String list2) {
        char repeatedChar = '-';
        char[] letters = list1.toCharArray();
        for (char oneLetter : letters) {
            if (list2.contains(String.valueOf(oneLetter))) {
                return oneLetter;
            }
        }
        return repeatedChar;
    }

    public int getScore() {
        Alphabet alph = new Alphabet();
        int sum = 0;
        for (Character character : repeatedChars) {
            var score = alph.getLetterScore(character);
            sum += score;
        }
        return sum;
    }

    public void print() {
        for (List<String> compartimentString : rucksack) {
            System.out.println(compartimentString.get(0) + " " + compartimentString.get(1));
        }
    }

}
