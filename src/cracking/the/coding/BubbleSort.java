package cracking.the.coding;

public class BubbleSort {

    static int[] arr = {1, 7, 8, 3, 5};

    public static void main(String[] args) {

        // i 0 -> end
        // j i -> end
            // ar[i] > ar[j] swap put small values first
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        for (int n : arr)
            System.out.println(n + " ");
    }
}
