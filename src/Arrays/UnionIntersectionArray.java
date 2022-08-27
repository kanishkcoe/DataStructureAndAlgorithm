package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnionIntersectionArray {

    public static void main(String[] args) {
        List<Integer> a = ArrayUtil.inputArray(new ArrayList<>(), 10);
        List<Integer> b = ArrayUtil.inputArray(new ArrayList<>(), 10);

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        List<Integer> union = getUnionOf(a, b);
        List<Integer> intersection = getIntersectionOf(a, b);

        System.out.println("union = " + union);
        System.out.println("intersection = " + intersection);
    }

    private static List<Integer> getIntersectionOf(List<Integer> a, List<Integer> b) {
        Set<Integer> union = new HashSet<>();
        union.addAll(a);
        Set<Integer> intersection = new HashSet<>();

        b.forEach(element -> {
            if(union.contains(element)) {
                intersection.add(element);
            }
        });

        return intersection.stream().toList();
    }

    private static List<Integer> getUnionOf(List<Integer> a, List<Integer> b) {
        Set<Integer> union = new HashSet<>();
        union.addAll(a);
        union.addAll(b);

        return union.stream().toList();
    }
}
