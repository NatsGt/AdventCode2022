import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<List<String[]>> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addItem(String input) {
        List<String[]> group = new ArrayList<>();
        var separatedString = input.split(",");
        String[] firstRange = getLimits(separatedString[0]);
        String[] secondRange = getLimits(separatedString[1]);
        group.add(firstRange);
        group.add(secondRange);
        tasks.add(group);
    }

    public String[] getLimits(String rangeString) {
        String[] num = new String[1];
        num = rangeString.split("-");
        return num;
    }

    public int countRepeated() {
        int count = 0;
        for (List<String[]> list : tasks) {
            var firstList = list.get(0);
            var secondList = list.get(1);
            var firstLimit = Integer.parseInt(firstList[0]);
            var firstEndLimit = Integer.parseInt(firstList[1]);
            var secondLimit = Integer.parseInt(secondList[0]);
            var secondEndLimit = Integer.parseInt(secondList[1]);
            if (firstLimit >= secondLimit && firstEndLimit <= secondEndLimit) {
                count++;
            } else if (secondLimit >= firstLimit && secondEndLimit <= firstEndLimit) {
                count++;
            }
        }
        return count;
    }

    public int countOverlaped() {
        int count = 0;
        for (List<String[]> list : tasks) {
            var firstList = list.get(0);
            var secondList = list.get(1);
            var firstLimit = Integer.parseInt(firstList[0]);
            var firstEndLimit = Integer.parseInt(firstList[1]);
            var secondLimit = Integer.parseInt(secondList[0]);
            var secondEndLimit = Integer.parseInt(secondList[1]);
            if (secondLimit <= firstEndLimit && secondEndLimit >= firstEndLimit) {
                count++;
            } else if (firstLimit <= secondEndLimit && firstEndLimit >= secondEndLimit) {
                count++;
            }
        }
        return count;
    }
}