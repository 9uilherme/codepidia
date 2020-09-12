package questions.common;

public abstract class BTree<T> {
    protected Comparable[] arr;
    protected int size = 0;
    protected int maxSize;
    protected Boolean isLeaf(int pos) {
        return pos >= (size/2) && pos < size;
    }
    protected int getParentPosition(int position) {
        return (position - 1)/2 ;
    }
    protected int getLeftChild(int position) {
        return 2 * position + 1;
    }
    protected int getRightChild(int position) {
        return getLeftChild(position) + 1;
    }
    protected abstract void insert(T item);
    protected void swap(int pos1, int pos2) {
        Comparable aux = arr[pos2];
        arr[pos2] = arr[pos1];
        arr[pos1] = aux;
    }
}
