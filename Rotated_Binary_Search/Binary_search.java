package Rotated_Binary_Search;

public class Binary_search {

    static int binarySearch(int arr[], int l, int r, int n) {
        if (arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return arr[0] == n ? 0 : -1;
        }
        if (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m] == n)
                return m;

            if (arr[l] > n && arr[m] > n)
                return binarySearch(arr, m + 1, r, n);
            
            return binarySearch(arr, l, m , n);
        }

        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {6, 8, 9, 1, 3, 5}; 
        int n = 8;

        int idx = binarySearch(arr, 0, arr.length - 1, n);
        
        System.out.println((idx == -1) ? "Element not found" : "Element found at index: " + idx);
    }
}