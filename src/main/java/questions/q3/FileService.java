package questions.q3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileService {

    public static Map<String, List<String>> findBooks(List<String> words) {
        Map<String, List<String>> map = new HashMap<>();
        FileRepository.files
                .forEach((key, value) ->
                    words.stream()
                            .filter(value::contains)
                            .forEach(s -> {
                                if (map.containsKey(s)) {
                                    map.get(s).add(key);
                                } else {
                                    List<String> list = new ArrayList<>();
                                    list.add(key);
                                    map.put(s, list);
                                }
                            }));
        return map;
    }
}
