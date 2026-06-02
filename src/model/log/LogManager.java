package model.log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class LogManager {
    private static final List<String> logs = new ArrayList<>();
    public static void log(String message) {
        logs.add(message);
        System.out.println(message);
    }
    public static List<String> getLogs() {
        return Collections.unmodifiableList(logs);
    }
    public static void clear() {
        logs.clear();
    }
}