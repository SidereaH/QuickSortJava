package QuickSort;

import java.util.Arrays;

public class QuickSortArray {
    public static void main(String[] args) {
        int[] array = {17, 14, 15, 28, 6, 8, -6, 1, 3, 18};
        System.out.println("Unsorted Array: " + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("  Sorted Array: " + Arrays.toString(array));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = pivot(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int pivot(int[] arr, int low, int high) {
        // Выбор среднего элемента в качестве опорного
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // Обмен опорного элемента с последним, чтобы использовать существующую логику
        int temp = arr[middle];
        arr[middle] = arr[high];
        arr[high] = temp;

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}





