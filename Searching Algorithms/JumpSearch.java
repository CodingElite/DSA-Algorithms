public class JumpSearch {
    public static int jumpSearch(int[] arr, int x) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));

        int prev = 0;
        while (arr[Math.min(step, n) - 1] < x) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }

        while (arr[prev] < x) {
            prev++;
            if (prev == Math.min(step, n))
                return -1;
        }

        if (arr[prev] == x)
            return prev;

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 2, 3, 4, 5, 6, 7,
                8, 11, 34, 56, 89, 90, 90 };
        int x = 5;

        int index = jumpSearch(arr, x);

        System.out.println("\nNumber " + x + " is at index " + index);
    }
}
