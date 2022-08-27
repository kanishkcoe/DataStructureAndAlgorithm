package Arrays;

import java.util.ArrayList;
import java.util.List;

//Find the maximum and minimum element in an array
public class MinMaxInArray {
    public static class Pair {
        int min;
        int max;

        @Override
        public String toString() {
            return "Pair{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Integer> array = getRandomArray(10, 0, 100);

        Pair minMax = getMinMaxLinearSearch(array);
//        Pair minMax = getMinMaxRecursion(array, 0, array.size() - 1);
//        Pair minMax = getMinMaxPairComparison(array);

        System.out.println("array = " + array);
        System.out.println("minMax = " + minMax);
    }

    private static Pair getMinMaxPairComparison(List<Integer> array) {
        Pair minMax = new Pair();
        int arraySize = array.size();
        int i = 0;

        if(arraySize % 2 == 0) {
            if(array.get(0) < array.get(1)) {
                minMax.max = array.get(1);
                minMax.min = array.get(0);
            } else {
                minMax.max = array.get(0);
                minMax.min = array.get(1);
            }

            i = 2;
        } else {
            minMax.max = array.get(0);
            minMax.min = array.get(0);
            i = 1;
        }

        while (i < arraySize) {
            if(array.get(i) < array.get(i + 1)) {
                if (array.get(i) < minMax.min) {
                    minMax.min = array.get(i);
                }
                if (array.get(i + 1) > minMax.max) {
                    minMax.max = array.get(i + 1);
                }
            }
            if(array.get(i) > array.get(i + 1)) {
                if (array.get(i + 1) < minMax.min) {
                    minMax.min = array.get(i + 1);
                }
                if (array.get(i) > minMax.max) {
                    minMax.max = array.get(i);
                }
            }
            i += 2;
        }

        return minMax;
    }

    private static Pair getMinMaxRecursion(List<Integer> array, int low, int high) {
        Pair minMax = new Pair();
        Pair minMaxLeft = new Pair();
        Pair minMaxRight = new Pair();

        //only one element in the array
        if(low == high) {
            minMax.max = array.get(low);
            minMax.min = array.get(low);
            return minMax;
        }

        //only two element in the array
        if(high == low + 1) {
            if(array.get(high) > array.get(low)) {
                minMax.max = array.get(high);
                minMax.min = array.get(low);
                return minMax;
            } else {
                minMax.max = array.get(low);
                minMax.min = array.get(high);
                return minMax;
            }
        }

        //for more than 2 elements in array we will divide the array into 2 parts
        //find minmax of left array and minmax of right array
        int mid = (low + high) / 2;

        minMaxLeft = getMinMaxRecursion(array, low, mid);
        minMaxRight = getMinMaxRecursion(array, mid + 1, high);

        if(minMaxLeft.min < minMaxRight.min) {
            minMax.min = minMaxLeft.min;
        } else {
            minMax.min = minMaxRight.min;
        }
        if(minMaxLeft.max > minMaxRight.max) {
            minMax.max = minMaxLeft.max;
        } else {
            minMax.max = minMaxRight.max;
        }

        return minMax;
    }

    // method 1
    private static Pair getMinMaxLinearSearch(List<Integer> array) {
        Pair minMax = new Pair();
        minMax.min = array.get(0);
        minMax.max = array.get(0);

        for(Integer element : array) {
            if(element < minMax.min) {
                minMax.min = element;
            }
            if(element > minMax.max) {
                minMax.max = element;
            }
        }

        return minMax;
    }

    private static List<Integer> getRandomArray(int size, int lowRange, int highRange) {
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Double element = Math.random() * highRange + lowRange;
            array.add((element.intValue()));
        }
        return array;
    }
}
