package hashtable;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.val;

/**
 * Custom Hash Table
 */

@Getter
@Setter
public class CHashTable {

    private Node [] arr;
    private int quantity = 0;

    public CHashTable(int size) {
        this.arr = new Node[size];
    }

    public void put(String key, String value) {
        val hash = key.hashCode();
        val index = hash % arr.length;

        if (arr[index] == null) {
            /* This creates a linked list */
            arr[index] = new Node(key, value);
            quantity++;
        } else {
          Node current = arr[index];

          while (current.getNext() != null) {
              current = current.getNext();
          }

          Node next = new Node(key, value);
          quantity++;

          current.setNext(next);

        }

    }

    public String get(String key) throws Exception {
        val hash = key.hashCode();
        val index = hash % arr.length;

        Node curr = arr[index];
        while (curr != null) {
            if (curr.getKey().equals(key)) return curr.getValue();
            curr = curr.getNext();
        }
        throw new Exception(String.format("There is no such key (%s)", key));
    }

}

@Data
@RequiredArgsConstructor
class Node {

    private final String key;
    private final String value;
    private Node next = null;

}
