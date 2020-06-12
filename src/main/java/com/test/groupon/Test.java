package com.test.groupon;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args){
        System.out.println(minNum(9, Arrays.asList(1, 2, 3, 5, 8, 10, 40, 50)));
    }

    public static int minNum(int threshold, List<Integer> points) {

        int result = points.size();
        if (points.size() > 1) {

            int minNum = points.get(0), maxNum = points.get(points.size() - 1);

            if(threshold > (maxNum - minNum)){
                return result;
            }
            int counter = points.size() - 1;
            while (threshold <= (maxNum - minNum)){
                maxNum = points.get(--counter);
            }
            return (counter + 1) - (((counter + 1)/2) -1);
        }
        return result;
    }
}
