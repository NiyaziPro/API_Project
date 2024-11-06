package practice.test_data;

import java.util.HashMap;
import java.util.Map;

public class RegressTestData {
    public static Map<String, Object> regresDataMapper(String name, String job, String id, String createdAt) {
        Map<String, Object> map = new HashMap<>();
        if (name != null) {
            map.put("name", name);
        }
        if (job != null) {
            map.put("job", job);
        }
        if (id != null) {
            map.put("id", id);
        }
        if (createdAt != null) {
            map.put("createdAt", createdAt);
        }

        return map;
    }

    public static String stringBody(String name, String job, String id, String createdAt) {
        return "{\n" +
                "              \"name\": \"" + name + "\",\n" +
                "              \"job\": \"" + job + "\",\n" +
                "              \"id\": \"" + id + "\",\n" +
                "              \"createdAt\": \"" + createdAt + "\"\n" +
                "           }";
    }
}
