import java.util.Arrays;

public class BubbleSort {

    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 4, 1, 8, 9, 7, 6};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
