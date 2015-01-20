package cracking.the.coding;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {7, 4, 3, 2, 7, 0, 1, 9, 1};

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int prev = arr[i - 1];

            if (prev > current) swap(i, arr);
        }

        for (int n : arr) {
            System.out.println(n);
        }
    }

    public static void swap(int until, int[] arr) {
        for (int j = until; j > 0; j--) {
            if (arr[j] < arr[j - 1]) { // swap
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
            } else return;
        }
    }
}
