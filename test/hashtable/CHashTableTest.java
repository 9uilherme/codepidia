package hashtable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CHashTableTest {

    @Test
    void shouldGetOne() throws Exception {
        String name = "Guilherme";
        String country = "Brazil";
        CHashTable cHashTable = new CHashTable(4);
        cHashTable.put(name, country);

        Assertions.assertEquals("Brazil", cHashTable.get("Guilherme"));
    }

    @Test
    void shouldNotGetOne() {
        CHashTable cHashTable = new CHashTable(4);

        Assertions.assertThrows(Exception.class, () -> cHashTable.get("Guilherme"));
    }

    /**
     * Collision was forced in order to see if all works
     */

    @Test
    void shouldGetMultiple() throws Exception {
        String name = "Guilherme";
        String country = "Brazil";
        String name2 = "Maria";
        String country2 = "Portugal";
        String name3 = "Amara";
        String country3 = "Angola";

        CHashTable cHashTable = new CHashTable(2);

        cHashTable.put(name, country);
        cHashTable.put(name2, country2);
        cHashTable.put(name3, country3);

        Assertions.assertEquals("Brazil", cHashTable.get("Guilherme"));
        Assertions.assertEquals("Portugal", cHashTable.get("Maria"));
        Assertions.assertEquals("Angola", cHashTable.get("Amara"));
    }

    @Test
    void shouldPut() {
        String name = "Guilherme";
        String country = "Brazil";
        String name2 = "Maria";
        String country2 = "Portugal";
        String name3 = "Amara";
        String country3 = "Angola";

        CHashTable cHashTable = new CHashTable(2);

        cHashTable.put(name, country);
        cHashTable.put(name2, country2);
        cHashTable.put(name3, country3);

        Assertions.assertEquals(3, cHashTable.getQuantity());
    }

}
