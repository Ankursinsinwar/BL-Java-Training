package Shorting;

public class Quick_Sort {
    static int partition(int arr[], int l, int h) {
        int pivot = arr[h];
        int i = (l - 1);
        for (int j = l; j < h; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, h);
        return i + 1;
    }

    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sort(int arr[], int l, int h) {
        if (l < h) {
            int pi = partition(arr, l, h);
            sort(arr, l, pi - 1);
            sort(arr, pi + 1, h);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5,7,4,8,6};
        sort(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}

