package Merge_Sort;

public class Sort {
    static void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            Merge.merge(arr, l, m, r);
        }
    }
}
