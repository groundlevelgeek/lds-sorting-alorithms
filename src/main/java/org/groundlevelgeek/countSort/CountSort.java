package org.groundlevelgeek.countSort;

import java.util.Arrays;

public class CountSort {

    public static void main(String[] args) {

        /*
            Plan: Key - Count - Assumption about data - 1. Must be countable (like numbers) 2. Fixed range like 20 or 50 elements
            Feasible for less number of elements to be sorted out.
            1. Start traversing the unsorted array from starting and increment values in index (count array)
                equals to element's value (from input array).
            2. Repeat this process until we traverse through the complete array.
            3. Then start traversing through count array
                and place index value based on count in input array until we reach to the end of the count array.
         */

        int[] array = {1, 5, 18, 13, 19, 4, 4, 6, 5, 7, 8, 5, 9, 3, 17, 16, 15, 12, 2, 1};

        int[] countArray = new int[array.length];

        for (int index = 0; index < array.length; index++) {
            countArray[array[index]] += 1;
        }

        int iIndex = 0;
        for (int index = 0; index < countArray.length; index++) {
            var count = countArray[index];
            while (count > 0) {
                array[iIndex++] = index;
                count--;
            }
        }

        Arrays.stream(array).mapToObj(element -> element + ", ").forEach(System.out::print);

    }

}
