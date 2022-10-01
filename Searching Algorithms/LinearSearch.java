import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6,7,8,9};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the element to search");
        int ele = sc.nextInt();
        boolean check = false;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==ele){
                check=true;
                break;
            }
        }
        if(check){
            System.out.println("Present");
        }
        else{
            System.out.println("Not Present");
        }
    }
}
