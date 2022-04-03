package net.justinchoi.dsalgo.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DijkstraTest {

    Map<String, Map<String, Integer>> cityMap = new HashMap<>();
    Map<String, Map<String, Integer>> cityMapLarge = new HashMap<>();

    @Before
    public void setup() {
        cityMap.put("start", new HashMap<String, Integer>() {{
            put("sciencepark", 6);
            put("university", 2);
        }});
        cityMap.put("sciencepark", new HashMap<String, Integer>() {{
            put("end", 1);
        }});
        cityMap.put("university", new HashMap<String, Integer>() {{
            put("sciencepark", 3);
            put("end", 5);
        }});
        cityMap.put("end", new HashMap<String, Integer>());

        cityMapLarge.put("start", new HashMap<String, Integer>() {{
            put("central", 5);
            put("thepeak", 2);
        }});
        cityMapLarge.put("central", new HashMap<String, Integer>() {{
            put("wanchai", 4);
            put("causewaybay", 2);
        }});
        cityMapLarge.put("thepeak", new HashMap<String, Integer>() {{
            put("central", 8);
            put("causewaybay", 7);
        }});
        cityMapLarge.put("wanchai", new HashMap<String, Integer>() {{
            put("causewaybay", 6);
            put("end", 3);
        }});
        cityMapLarge.put("causewaybay", new HashMap<String, Integer>() {{
            put("end", 1);
        }});
        cityMapLarge.put("end", new HashMap<String, Integer>());
    }

    @Test
    public void findFastestPath_WeightedMap_ReturnsPathWithLowestTotalWeight() {
        List<String> fastestPath = Dijkstra.findFastestPath(cityMapLarge);
        assertEquals(new ArrayList<>(Arrays.asList("start", "central", "causewaybay", "end")), fastestPath);
    }

}
