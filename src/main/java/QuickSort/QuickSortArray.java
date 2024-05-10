package QuickSort;

import java.util.Arrays;
import java.util.Objects;

public class QuickSortArray {
    String task;
    int[] array;
    int numOfI;

    public QuickSortArray(String task) {
        this.task = task;

    }
    public QuickSortArray arrayBuild(int[] array){
        this.array = array;
        return this;
    }
    public QuickSortArray withRand(int numOfI){
        this.numOfI = numOfI;
        return this;
    }

    @Override
    public String toString(){
        if (Objects.equals(task, "task1")) {

            return String.format("Задание номер: %s; \n Начальный массив: %s; \n Конечный массив: %s", task, Arrays.toString(array), Arrays.toString(quickSort(array, 0, array.length - 1)));
        }
        else if (Objects.equals(task, "task2")){
            int[] randInt = randomArray(numOfI);
            return String.format("Задание номер: %s; \n Начальный массив: %s; \n Конечный массив: %s", task, Arrays.toString(randInt), Arrays.toString(quickSort(randInt, 0, randInt.length - 1)));

        }
        else {
            return String.format("none");
        }

    }
//    public static void main(String[] args) {
//
//        System.out.println("Unsorted Array: " + Arrays.toString(array));
//        quickSort(array, 0, array.length - 1);
//        System.out.println("  Sorted Array: " + Arrays.toString(array));
//    }
    public static int[] randomArray(int numOfI){
        int[] randArr;
        randArr = new int[numOfI];
        for (int i = 0; i < randArr.length; i++) {
            randArr[i] = ((int)(Math.random() * 12) - 15);

        }
        return randArr;
    }

    public static int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = pivot(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
        return arr;
    }

    private static int pivot(int[] arr, int less, int greater) {
        int middle = less + (greater - less) / 2;
        int pivot = arr[middle];

        // Обмен опорного элемента с последним, чтобы использовать существующую логику
        int temp = arr[middle];
        arr[middle] = arr[greater];
        arr[greater] = temp;
        int i = (less - 1);
        for (int j = less; j < greater; j++) {
            if (arr[j] < pivot) {
                i++;

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i + 1];
        arr[i + 1] = arr[greater];
        arr[greater] = temp;
        return i + 1;
    }
}





