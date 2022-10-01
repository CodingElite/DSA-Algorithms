import java.util.Scanner;
public class binarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = {11,234,567,5678,8908,9876,9878,56789};
        System.out.println("Enter the Element you want to search");
        int ele = sc.nextInt();
        int pos= binarySearch(arr,0,arr.length-1,ele);
        if(pos==arr.length){
            System.out.println("Not present");
        }
        else {
            System.out.println("The given element is present at position " + (pos + 1));
        }



    }
    public static int binarySearch(int[] a, int i, int l, int x){
        if(x>a[l]){
            return ++l;
        }
        else {
            if (x == a[i]) {
                return i;
            } else {
                int mid = (i + l) / 2;
                if (x == a[mid]) {
                    return mid;
                } else if (x < a[mid]) {
                    return binarySearch(a, i, mid - 1, x);
                } else {
                    return binarySearch(a, mid + 1, l, x);
                }
            }
        }
    }
}