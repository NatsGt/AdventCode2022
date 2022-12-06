import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("input.txt");
        try {
            Scanner scn = new Scanner(file);
            var input = "";
            while (scn.hasNext()) {
                input += scn.next();
            }
            scn.close();
            StringReader str = new StringReader(input);
            // str.print();
            str.separateString();
            var res = str.compareFour();
            var res2 = str.compareFourteen();
            System.out.println(res);
            System.out.println(res2);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}