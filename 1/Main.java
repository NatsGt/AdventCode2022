import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

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

    public static int getMax(List<List<Integer>> listOfList) {
        int maxNum = Integer.MIN_VALUE;
        for (List<Integer> list : listOfList) {
            int sumOfList = getSum(list);
            if (sumOfList > maxNum) {
                maxNum = sumOfList;
            }
        }
        return maxNum;
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

            var maxValue = getMax(result);
            System.out.println(maxValue);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}