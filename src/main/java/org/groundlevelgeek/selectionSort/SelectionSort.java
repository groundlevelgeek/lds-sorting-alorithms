package org.groundlevelgeek.selectionSort;

import java.util.Arrays;

public class SelectionSort {

    // Requirement - Sort unsorted array to sorted array
    // Sorting : Ascending
    // algorithm: Selection sort

    // Key idea: lastUnsortedIndex to pull toward start of array
    // and one each traversal with unsorted array from starting to
    // lastUnsortedIndex, keep selected largestElementIndex and on the end of traversal
    // replace the selected largest element with lastUnsortedIndex element and keep repeating this
    // traversal until lastUnsortedIndex reach to starting of array.

    public static void main(String[] args) {

        // given unsorted array
        // <<< input
        int[] array = new int[]{20, 35, -15, 7, 55, 1, -22};
        Arrays.stream(array).mapToObj(j -> j + ", ").forEach(System.out::print);
        // >>>>>

        // algorithm <<<<<
        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            var largestElementIndex = 0;
            for (int index = 0; index < lastUnsortedIndex; index++) {
                if (array[largestElementIndex] < array[index + 1]) {
                    largestElementIndex = index + 1;
                }
            }
            var holder = array[lastUnsortedIndex];
            array[lastUnsortedIndex] = array[largestElementIndex];
            array[largestElementIndex] = holder;

        }
        // >>>>>>

        //sorted array result
        // <<<<< output
        System.out.println("\n");
        Arrays.stream(array).mapToObj(element -> element + ", ").forEach(System.out::print);
        // >>>>>
    }

}
