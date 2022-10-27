import java.util.Arrays;

public class ExponentialSearch {
    public static void main(String[] args) {
        int array[] = {5, 10, 15, 20, 25, 30, 33, 35, 40, 45, 50, 55, 60};

        int searchValue = 33;
        int result = expSearch(array, array.length, searchValue);
        System.out.println("Element is present at index: " + result);
    }

    static int expSearch(int array[], int n, int searchValue) {

        if (array[0] == searchValue) {
            return 0;
        }

        int i = 1;
        while (i < n && array[i] <= searchValue) {
            i = i * 2;
        }

        return Arrays.binarySearch(array, (i / 2), Math.min(i, n), searchValue);
    }
}