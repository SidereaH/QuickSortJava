package QuickSort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;



public class Main {
    public static void main(String[] args) {
        //task1
        int[] array = new int[] {5,4,8,2,10};
        QuickSort sorted_array = new QuickSort("task 1").arrayBuild(array);
        System.out.println(sorted_array);
        //task2
        QuickSort randomArraySort = new QuickSort("task 2").withRand(10);
        System.out.println(randomArraySort);
        //task3
        String[] arrayStr = new String[] {"Андрей", "Никита", "Артем", "Ярослав", "Михаил"};
        QuickSort sortStringArray = new QuickSort("task 3").withStringArray(arrayStr);
        System.out.println(sortStringArray);
        //task4
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Андрей Хуторной", 80);
        map.put("Никита Елисеев", 69);
        map.put("Бронников Артем", 78);
        map.put("Максутов Артем", 50);

        QuickSort sortMapStuds = new QuickSort("task 4").hashMapStud(map);
        System.out.println(sortMapStuds);
        //task 5
        QuickSort sortComplexArray = new QuickSort("task 5").complexArray(5);
        System.out.println(sortComplexArray);
    }
}
