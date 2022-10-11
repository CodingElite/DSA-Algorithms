#include <iostream>
#include <string.h>
#include <strings.h>
#include <string>
#include <bits/stdc++.h>

using namespace std;

int factorial(int n){
    if (n < 0) return -1;
    if (n==1 or n==0) return 1;
    return n * factorial(n-1);
}

int factorialIter(int n){
    if (n < 0) return -1;
    int ans = 1;
    while (n > 1){
        ans *= n;
        n--;
    }
    return ans;
}

int fibonacci(int a, int b, int n){
    if (n == 0) return a;
    if (n == 1) return b;
    return fibonacci(b, a+b, n-1);
}

void fibonacciIter(int n){
    int fib[n];
    fib[0] = 0;
    fib[1] = 0;
    for (int i=2; i<n; i++){
        fib[i] = fib[i-1] + fib[i-2];
    }
}

int binarySearch(int left, int right, int arr[], int val){
    if (left > right) return -1;
    int mid = (left + right)/2;

    if (arr[mid] == val) return mid;
    else if (arr[mid] < val){
        return binarySearch(mid+1, right, arr, val);
    }
    else{
        return binarySearch(left, mid-1, arr, val);
    }
}

int binarySearchIter(int arr[], int val, int n){
    int left = 0, right = n-1;
    while (left <= right){
        int mid = (left+right)/2;
        if (arr[mid] == val){
            return mid;
        }
        else if (arr[mid] < val){
            left = mid + 1;
        }
        else{
            right = mid - 1;
        }
    }
    return -1;
}

int fastExp(int a, int b){
    if (b == 0) return 1;

    int p = fastExp(a, b/2);
    if (b & 1) return p*p*a;
    return p*p;
}

int exponentiation(int a, int b){
    if (b == 0) return 1;
    return a * exponentiation(a, b-1);
}

int numberOfZeros(int number){
    if (number == 0) return 1;
    if (number < 10 && number > -10) return 0;

    // number/10 -> The recursive case for the rest of the digits
    // number%10 -> The recursive case for the current digit
    return numberOfZeros(number/10) + numberOfZeros(number%10);
}

// bool isPalindrome(const char* const s){
//     if (strlen(s) <= 1) return true;
    
//     else if (s[0] == s[strlen(s)-1]){
//         return isPalindrome(substring(s, 1, strlen(s)-2));
//     }
//     return false;
// }

bool isPalindrome(string s){
    if (s.length() <= 1) return true;

    int l = s.length();

    if (s[0] == s[l-1]){
        return isPalindrome(s.substr(1, l-2));
    }

    return false;
}


int main(){
    // for (int i=0; i<10; i++){
    //     int ans = fibonacci(0, 1, i);
    //     cout << ans << " ";
    // }
    // cout << endl;

    // int arr[5] = {1, 3, 5, 8, 9};
    // int ans = binarySearchIter(arr, 8, 5);
    // cout << ans << endl;

    // cout << numberOfZeros(10002300) << endl;

    cout << isPalindrome("apple") << endl;
    return 0;
}