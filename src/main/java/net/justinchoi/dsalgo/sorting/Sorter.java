package net.justinchoi.dsalgo.sorting;

import java.util.List;

public interface Sorter {
    List<Integer> sortAscending(List<Integer> unsortedList);

    List<Integer> sortDescending(List<Integer> unsortedList);
}
