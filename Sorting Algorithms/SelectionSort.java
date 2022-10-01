package Algorithms;

public class SelectionSort {

    public static int[] SelectionSort(int arr[]) {
        //Selection Sort
        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[smallest] > arr[j]) {
                    smallest = j;
                }
            }

            //Swap
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void printArray(int arr[]) {

        System.out.println("Sorted Array using Selection Sort : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int arr[] = {7, 8, 3, 1, 2};

        SelectionSort(arr);

        printArray(arr);

        //Time Complexity : O(n^2)
    }
}
