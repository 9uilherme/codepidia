package sort;

public class MergeSorter {

    public static int [] sort(int [] arr) {
        return divide(arr, 0, arr.length-1);
    }

    private static int [] divide (int [] arr, int first, int last) {
        if (first >= last) return null;
        int middle = (last+first)/2;
        divide(arr, first, middle);
        divide(arr, middle+1, last);
        merge(arr, first, middle, last);
        return arr;
    }

    private static void merge(int [] arr, int first, int middle, int last) {
        int range = last - first + 1;
        int [] aux = new int[range];
        int leftCounter = first;
        int rightCounter = middle+1;

        for (int i = 0; i < range; i++)
            if (rightCounter > last) aux[i] = arr[leftCounter++];
            else if (leftCounter > middle) aux[i] = arr[rightCounter++];
            else if (arr[leftCounter] < arr[rightCounter]) aux[i] = arr[leftCounter++];
            else if (arr[leftCounter] >= arr[rightCounter]) aux[i] = arr[rightCounter++];

        for (int i = 0; i < range; i++) arr[first++] = aux[i];
    }

    public static void printSorted(int arr[]) {
        sort(arr);
        for (int i = 0; i < arr.length; i++) System.out.println(arr[i]);
    }
}
