package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayUtil {

    public static List<Integer> getRandomArray(int size, int lowRange, int highRange) {
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Double element = Math.random() * highRange + lowRange;
            array.add((element.intValue()));
        }
        return array;
    }

    public static List<Integer> inputArray(List<Integer> array, int size) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < size; i++) {
            System.out.printf("Enter %d element : ", i);
            array.add(scanner.nextInt());
        }

        return array;
    }
}
