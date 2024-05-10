package QuickSort;
import java.util.*;

public class QuickSort {
    private final String task;
    private int[] array;
    private String[] stringArray;
    private int numOfI;
    private HashMap<String, Integer> mapStudents;
    private Objects[] complexNums;

    public QuickSort(String task) {
        this.task = task;
    }
    public QuickSort arrayBuild(int[] array){
        this.array = array;
        return this;
    }
    public QuickSort withRand(int numOfI){
        this.numOfI = numOfI;
        return this;
    }
    public QuickSort withStringArray(String[] array){
        this.stringArray = array;
        return this;
    }
    public QuickSort hashMapStud(HashMap<String,Integer> map){
        this.mapStudents = map;
        return this;
    }
    public QuickSort complexArray(Objects[] compArr, int length){
        this.complexNums = compArr;
        return this;
    }

    @Override
    public String toString(){
        switch (task) {
            case "task 1" -> {
                return String.format("Задание номер: %s; \n Начальный массив: %s; \n Конечный массив: %s",
                        task,
                        Arrays.toString(array),
                        Arrays.toString(quickSort(array, 0, array.length - 1)));
            }
            case "task 2" -> {
                int[] randInt = randomArray(numOfI);
                return String.format("Задание номер: %s; \n Начальный массив: %s; \n Конечный массив: %s",
                        task,
                        Arrays.toString(randInt),
                        Arrays.toString(quickSort(randInt, 0, randInt.length - 1)));
            }
            case "task 3" -> {

                return String.format("Задание номер: %s; \n Начальный массив: %s; \n Конечный массив: %s",
                        task,
                        Arrays.toString(stringArray),
                        Arrays.toString(quickSortString(stringArray, 0, stringArray.length - 1)));
            }
            case "task 4" -> {
                int[] hashValues = getArrayFromHashMap(mapStudents);
                int[] sortedValues = quickSort(hashValues, 0, hashValues.length - 1);
                return String.format("Задание номер: %s; \n Начальный массив: %s; \n Конечный массив: %s; \n Итоговый HashMap - %s",
                        task,
                        Arrays.toString(getArrayFromHashMap(mapStudents)),
                        Arrays.toString(sortedValues),
                        getKeysFromValues(sortedValues , mapStudents)
                );
            }
            case "task 5" -> {
                Complex[] complexArray = complexGeneratedNums(5);
                return String.format("Задание номер: %s; \n Начальный массив: %s; \n Конечный массив: %s",
                        task,
                        Arrays.toString(complexNums),
                        Arrays.toString(complexNums)
                );

            }
            case null, default -> {
                return "pizdas";
            }

        }
    }

    public static int[] getArrayFromHashMap(HashMap<String,Integer> hashMap){

        ArrayList<Integer> valuesList = new ArrayList<>(hashMap.values());
        int[] values = new int[valuesList.size()];
        for (int i = 0; i < valuesList.size(); i++) {
            values[i] = valuesList.get(i);
        }
        return values;
    }

    public static LinkedHashMap<String, Integer> getKeysFromValues(int[] array, HashMap<String,Integer> oldMap){
        LinkedHashMap<String,Integer> newMap =new LinkedHashMap<>();
        for (int j : array) {
            for (Map.Entry entry : oldMap.entrySet()) {
                int entryValue = (Integer) entry.getValue();
                String keyValue = (String) entry.getKey();
                if (entryValue == j) {
                    newMap.put(keyValue, entryValue);
                }
            }
        }
        return newMap;
    }

    public static int[] randomArray(int numOfI){
        int[] randArr;
        randArr = new int[numOfI];
        for (int i = 0; i < randArr.length; i++) {
            randArr[i] = ((int)(Math.random() * 30));

        }
        return randArr;
    }

    public static Complex[] complexGeneratedNums(int length){

        Complex[] complexNums = new Complex[length];
        for (int i =0; i< complexNums.length; i++){
            Complex num = new Complex(((int)(Math.random() * 100)-100), ((int)((Math.random() * 100)-100)));
            complexNums[i] = num;
        }
        return complexNums;
    }


    public static int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = pivot(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
        return arr;
    }
    public static String[] quickSortString(String[] arr, int low, int high){
        if (low < high) {
            int pi = pivotString(arr, low, high);

            quickSortString(arr, low, pi - 1);
            quickSortString(arr, pi + 1, high);
        }
        return arr;
    }
    private static int pivotString(String[] arr, int less, int greater){
        int middle = less + (greater - less) / 2;
        String pivot = arr[middle];

        // Обмен опорного элемента с последним, чтобы использовать существующую логику
        String temp = arr[middle];
        arr[middle] = arr[greater];
        arr[greater] = temp;
        int i = (less - 1);
        for (int j = less; j < greater; j++) {
            if (arr[j].compareToIgnoreCase(pivot) < 0) {
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





