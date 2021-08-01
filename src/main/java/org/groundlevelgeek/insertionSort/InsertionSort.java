package org.groundlevelgeek.insertionSort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] array = new int[]{20, 24, 35, 40, 25, 15, 7, -15, 55, 1, -22};
        insertionSort(array);

    }

    public static void insertionSort(int[] array) {

        System.out.println("\n\n");
        Arrays.stream(array).mapToObj(element -> element + ", ").forEach(System.out::print);

        // algorithm
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            var unsortedElementIndex = firstUnsortedIndex;
            var noSwap = false;
            for (int index = firstUnsortedIndex - 1; index > -1; index--) {
                if (array[unsortedElementIndex] < array[index]) {
                    var holder = array[index];
                    array[index] = array[unsortedElementIndex];
                    array[unsortedElementIndex] = holder;
                    unsortedElementIndex = index;
                    noSwap = true;
                }
                if (!noSwap) {
                    break;
                }
            }
        }

        System.out.println("\n\n");
        Arrays.stream(array).mapToObj(element -> element + ", ").forEach(System.out::print);

    }

}
