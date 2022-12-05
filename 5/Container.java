import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Container {
    private Map<Integer, List<String>> containers;
    private List<String> instructions;

    public Container() {
        containers = new HashMap<>();
        instructions = new ArrayList<>();
    }

    public void addBox(String box, int container) {
        if (box.trim().length() > 0) {
            if (!containers.containsKey(container)) {
                List<String> listOfBoxes = new ArrayList<>();
                listOfBoxes.add(box);
                containers.put(container, listOfBoxes);
            } else {
                List<String> existingList = containers.get(container);
                existingList.add(box);
                containers.replace(container, existingList);
            }
        }
    }

    public void print() {
        containers.forEach((key, val) -> {
            System.out.println("in container " + key);
            for (String string : val) {
                System.out.println(string);
            }
        });

    }

    public void addInstructions(String ins) {
        if (ins.length() > 0) {
            instructions.add(ins);
        }

    }

    public void readInstructions() {
        Pattern pattern2 = Pattern.compile("(\\d)");
        for (String string : instructions) {
            Matcher number = pattern2.matcher(string);
            List<Integer> steps = new ArrayList<>();
            int index = 0;
            while (number.find() && index <= 2) {
                steps.add(Integer.parseInt(number.group(0)));
            }
            moveBoxes(steps.get(0), steps.get(1), steps.get(2));
        }
    }

    public void moveBoxes(int amount, int from, int to) {
        List<String> boxes = containers.get(from);
        if (boxes.size() >= amount) {
            var boxesToMove = boxes.subList(0, amount);
            List<String> newBoxesList = containers.get(to);
            for (String box : boxesToMove) {
                newBoxesList.add(0, box);
            }
            containers.replace(to, newBoxesList);
            if (boxes.size() > 1) {
                containers.replace(from, boxes.subList(amount, boxes.size()));
            } else {
                containers.replace(from, new ArrayList<>());
            }
        }

    }

    public String getTopBoxes() {
        var topBoxes = "";
        for (List<String> oneContainer : containers.values()) {
            if (oneContainer.size() > 0) {
                var boxes = oneContainer.get(0);
                topBoxes += boxes;
            }

        }
        return topBoxes;
    }

}
