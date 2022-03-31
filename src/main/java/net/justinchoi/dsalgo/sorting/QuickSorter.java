package net.justinchoi.dsalgo.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSorter implements Sorter {
    @Override
    public List<Integer> sortAscending(List<Integer> unsortedList) {
        if (unsortedList.size() == 2) {
            if (unsortedList.get(0) < unsortedList.get(1)) {
                return unsortedList;
            } else {
                return new ArrayList<>(Arrays.asList(unsortedList.get(1), unsortedList.get(0)));
            }
        } else if (unsortedList.size() > 2) {
            List<Integer> smaller = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();
            int pivotIdx = (int) Math.random() * (unsortedList.size() - 1);
            int pivot = unsortedList.get(pivotIdx);
            for (int i = 1; i < unsortedList.size(); i++) {
                if (unsortedList.get(i) <= pivot) { smaller.add(unsortedList.get(i)); }
                else { larger.add(unsortedList.get(i)); }
            }
            List<Integer> sorted = sortAscending(smaller);
            sorted.add(pivot);
            sorted.addAll(sortAscending(larger));
            return sorted;
        } else {
            return unsortedList;
        }
    }


    @Override
    public List<Integer> sortDescending(List<Integer> unsortedList) {
        if (unsortedList.size() == 2) {
            if (unsortedList.get(0) > unsortedList.get(1)) {
                return unsortedList;
            } else {
                return new ArrayList<>(Arrays.asList(unsortedList.get(1), unsortedList.get(0)));
            }
        } else if (unsortedList.size() > 2) {
            List<Integer> smaller = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();
            int pivotIdx = (int) Math.random() * (unsortedList.size() - 1);
            int pivot = unsortedList.get(pivotIdx);
            for (int i = 1; i < unsortedList.size(); i++) {
                if (unsortedList.get(i) <= pivot) { smaller.add(unsortedList.get(i)); }
                else { larger.add(unsortedList.get(i)); }
            }
            List<Integer> sorted = sortDescending(larger);
            sorted.add(pivot);
            sorted.addAll(sortDescending(smaller));
            return sorted;
        } else {
            return unsortedList;
        }
    }
}
