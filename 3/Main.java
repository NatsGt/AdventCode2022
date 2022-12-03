import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("input.txt");
        try {
            Scanner scanner = new Scanner(file);
            Rucksack rucksack = new Rucksack();
            Group group = new Group();
            while (scanner.hasNextLine()) {
                var line = scanner.nextLine();
                group.addItems(line);
            }
            scanner.close();
            // rucksack.print();
            rucksack.getRepeatedChar();
            var res1 = rucksack.getScore();
            System.out.println(res1);
            group.divideIntoGroups();
            group.getRepeatedChar();
            // group.print();
            var res = group.getScore();
            System.out.println(res);
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }

    }
}
