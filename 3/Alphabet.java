import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Alphabet {
    private char[] lowercase;
    private char[] uppercase;
    private String alphabet;

    public Alphabet() {

        alphabet = "abcdefghijklmnopqrstuvwxyz";
        lowercase = alphabet.toCharArray();
        uppercase = alphabet.toUpperCase().toCharArray();
    }

    public int getLetterScore(char letter) {
        for (int i = 0; i < lowercase.length; i++) {
            if (letter == lowercase[i]) {
                return i + 1;
            }
        }
        for (int i = 0; i < uppercase.length; i++) {
            if (letter == uppercase[i]) {
                return i + 27;
            }
        }
        return -1;
    }
}