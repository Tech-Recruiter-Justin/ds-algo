package net.justinchoi.dsalgo.sorting;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SorterTestCases {

    final List<Integer> empty = new ArrayList<>();
    final List<Integer> single = new ArrayList<>(0);
    final List<Integer> large;
    final List<Integer> largeExpected;
    final List<Integer> normal = new ArrayList<>(Arrays.asList(3, -4, 100, 0, -29, 56));
    final List<Integer> normalExpected = new ArrayList<>(Arrays.asList(-29, -4, 0, 3, 56, 100));
    final List<Integer> withDuplication = new ArrayList<>(Arrays.asList(-90,0,3,45,3,12,3,-100));
    final List<Integer> withDuplicationExpected = new ArrayList<>(Arrays.asList(-100,-90,0,3,3,3,12,45));
    final List<Integer> identical = new ArrayList<>(Arrays.asList(1,1,1,1,1,1,1,1,1));
    final List<Integer> identicalExpected = new ArrayList<>(Arrays.asList(1,1,1,1,1,1,1,1,1));


    public SorterTestCases() throws IOException {
        this.large = setupLargeCase();
        this.largeExpected = setupLargeCaseExpected();
    }

    private List<Integer> setupLargeCase() throws IOException {
        ArrayList<Integer> largeCase = new ArrayList<>();
        Scanner s = new Scanner(Paths.get("large_case_unsort.txt")).useDelimiter(",");
        while(s.hasNext()) { largeCase.add(s.nextInt()); }
        return largeCase;
    }

    private List<Integer> setupLargeCaseExpected() throws IOException {
        ArrayList<Integer> largeCaseExpected = new ArrayList<>();
        Scanner s = new Scanner(Paths.get("large_case.txt")).useDelimiter(",");
        while(s.hasNext()) { largeCaseExpected.add(s.nextInt()); }
        return largeCaseExpected;
    }
}