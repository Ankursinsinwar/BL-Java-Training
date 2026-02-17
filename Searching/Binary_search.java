package Searching;

class Binary_search {

    static int binarySearch(int arr[], int l, int r, int n) {
        if (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m] == n)
                return m;

            if (arr[m] > n)
                return binarySearch(arr, l, m - 1, n);

            return binarySearch(arr, m + 1, r, n);
        }

        return -1;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 3, 5, 6, 8, 9 }; 
        int n = 8;

        int idx = binarySearch(arr, 0, arr.length - 1, n);
        
        System.out.println((idx == -1) ? "Element not found" : "Element found at index: " + idx);
    }
}
