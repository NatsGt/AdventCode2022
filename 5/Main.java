import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        File file = new File("input.txt");
        Container container = new Container();
        try {
            Scanner scanner = new Scanner(file);
            List<String> input = new ArrayList<>();
            while (scanner.hasNextLine()) {
                var line = scanner.nextLine();
                input.add(line);
            }
            scanner.close();
            Pattern pattern = Pattern.compile("(\\s\\s\\s\\s|(\\[\\w\\]))");
            Pattern pattern2 = Pattern.compile("\\s\\d");
            boolean textSwitch = false;
            for (String string : input) {
                Matcher matcher = pattern.matcher(string);
                Matcher number = pattern2.matcher(string);
                if (!number.find() && !textSwitch) {
                    int inner = 0;
                    while (matcher.find()) {
                        container.addBox(matcher.group(0), inner + 1);
                        inner++;
                    }
                }
                if (textSwitch) {
                    container.addInstructions(string);
                }
                if (number.find()) {
                    textSwitch = true;

                }

            }
            // container.print();
            container.readInstructions();
            container.print();
            var res = container.getTopBoxes();
            System.out.println(res);
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }

    }
}