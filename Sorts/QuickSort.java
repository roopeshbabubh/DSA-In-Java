import java.util.Arrays;

public class QuickSort {

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static int fixedValueSorting(int[] array, int fixedIndex, int endIndex) {
        int swapIndex = fixedIndex;
        for (int i = fixedIndex + 1; i <= endIndex; i++) {
            if (array[fixedIndex] > array[i]) {
                swapIndex++;
                if (swapIndex != i)
                    swap(array, swapIndex, i);
            }
        }
        swap(array, fixedIndex, swapIndex);
        return swapIndex;
    }

    private static void subSort(int[] array, int fixedIndex, int endIndex) {
        if (fixedIndex >= endIndex) return;
        int breakIndex = fixedValueSorting(array, fixedIndex, endIndex);
        subSort(array, 0, breakIndex - 1);
        subSort(array, breakIndex + 1, endIndex);
    }

    public static void sort(int[] array) {
        int fixedIndex = 0;
        int endIndex = array.length - 1;
        subSort(array, fixedIndex, endIndex);
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 7, 1, 2, 3, 6, 9, 10, 11};

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
