package sort;

import java.util.ArrayList;
import java.util.List;

public class GenericMergeSorter {

    public static <T extends Comparable<? super T>> List<T> sort(List<T> arr) {
        return divide(new ArrayList<>(arr), 0, arr.size()-1);
    }

    private static <T extends Comparable<? super T>> List<T> divide (List<T> arr, int first, int last) {
        if (first >= last) return null;
        int middle = (last+first)/2;
        divide(arr, first, middle);
        divide(arr, middle+1, last);
        merge(arr, first, middle, last);
        return arr;
    }

    private static <T extends Comparable<? super T>> void merge(List<T> arr, int first, int middle, int last) {
        int range = last - first + 1;
        ArrayList<T> aux = new ArrayList<>();
        int leftCounter = first;
        int rightCounter = middle+1;

        for (int i = 0; i < range; i++)
            if (rightCounter > last) aux.add(arr.get(leftCounter++));
            else if (leftCounter > middle) aux.add(arr.get(rightCounter++));
            else if (arr.get(leftCounter).compareTo(arr.get(rightCounter)) < 0) aux.add(arr.get(leftCounter++));
            else if (arr.get(leftCounter).compareTo(arr.get(rightCounter)) >= 0) aux.add(arr.get(rightCounter++));

        for (int i = 0; i < range; i++) arr.set(first++, aux.get(i));
    }
}
