package net.justinchoi.dsalgo.sorting;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSorterTest {
    SorterTestCases tc = new SorterTestCases();
    Sorter sorter = new QuickSorter();

    public QuickSorterTest() throws IOException {
    }

    @Test
    public void sortAscending_EmptyList_ReturnsEmptyList() {
        List<Integer> result = sorter.sortAscending(tc.empty);
        assertEquals(tc.empty, result);
    }

    @Test
    public void sortAscending_SingleElementList_ReturnsSingleElementList() {
        List<Integer> result = sorter.sortAscending(tc.single);
        assertEquals(tc.single, result);
    }

    @Test
    public void sortAscending_UnsortedList_ReturnsSortedList() {
        List<Integer> result = sorter.sortAscending(tc.normal);
        assertEquals(tc.normalExpected, result);
    }

    @Test
    public void sortAscending_UnsortedLargeList_ReturnsSortedList() {
        List<Integer> result = sorter.sortAscending(tc.large);
        assertEquals(tc.largeExpected, result);
    }

    @Test
    public void sortAscending_ListWithDuplicatedElements_ReturnsSortedList() {
        List<Integer> result = sorter.sortAscending(tc.withDuplication);
        assertEquals(tc.withDuplicationExpected, result);
    }

    @Test
    public void sortAscending_ListWithIdenticalElements_ReturnsSortedList() {
        List<Integer> result = sorter.sortAscending(tc.identical);
        assertEquals(tc.identicalExpected, result);
    }

    @Test
    public void sortDescending_EmptyList_ReturnsEmptyList() {
        List<Integer> result = sorter.sortDescending(tc.empty);
        assertEquals(tc.empty, result);
    }

    @Test
    public void sortDescending_SingleElementList_ReturnsSingleElementList() {
        List<Integer> result = sorter.sortDescending(tc.single);
        assertEquals(tc.single, result);
    }

    @Test
    public void sortDescending_UnsortedList_ReturnsSortedList() {
        List<Integer> result = sorter.sortDescending(tc.normal);
        List<Integer> reverse = new ArrayList<>(tc.normalExpected);
        Collections.reverse(reverse);
        assertEquals(reverse, result);
    }

    @Test
    public void sortDescending_UnsortedLargeList_ReturnsSortedList() {
        List<Integer> result = sorter.sortDescending(tc.large);
        List<Integer> reverse = new ArrayList<>(tc.largeExpected);
        Collections.reverse(reverse);
        assertEquals(reverse, result);
    }

    @Test
    public void sortDescending_ListWithDuplicatedElements_ReturnsSortedList() {
        List<Integer> result = sorter.sortDescending(tc.withDuplication);
        List<Integer> reverse = new ArrayList<>(tc.withDuplicationExpected);
        Collections.reverse(reverse);
        assertEquals(reverse, result);
    }

    @Test
    public void sortDescending_ListWithIdenticalElements_ReturnsSortedList() {
        List<Integer> result = sorter.sortDescending(tc.identical);
        List<Integer> reverse = new ArrayList<>(tc.identicalExpected);
        Collections.reverse(reverse);
        assertEquals(reverse, result);
    }
}
