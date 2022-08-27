package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sort012Array {

    public static void main(String[] args) {
        List<Integer> array = ArrayUtil.getRandomArray(20, 0, 3);

        System.out.println("array = " + array);
        array = sortArray(array);
        System.out.println("array = " + array);
    }

    private static List<Integer> sortArray(List<Integer> array) {
        Map<Integer, Integer> count = new HashMap();

        count.put(0, 0);
        count.put(1, 0);
        count.put(2, 0);

        array.forEach(element -> count.put(element, count.get(element) + 1));

        System.out.println("count = " + count);

        List<Integer> newArray = new ArrayList<>();

        newArray = fillArray(newArray, 0, count.get(0));
        newArray = fillArray(newArray, 1, count.get(1));
        newArray = fillArray(newArray, 2, count.get(2));

        return newArray;
    }

    private static List<Integer> fillArray(List<Integer> array, int element, Integer count) {
        for (int i = 0; i < count; i++) {
            array.add(element);
        }

        return array;
    }
}
