package com.hackerrank.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FrequencyQueries {

    public static void main(String[] args) {


    }

    static List<Integer> freqQuery(List<List<Integer>> queries) {

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> numberToCount = new HashMap<>();
        Map<Integer, Set<Integer>> countToNumbers = new HashMap<>();
        for (int i = 0; i < queries.size(); i++) {
            if (queries.get(i).get(0) == 1) {
                int prevCount = numberToCount.getOrDefault(queries.get(i).get(1), 0);
                int currCount = prevCount + 1;

                numberToCount.put(queries.get(i).get(1), currCount);

                if (prevCount != 0) {
                    countToNumbers.get(prevCount).remove(queries.get(i).get(1));
                }

                if (!countToNumbers.containsKey(currCount)) {
                    countToNumbers.put(currCount, new HashSet<>());
                }
                countToNumbers.get(currCount).add(queries.get(i).get(1));
            } else if (queries.get(i).get(0) == 2) {
                if (numberToCount.containsKey(queries.get(i).get(1))) {
                    int prevCount = numberToCount.get(queries.get(i).get(1));
                    int currCount = prevCount - 1;

                    if (currCount == 0) {
                        numberToCount.remove(queries.get(i).get(1));
                    } else {
                        numberToCount.put(queries.get(i).get(1), currCount);
                    }

                    countToNumbers.get(prevCount).remove(queries.get(i).get(1));

                    if (currCount != 0) {
                        countToNumbers.get(currCount).add(queries.get(i).get(1));
                    }
                }
            } else if (queries.get(i).get(0) == 3) {
                result.add(countToNumbers.getOrDefault(queries.get(i).get(1), Collections.emptySet()).isEmpty() ? 0 : 1);
            }
        }
        return result;
    }
}
