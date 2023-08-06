import java.util.Arrays;

public class MergeSort {

    private static int[] merge(int[] array1, int[] array2) {
        int[] combineArray = new int[array1.length + array2.length];

        int j = 0;
        int k = 0;
        for (int i = 0; i < combineArray.length; i++) {

            if (j < array1.length && k < array2.length && array1[j] > array2[k]) {
                combineArray[i] = array2[k];
                k++;
            } else if (j < array1.length && k < array2.length && array1[j] < array2[k]) {
                combineArray[i] = array1[j];
                j++;
            } else if (j >= array1.length && k < array2.length) {
                combineArray[i] = array2[k];
                k++;
            } else if (j < array1.length && k >= array2.length) {
                combineArray[i] = array1[j];
                j++;
            }
        }
        return combineArray;
    }

    public static int[] sort(int[] array) {
        int midIndex = array.length / 2;
        if (array.length == 1) return array;

        int[] array1 = sort(Arrays.copyOfRange(array, 0, midIndex));
        int[] array2 = sort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(array1, array2);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 6, 1, 7, 8, 5, 10, 9};

        System.out.println(Arrays.toString(sort(arr)));
    }
}
