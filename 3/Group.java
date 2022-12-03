import java.util.ArrayList;
import java.util.List;

public class Group {
    private List<String> allGroups;
    private List<List<String>> listOfGroups;
    private List<Character> repeatedChars;

    public Group() {
        allGroups = new ArrayList<>();
        listOfGroups = new ArrayList<>();
        repeatedChars = new ArrayList<>();
    }

    public void addItems(String input) {
        allGroups.add(input);
    }

    public void divideIntoGroups() {
        List<String> oneGroup = new ArrayList<>();
        for (int i = 0; i < allGroups.size(); i++) {
            if (i == 0) {
                oneGroup.add(allGroups.get(i));
            } else if (i % 3 == 0 && i != 0) {
                listOfGroups.add(oneGroup);
                oneGroup = new ArrayList<>();
                oneGroup.add(allGroups.get(i));
            } else if (i == allGroups.size() - 1) {
                oneGroup.add(allGroups.get(i));
                listOfGroups.add(oneGroup);
            } else {
                oneGroup.add(allGroups.get(i));
            }
        }
    }

    public void getRepeatedChar() {
        for (List<String> compartiment : listOfGroups) {
            char oneChar = compareChar(compartiment.get(0), compartiment.get(1), compartiment.get(2));
            repeatedChars.add(oneChar);
        }
    }

    public char compareChar(String list1, String list2, String list3) {
        char repeatedChar = '-';
        char[] letters = list1.toCharArray();
        for (char oneLetter : letters) {
            if (list2.contains(String.valueOf(oneLetter)) && list3.contains(String.valueOf(oneLetter))) {
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
        for (List<String> compartimentString : listOfGroups) {
            System.out.println(
                    compartimentString.get(0) + " " + compartimentString.get(1) + " " + compartimentString.get(2));
        }
    }
}
