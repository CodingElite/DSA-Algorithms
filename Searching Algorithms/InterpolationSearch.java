class InterpolationSearch {
    public static int interpolationSearch(int[] arr, int lo, int hi, int x) {
        int pos;

        if (lo <= hi && x >= arr[lo] && x <= arr[hi]) {
            pos = lo + (((hi - lo) / (arr[hi] - arr[lo])) * (x - arr[lo]));
            if (arr[pos] == x)
                return pos;

            if (arr[pos] < x)
                return interpolationSearch(arr, pos + 1, hi, x);

            if (arr[pos] > x)
                return interpolationSearch(arr, lo, pos - 1, x);
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = { 0, 1, 2, 2, 3, 4, 5, 6, 7,
                8, 11, 34, 56, 89, 90, 90 };
        int n = arr.length;

        int x = 5;
        int index = interpolationSearch(arr, 0, n - 1, x);

        if (index != -1)
            System.out.println("Element found at index " + index);
        else
            System.out.println("Element not found.");
    }
}
