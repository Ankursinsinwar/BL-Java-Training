package Merge_Sort;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,5,7,4,8,6};
        Sort.sort(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
