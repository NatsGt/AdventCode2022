import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    enum OPTIONS {
        PAPER,
        SCISSORS,
        ROCK
    }

    public static OPTIONS getWinner(OPTIONS player1, String player2) {
        if (player1.equals(OPTIONS.PAPER)) {
            if (player2.equals("X")) {
                return OPTIONS.ROCK;
            } else if (player2.equals("Y")) {
                return OPTIONS.PAPER;
            } else {
                return OPTIONS.SCISSORS;
            }
        } else if (player1.equals(OPTIONS.ROCK)) {
            if (player2.equals("X")) {
                return OPTIONS.SCISSORS;
            } else if (player2.equals("Y")) {
                return OPTIONS.ROCK;
            } else {
                return OPTIONS.PAPER;
            }
        } else {
            if (player2.equals("X")) {
                return OPTIONS.PAPER;
            } else if (player2.equals("Y")) {
                return OPTIONS.SCISSORS;
            } else {
                return OPTIONS.ROCK;
            }
        }
    }

    public static int getScore(List<List<String>> tournament) {
        int sum = 0;
        for (List<String> matchEntry : tournament) {
            var elf = matchEntry.get(0);
            var me = matchEntry.get(1);
            var elfScore = elf.equals("A") ? OPTIONS.ROCK : elf.equals("B") ? OPTIONS.PAPER : OPTIONS.SCISSORS;
            var myOption = getWinner(elfScore, me);
            var matchPoints = me.equals("Z") ? 6 : me.equals("Y") ? 3 : 0;
            var optionPoint = myOption.equals(OPTIONS.SCISSORS) ? 3 : myOption.equals(OPTIONS.PAPER) ? 2 : 1;
            sum += matchPoints + optionPoint;
        }
        return sum;
    }

    public static void main(String[] args) {
        File file = new File("input.txt");
        try {

            List<List<String>> tournament = new ArrayList<>();
            Scanner scn = new Scanner(file);
            while (scn.hasNextLine()) {
                List<String> match = new ArrayList<>();
                var elf = scn.next();
                var me = scn.next();
                match.add(elf);
                match.add(me);
                tournament.add(match);
            }
            scn.close();
            System.out.println(tournament.size());
            var result = getScore(tournament);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }

    }
}
