import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("input.txt");
        try {
            Scanner scn = new Scanner(file);
            TaskList taskList = new TaskList();
            while (scn.hasNextLine()) {
                taskList.addItem(scn.nextLine());
            }
            scn.close();
            int res = taskList.countRepeated();
            System.out.println(res);
            int res2 = taskList.countOverlaped();
            System.out.println(res2);
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
    }
}
