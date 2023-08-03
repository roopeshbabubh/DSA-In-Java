import java.util.Arrays;

public class InsertionSort {

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int j = i;
            while (j > -1 && arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 4, 1, 8, 9, 7, 6};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
