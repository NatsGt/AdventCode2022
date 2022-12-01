import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main2 {

    public static List<List<Integer>> addToList(List<String> inputList) {
        List<List<Integer>> elvesCalories = new ArrayList<>();
        List<Integer> caloriesList = new ArrayList<>();
        for (String string : inputList) {
            if (string.length() != 0) {
                caloriesList.add(Integer.parseInt(string));
            } else {
                elvesCalories.add(caloriesList);
                caloriesList = new ArrayList<>();
            }
        }
        return elvesCalories;
    }

    public static int getSum(List<Integer> listOfInt) {
        int sum = 0;
        for (Integer integer : listOfInt) {
            sum += integer;
        }
        return sum;
    }

    public static void main(String[] args) {

        File file = new File("input.txt");
        try {
            Scanner scanner = new Scanner(file);
            List<String> oneElve = new ArrayList<>();
            while (scanner.hasNextLine()) {
                var value = scanner.nextLine();
                oneElve.add(value);
            }
            scanner.close();
            var result = addToList(oneElve);
            List<Integer> listOfSums = result.stream().map(list -> getSum(list)).collect(Collectors.toList());
            Collections.sort(listOfSums, Collections.reverseOrder());
            var ans = listOfSums.subList(0, 3).stream().reduce(0, (sum, count) -> sum + count);
            System.out.println(ans);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
