import java.util.HashSet;
import java.util.Set;

public class StringReader {
    private char[] characters;
    private String inputString;

    public StringReader(String inpuString) {
        this.inputString = inpuString;
    }

    public void print() {
        System.out.println(inputString);
    }

    public void separateString() {
        characters = inputString.toCharArray();
    }

    public int compareFour() {
        int lastIndex = 0;
        for (int i = 0; i < characters.length - 3; i++) {
            Set<Character> set = new HashSet<>();
            set.add(characters[i]);
            set.add(characters[i + 1]);
            set.add(characters[i + 2]);
            set.add(characters[i + 3]);
            if (set.size() == 4) {
                return lastIndex = i + 4;
            }
        }
        return lastIndex;
    }

    public int compareFourteen() {
        int lastIndex = 0;
        for (int i = 0; i < characters.length - 13; i++) {
            Set<Character> set = new HashSet<>();
            int counter = 0;
            while (counter < 14) {
                set.add(characters[i + counter]);
                counter++;
            }
            if (set.size() == 14) {
                return lastIndex = i + 14;
            }
        }
        return lastIndex;
    }
}
