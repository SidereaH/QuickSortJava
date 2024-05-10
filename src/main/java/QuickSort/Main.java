package QuickSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {5,4,8,2,10};
        QuickSortArray sorted_array = new QuickSortArray("task1").arrayBuild(array);
        System.out.println(sorted_array);
        QuickSortArray randomArraySort = new QuickSortArray("task2").withRand(10);
        System.out.println(randomArraySort);
    }
}
