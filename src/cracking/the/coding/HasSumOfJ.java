package cracking.the.coding;

public class HasSumOfJ {

    static int[] arr = {1, 6, 8, 9, 10};
    static int targetSumFalse = 12;
    static int targetSumTrue = 11;

    public static void main(String[] args) {
        System.out.println(hasSumN2(targetSumFalse, arr));
        System.out.println(hasSumN2(targetSumTrue, arr));
    }

    public static boolean hasSumN2(int targetSum, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int n1 = numbers[i];
            for (int j = 0; j < numbers.length; j++) {
                int n2 = numbers[j];
                if (j != i && (n1 + n2 == targetSum)) return true;
            }
        }

        return false;
    }
}
