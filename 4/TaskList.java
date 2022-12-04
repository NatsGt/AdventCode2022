import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<List<String>> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addItem(String input) {
        List<String> group = new ArrayList<>();
        var separatedString = input.split(",");
        String firstString = getRange(separatedString[0]);
        String secondString = getRange(separatedString[1]);
        // System.out.println(firstString + " " + secondString);
        group.add(firstString);
        group.add(secondString);
        tasks.add(group);
    }

    public String getRange(String rangeString) {
        String num = "";
        String[] twoNumber = rangeString.split("-");
        for (int i = Integer.parseInt(twoNumber[0]); i <= Integer.parseInt(twoNumber[1]); i++) {
            num += i;
        }
        return num;
    }

    public int countRepeated() {
        int count = 0;
        for (List<String> list : tasks) {
            var firstList = list.get(0);
            var secondList = list.get(1);
            if (firstList.contains(secondList)) {
                count++;
                System.out.println(secondList + " count:" + count + " line " + tasks.indexOf(list));
            } else if (secondList.contains(firstList)) {
                count++;
                System.out.println(firstList + " count:" + count + " line " + tasks.indexOf(list));
            }
        }
        return count;
    }
}