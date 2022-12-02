import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    enum OPTIONS {
        PAPER,
        SCISSORS,
        ROCK
    }

    public static String getWinner(OPTIONS player1, OPTIONS player2) {
        if (player1.equals(OPTIONS.PAPER)) {
            if (player2.equals(OPTIONS.SCISSORS)) {
                return "me";
            } else if (player2.equals(OPTIONS.ROCK)) {
                return "elf";
            } else {
                return "draw";
            }
        } else if (player1.equals(OPTIONS.ROCK)) {
            if (player2.equals(OPTIONS.PAPER)) {
                return "me";
            } else if (player2.equals(OPTIONS.SCISSORS)) {
                return "elf";
            } else {
                return "draw";
            }
        } else {
            if (player2.equals(OPTIONS.ROCK)) {
                return "me";
            } else if (player2.equals(OPTIONS.PAPER)) {
                return "elf";
            } else {
                return "draw";
            }
        }
    }

    public static int getScore(List<List<String>> tournament) {
        int sum = 0;
        for (List<String> matchEntry : tournament) {
            var elf = matchEntry.get(0);
            var me = matchEntry.get(1);
            var elfScore = elf.equals("A") ? OPTIONS.ROCK : elf.equals("B") ? OPTIONS.PAPER : OPTIONS.SCISSORS;
            var mineScore = me.equals("X") ? OPTIONS.ROCK : me.equals("Y") ? OPTIONS.PAPER : OPTIONS.SCISSORS;
            var winner = getWinner(elfScore, mineScore);
            var matchPoints = winner.equals("me") ? 6 : winner.equals("draw") ? 3 : 0;
            var optionPoint = mineScore.equals(OPTIONS.SCISSORS) ? 3 : mineScore.equals(OPTIONS.PAPER) ? 2 : 1;
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