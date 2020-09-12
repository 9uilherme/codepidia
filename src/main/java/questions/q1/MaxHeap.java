package questions.q1;

import questions.common.BTree;

import java.util.ArrayList;

public class MaxHeap extends BTree<Comparable> {
    public MaxHeap(int maxSize) {
        this.size = 0;
        this.maxSize = maxSize;
        this.arr = new Comparable[maxSize];
    }

    public Comparable getMax() {
        return arr[0];
    }

    @Override
    public void insert(Comparable item) {
        if (size >= maxSize) return;
        int currPosition = size;
        arr[size++] = item;

        // while child is bigger than parent
        while (currPosition != 0 && item.compareTo(arr[getParentPosition(currPosition)]) > 0) {
            swap(currPosition, getParentPosition(currPosition));
            currPosition = getParentPosition(currPosition);
        }
    }

    public Comparable extractMax() {
        Comparable max = getMax();
        arr[0] = arr[size-1];
        size--;
        maxHeapify(0);
        return max;
    }

    public ArrayList<Comparable> getTops(int n) {
        if (n > size) n = size;
        ArrayList<Comparable> tops = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tops.add(extractMax());
        }
        return tops;
    }

    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            int left = getLeftChild(pos);
            int right = getRightChild(pos);

            if (arr[pos].compareTo(arr[left]) < 0 ||
                    arr[pos].compareTo(arr[right]) < 0) {
                if (arr[left].compareTo(arr[right]) > 0) {
                    swap(left, pos);
                    maxHeapify(left);
                } else {
                    swap(right, pos);
                    maxHeapify(right);
                }
            }
        }

    }
}
