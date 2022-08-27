package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class MoveAllNegativeOneSide {

    public static void main(String[] args) {
        List<Integer> array = ArrayUtil.getRandomArray(20, -100, 200);

        System.out.println("array = " + array);

//        array = moveNegativeOneSideUsingDeque(array);
        array = moveNegativeOneSideUsingConstantSpace(array);

        System.out.println("array = " + array);
    }

    private static List<Integer> moveNegativeOneSideUsingConstantSpace(List<Integer> array) {
        int leftIndex = 0;
        int rightIndex = 1;

        while(leftIndex < array.size() && rightIndex < array.size()) {
            int left = array.get(leftIndex);
            int right = array.get(rightIndex);

            if (right < 0) {
                array.set(leftIndex, right);
                array.set(rightIndex, left);
                leftIndex++;
            }

            rightIndex++;
        }

        return array;
    }

    private static List<Integer> moveNegativeOneSideUsingDeque(List<Integer> array) {
        Deque<Integer> deque = new ArrayDeque<>();

        array.forEach(element -> {
            if(element < 0) {
                deque.addFirst(element);
            } else {
                deque.addLast(element);
            }
        });

        return deque.stream().toList();
    }
}
