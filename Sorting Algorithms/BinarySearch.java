package Algorithms;

public class BinarySearch {

    public static int BinSearch(int[] list, int target) {
        int left = 0;
        int right = list.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target < list[mid]) {
                right = mid - 1;
            } else if (target > list[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

//        In Binary Search Array should be sorted if not sorted then first sort the array

        int[] list = {1, 2, 3, 4, 5};

        int target = 5;

        int ans = BinSearch(list, target);

        System.out.println(target+" at index : " + ans);
    }
}
