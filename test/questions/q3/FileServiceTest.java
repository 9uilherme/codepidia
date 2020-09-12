package questions.q3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class FileServiceTest {

    @Test
    void shouldFindBooks() {
        Map<String, List<String>> map = FileService.findBooks(List.of("ok1", "ok2", "ok3"));
        Assertions.assertEquals(1, map.get("ok1").size());
        Assertions.assertEquals(2, map.get("ok2").size());
        Assertions.assertFalse(map.containsKey("ok3"));
    }
}
