package org.groundlevelgeek.mergesort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        // Plan: Key (Merge - Divide and Concur) - One element is a sorted element
        /*
            1. Divide the input array into two halves
            2. Divide the first half until we reach to the one element array
            3. Start combining the got split array into one sorted array and it will return you the sorted half array (left side half)
            4. Repeat the step two and three with right half and return the right side sorted half
            5. Combine the both sorted array, Start traversing through left and right arrays from starting
               ,compare them and based on sorting way pick element from desired array and put it on actual input array
               then move traversal index to next in selected element array and compare with same index value in right array,
               once we are done with traversal from any one of left/right array. Start pushing remaining element from array to actual array via traversing actual array.
         */

        // Implementation:
        int[] array = new int[]{20, 35, -15, 7, 1, 55, -22};

        System.out.println("\n===> Input Array:");
        Arrays.stream(array).mapToObj(element -> element + ", ").forEach(System.out::print);

        array = mergeSort(array);

        System.out.println("\n\n===> Final Sorted Array:");
        System.out.println("*************************************");
        Arrays.stream(array).mapToObj(element -> element + ", ").forEach(System.out::print);
        System.out.println("\n*************************************");

    }

    private static int[] mergeSort(int[] array) {

        if (array.length < 2) {
            return array;
        }

        System.out.println("\n--------------------------------");

        System.out.println("\n\n===> Dividing into halves:");
        Arrays.stream(array).mapToObj(element -> element + ", ").forEach(System.out::print);

        int midpoint = array.length / 2;
        int index = 0;
        int left[] = new int[midpoint];
        while (index < left.length) {
            left[index] = array[index];
            index++;
        }
        System.out.println("\n*Left half:");
        Arrays.stream(left).mapToObj(element -> element + ", ").forEach(System.out::print);

        int jIndex = 0;
        int right[] = new int[array.length - midpoint];
        while (jIndex < right.length) {
            right[jIndex] = array[jIndex + midpoint];
            jIndex++;
        }
        System.out.println("\n*Right half:");
        Arrays.stream(right).mapToObj(element -> element + ", ").forEach(System.out::print);

        int l[] = mergeSort(left);
        int r[] = mergeSort(right);

        System.out.println("\n--------------------------------");
        return merge(array, l, r);
    }

    private static int[] merge(int[] array, int[] left, int[] right) {

        System.out.println("===> Combining Left and Right to One Array:");

        System.out.println("*Left:");
        Arrays.stream(left).mapToObj(element -> element + ", ").forEach(System.out::print);

        System.out.println("\n*Right:");
        Arrays.stream(right).mapToObj(element -> element + ", ").forEach(System.out::print);

        int lIndex = 0, rIndex = 0, sIndex = 0;
        for (lIndex = 0; lIndex < left.length && rIndex < right.length; ) {
            if (left[lIndex] < right[rIndex]) {
                array[sIndex++] = left[lIndex++];
            } else {
                array[sIndex++] = right[rIndex++];
            }
        }

        while (rIndex < right.length) {
            array[sIndex++] = right[rIndex++];
        }

        while (lIndex < left.length) {
            array[sIndex++] = left[lIndex++];
        }


        System.out.println("\n===> Combined Sorted Array:");
        Arrays.stream(array).mapToObj(element -> element + ", ").forEach(System.out::print);
        return array;
    }


}
