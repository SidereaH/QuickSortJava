package QuickSort;

import java.util.HashMap;


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

        QuickSort sortMapStuds = new QuickSort("task 4").hashMapInt(map);
        System.out.println(sortMapStuds);
        //task 5
        QuickSort sortComplexArray = new QuickSort("task 5").complexArray(5);
        System.out.println(sortComplexArray);

        //task 6
        //Сортировка процессоров по базовой тактовой частоте от большего к меньшему
        HashMap<String, Double> procMap = new HashMap<>();

        procMap.put("Intel Core i9-12900K(F)", 3.2);
        procMap.put("Intel Core i5-12400(F)", 2.5);
        procMap.put("AMD Ryzen 9 5950X", 3.2);
        procMap.put("AMD Ryzen Threadripper 3990X", 2.9);
        procMap.put("Intel Core i5-12600(F)", 3.3);
        QuickSort sortProc = new QuickSort("task 6").hashMapDouble(procMap);
        System.out.println(sortProc);

    }
}
