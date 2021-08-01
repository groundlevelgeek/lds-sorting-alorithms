package org.groundlevelgeek.shellsort;

import org.groundlevelgeek.insertionSort.InsertionSort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {

        // input array
        int[] array = new int[]{20, 35, -15, 7, 1, 55, -22, 10, 82, 25, 30, 64, 99, 111, 625};

        // plan:
        /*  Key: Based on Shell, shift elements and get more shorted array before applying insertion sort.
            1. Find the gap/interval to shift elements. (Many ways to find gaps/intervals,
               we will use array-length/2 to find gap.)
            2. Start traversing array from starting and pick element and compare with another element present at defined gap
               (based on sorting way asc/desc).
            3. Traverse until we reach the index equal to gap.
            4. once we reach while traversing up to index=gap, reduce the gap by division of 2 gain
               (as we did first time to find the initial gap).
            5. Repeat the steps from 2 to 4 and continue this up to we do not reach to the gap is equal to 1.
            // Now array is more shorted than raw input array, now we can sort this array using insertion sort.
            6. Sort this array using insertion sort.
         */

        // implementation: Ascending
        int gap = (int) array.length / 2;
        while (gap > 1) {
            for (var index = 0; index < array.length; index += gap) {
                if (index + gap > array.length - 1) {
                    break;
                }
                if (array[index] > array[index + gap]) {
                    var holder = array[index];
                    array[index] = array[index + gap];
                    array[index + gap] = holder;
                }
            }
            System.out.println("\nShell Traversal: " + gap);
            Arrays.stream(array).mapToObj(element -> element + ", ").forEach(System.out::print);

            gap = gap / 2;

        }

        InsertionSort.insertionSort(array);


    }


}
