package Searching;

public class Leaner_search {
    
    public static void leanerSeaarch(int[] arr, int k) {
        for (int i : arr) {
            if (i == k) {
                System.out.println("Item " + k + " found on " + i + " index.");
                return;
            }
            
        }
        System.out.println("Item " + k + " not found! ");
    }
    public static void main(String[] args) {
        int[] arr = {1,6,3,7,5,8,9,0};
        leanerSeaarch(arr, 5);
        leanerSeaarch(arr, 2);
    }
}
