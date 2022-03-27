package net.justinchoi.dsalgo.binary_search;

import java.util.List;

public class BinarySearch {

    public BinarySearch() {}

    public static int binarySearch(List<Integer> numbers, int target) {
        int lowIndex = 0;
        int highIndex = numbers.size() - 1;

        if (numbers.isEmpty()) { return -1; }
        while(lowIndex <= highIndex) {
            int midIndex = (lowIndex + highIndex) / 2;
            int currentNumber = numbers.get(midIndex);
            if (target == currentNumber) { return midIndex; }
            if (target < currentNumber) {
                highIndex = midIndex - 1;
            } else {
                lowIndex = midIndex + 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(List<Integer> numbers, int target) {
        if (numbers.isEmpty()) return -1;
        return binarySearchRecursive(numbers, target, 0, numbers.size() - 1);
    }

    private static int binarySearchRecursive(List<Integer> numbers, int target, int lowIndex, int highIndex) {
        if (lowIndex > highIndex) { return -1; }
        int midIndex = (lowIndex + highIndex) / 2;
        int currentNumber = numbers.get(midIndex);
        if (currentNumber == target) { return midIndex; }
        if (target < currentNumber) { return binarySearchRecursive(numbers, target, lowIndex, midIndex - 1); }
        else { return binarySearchRecursive(numbers, target, midIndex + 1, highIndex); }
    }

}
