package sort;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MergeSorterTest {

    @Test
    public void shouldSort() {
        int arr [] = {5, 2, 1, 20, 4, 11, 12};
        int expected [] = {1, 2, 4, 5, 11, 12, 20};
        Assertions.assertArrayEquals(expected, MergeSorter.sort(arr));
    }

    @Test
    public void shouldNotSortGenericInteger() {
        List<Integer> arr = List.of(5, 2, 1, 20, 4, 11, 12);
        List<Integer> expected = List.of(1, 2, 4, 5, 8, 12, 20);
        Assertions.assertNotEquals(expected, GenericMergeSorter.sort(arr));
    }

    @Test
    public void shouldSortGenericInteger() {
        List<Integer> arr = List.of(5, 2, 1, 20, 4, 11, 12);
        List<Integer> expected = List.of(1, 2, 4, 5, 11, 12, 20);
        Assertions.assertEquals(expected, GenericMergeSorter.sort(arr));
    }

    @Test
    public void shouldNotSortGenericChar() {
        List<Character> arr = List.of('C', 'B', 'A', 'Z');
        List<Character> expected = List.of('A', 'B', 'Z', 'C');
        Assertions.assertNotEquals(expected, GenericMergeSorter.sort(arr));
    }

    @Test
    public void shouldSortGenericChar() {
        List<Character> arr = List.of('C', 'B', 'A', 'Z');
        List<Character> expected = List.of('A', 'B', 'C', 'Z');
        Assertions.assertEquals(expected, GenericMergeSorter.sort(arr));
    }

    @Test
    public void shouldSortProduct() {
        List<Product> arr = List.of(new Product(3), new Product(1), new Product(10), new Product(55), new Product(4));
        List<Product> expected = List.of(new Product(1), new Product(3), new Product(4), new Product(10), new Product(55));
        Assertions.assertEquals(expected, GenericMergeSorter.sort(arr));
    }


    @Test
    public void shouldNotSortProduct() {
        List<Product> arr = List.of(new Product(3), new Product(1), new Product(10), new Product(55), new Product(4));
        List<Product> expected = List.of(new Product(1), new Product(2), new Product(4), new Product(10), new Product(55));
        Assertions.assertNotEquals(expected, GenericMergeSorter.sort(arr));
    }



}

@AllArgsConstructor
@Data
class Product implements Comparable<Product> {

    private Integer health;

    @Override
    public int compareTo(Product product) {
        return product.getHealth().compareTo(health) * -1;
    }
}
