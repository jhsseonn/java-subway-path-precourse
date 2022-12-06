package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubwayRepository {
    private static final List<String[]> edges = new ArrayList<>();

    public static List<String[]> edges() {
        return Collections.unmodifiableList(edges);
    }

    public static void addEdge(String[] edge) {
        edges.add(edge);
    }

    public static void deleteAll() {
        edges.clear();
    }
}
