package net.justinchoi.dsalgo.binary_search;

import java.util.List;

public class BinarySearch {

    public BinarySearch() {}

    public static int binarySearch(List<Integer> numbers, int target) {
        int lowIndex = -1;
        int highIndex = numbers.size();

        if (numbers.isEmpty()) { return -1; }
        while(highIndex - lowIndex > 1) {
            int midIndex = lowIndex + (highIndex - lowIndex) / 2;
            int currentNumber = numbers.get(midIndex);
            if (target == currentNumber) { return midIndex; }
            if (target < currentNumber) {
                highIndex = midIndex;
            } else {
                lowIndex = midIndex;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(List<Integer> numbers, int target) {
        if (numbers.isEmpty()) return -1;
        return binarySearchRecursive(numbers, target, -1, numbers.size());
    }

    private static int binarySearchRecursive(List<Integer> numbers, int target, int lowIndex, int highIndex) {
        if (highIndex - lowIndex <= 1) { return -1; }
        int midIndex = lowIndex + (highIndex - lowIndex) / 2;
        int currentNumber = numbers.get(midIndex);
        if (currentNumber == target) { return midIndex; }
        if (target < currentNumber) { return binarySearchRecursive(numbers, target, lowIndex, midIndex); }
        else { return binarySearchRecursive(numbers, target, midIndex, highIndex); }
    }

}
