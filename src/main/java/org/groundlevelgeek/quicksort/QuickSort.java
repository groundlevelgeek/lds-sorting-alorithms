package org.groundlevelgeek.quicksort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        /*
         Plan: Key: Pivot, one element is sorted itself
         1. Peek the first element as pivot (Find its correct place in array)
         2. Start traversing the array from starting and endpoint
         3. If found any element is greater then pivot in traversing from start, place it to end to array
         4. Vice versa If found any element is smaller than pivot in traversing from endpoint, place it to left of pivot.
         5. Repeat this process until left array traversal do not cross right traversal, if cross at some point, place
            pivot element at the left array current traversal point.
         6. Repeat this process with left array (smaller elements thant pivot) and right array (greater elements than pivot)
            (If sorting way is asc)
         7. Repeat this process until we have only one element is array.
         */

        int[] array = {20, 35, -15, 7, 1, 55, -22, 0, 012, 33, 52, 45, 60, 32, -111};


        quickSort(array, 0, array.length - 1);
        Arrays.stream(array).mapToObj(element -> element + ", ").forEach(System.out::print);


    }

    private static void quickSort(int[] array, int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }

        int pivot = array[startIndex];
        int iIndex = startIndex;
        int jIndex = endIndex;

        while (iIndex < jIndex) {

            for (int j = jIndex; j > iIndex; j--, jIndex--) {
                if (array[j] < pivot) {
                    array[iIndex++] = array[j];
                    break;
                }
            }

            for (int i = iIndex; i < jIndex; i++, iIndex++) {
                if (array[i] > pivot) {
                    array[jIndex--] = array[i];
                    break;
                }
            }
        }

        array[iIndex] = pivot;

        quickSort(array, startIndex, iIndex - 1);
        quickSort(array, iIndex + 1, endIndex);

    }


}
