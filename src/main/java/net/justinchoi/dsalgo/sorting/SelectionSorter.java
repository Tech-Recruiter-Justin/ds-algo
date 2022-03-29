package net.justinchoi.dsalgo.sorting;

import java.util.ArrayList;
import java.util.List;

public class SelectionSorter implements Sorter {
    @Override
    public List<Integer> sortAscending(List<Integer> originalList) {
        if (originalList.size() > 1) {
            List<Integer> sortedList = new ArrayList<>();
            while (!originalList.isEmpty()) {
                int smallest = originalList.get(0);
                int smallestIdx = 0;
                for (int i = 1; i < originalList.size(); i++) {
                    if (originalList.get(i) < smallest) {
                        smallest = originalList.get(i);
                        smallestIdx = i;
                    }
                }
                originalList.remove(smallestIdx);
                sortedList.add(smallest);
            }
            return sortedList;
        }
        return originalList;
    }

    @Override
    public List<Integer> sortDescending(List<Integer> originalList) {
        if (originalList.size() > 1) {
            List<Integer> sortedList = new ArrayList<>();
            while (!originalList.isEmpty()) {
                int largest = originalList.get(0);
                int largestIdx = 0;
                for (int i = 1; i < originalList.size(); i++) {
                    if (originalList.get(i) > largest) {
                        largest = originalList.get(i);
                        largestIdx = i;
                    }
                }
                originalList.remove(largestIdx);
                sortedList.add(largest);
            }
            return sortedList;
        }
        return originalList;
    }
}