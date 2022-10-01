package Algorithms;

public class LinearSearch {

    public static int LinearSearch(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int arr[] = {1, 3, 54, 567, 56, 100, 300};

        int target = 100;

        int index = LinearSearch(arr, target);

        System.out.println(target + " is present at index " + index);

        //Time Complexity : O(n)
    }
}
