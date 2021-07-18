package org.groundlevelgeek.bubblesort;

public class BubbleSort {

    public static void main(String[] args) {

        int[] array = new int[]{20, 35, -15, 7, 55, 1, -22};

        System.out.println("\n\n\nGiven Unsorted Array: -------\n");
        for (int value : array) {
            System.out.print(value + " , ");
        }

        int bubbleIndex = array.length - 1;

        while (bubbleIndex > 0) {
            for (int index = 0; index < bubbleIndex; index++) {
                if (array[index] > array[index + 1]) {
                    var holder = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = holder;
                }
            }
            bubbleIndex -= 1;
        }

        System.out.println("\n\nSorted Array using Bubble Sort: ----------\n");
        for (int value : array) {
            System.out.print(value + " , ");
        }
        System.out.println("\n\n");
    }
}
