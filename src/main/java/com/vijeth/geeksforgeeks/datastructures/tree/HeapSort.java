package com.vijeth.geeksforgeeks.datastructures.tree;

public class HeapSort {
    private static void sort(int[] arr){
        int n = arr.length;
        //Construct max-heap
        for(int i = n/2-1; i>=0 ; i--){
            heapify(arr, n, i);
        }

        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }

    }

    private static void heapify(int[] arr, int n, int i) {
        int maxIndex = i;
        int leftChildIndex = leftChildIndex(i);
        int rightChildIndex = rightChildIndex(i);

        if (leftChildIndex < n && arr[maxIndex] < arr[leftChildIndex]) {
            maxIndex = leftChildIndex;
        }

        if (rightChildIndex < n && arr[maxIndex] < arr[rightChildIndex]) {
            maxIndex = rightChildIndex;
        }

        if (maxIndex != i) {
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
            heapify(arr, n, maxIndex);
        }
    }

    private static int leftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private static int rightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};

        System.out.println("\nBefore heapify:");
        for (int anArr : arr) {
            System.out.println(anArr + "\t");
        }
        System.out.println();
        sort(arr);

        System.out.println("\nAfter heapify:");
        for (int anArr : arr) {
            System.out.println(anArr + "\t");
        }
    }
}
