package net.justinchoi.dsalgo.graph;

import java.util.*;

public class Dijkstra {

    public static List<String> findFastestPath(Map<String, Map<String, Integer>> cityMap) {
        // 1. Mark all cities with infinity distance except the start
        Map<String, Integer> distanceFromStart = new HashMap<>();
        for (String city : cityMap.keySet()) {
            if (!city.equals("start")) {
                distanceFromStart.put(city, Integer.MAX_VALUE);
            } else {
                distanceFromStart.put(city, 0);
            }
        }
        Map<String, String> parentCity = new HashMap<>();
        Set<String> unprocessed = new HashSet<>(distanceFromStart.keySet());

        String currentClosestCity;
        int currentDistance;
        while (!unprocessed.isEmpty()) {
            // 2a. Find the closest unprocessed city
            currentClosestCity = "start";
            currentDistance = Integer.MAX_VALUE;
            for (Map.Entry<String, Integer> path : distanceFromStart.entrySet()) {
                if (unprocessed.contains(path.getKey()) && path.getValue() < currentDistance) {
                    currentClosestCity = path.getKey();
                    currentDistance = path.getValue();
                }
            }
            // 2b. Process and remove the closest city
            unprocessed.remove(currentClosestCity);
            // 2c. Check and update the adjacent city distance and parent city if there is a shorter path
            for (Map.Entry<String, Integer> path : cityMap.get(currentClosestCity).entrySet()) {
                int totalDistanceFromStart = distanceFromStart.get(currentClosestCity);
                if (totalDistanceFromStart != Integer.MAX_VALUE) {
                     totalDistanceFromStart += path.getValue();
                }
                if (totalDistanceFromStart < distanceFromStart.get(path.getKey())) {
                    distanceFromStart.replace(path.getKey(), totalDistanceFromStart);
                    parentCity.put(path.getKey(), currentClosestCity);
                }
            }
        }
        // 3. Return the shortest path
        List<String> shortestPath = new ArrayList<>();
        shortestPath.add("end");
        String current = "end";
        while (current != "start") {
            shortestPath.add(0, parentCity.get(current));
            current = parentCity.get(current);
        }
        return shortestPath;
    }
}
