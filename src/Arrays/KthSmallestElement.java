package Arrays;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElement {

    public static void main(String[] args) {
        List<Integer> array = ArrayUtil.getRandomArray(10, 0, 100);

        int k = 4;

        Integer kthSmallestElement = getKthSmallestElement(array, k);
        System.out.println("array = " + array);
        System.out.println("kthSmallestElement = " + kthSmallestElement);
    }

    private static Integer getKthSmallestElement(List<Integer> array, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.addAll(array);

        for (int i = 1; i < k; i++) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
