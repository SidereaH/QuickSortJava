package QuickSort;
import java.util.*;

public class QuickSort {
    private final String task;
    private int[] array;
    private String[] stringArray;
    private int numOfI;
    private HashMap<String, Integer> mapInt;
    private int lengthComplexArray;
    private HashMap<String, Double> mapDouble;

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
    public QuickSort hashMapInt(HashMap<String,Integer> map){
        this.mapInt = map;
        return this;
    }
    public QuickSort hashMapDouble(HashMap<String, Double> map){
        this.mapDouble = map;
        return this;
    }

    public QuickSort complexArray(int length){
        this.lengthComplexArray = length;
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
                int[] hashValues = getArrayFromHashMapInt(mapInt);
                int[] sortedValues = quickSort(hashValues, 0, hashValues.length - 1);
                return String.format("Задание номер: %s; \n Начальный массив: %s; \n Конечный массив: %s; \n Итоговый HashMap - %s",
                        task,
                        Arrays.toString(getArrayFromHashMapInt(mapInt)),
                        Arrays.toString(sortedValues),
                        getKeysFromValues(sortedValues , mapInt)
                );
            }
            case "task 5" -> {
                Complex[] complexArray = complexGeneratedNums(lengthComplexArray);
                double[] modules = getComplexModules(complexArray);
                double[] sortedModules = quickSortDouble(modules, 0, modules.length-1);
                HashMap<String, Double> unsortedMap = getHashMapForComplexNums(complexArray, modules);
                LinkedHashMap<String,Double> sortedMap = getKeysFromValuesDouble(sortedModules, unsortedMap);
                return String.format("Задание номер: %s; \n Начальный массив: %s; \n Массив модулей: %s\n Соединение модулей и их значений в хешмеп: %s \n Отсортированные модули: %s, \n Конечный LinkedHashMap: %s, \n Конечный массив комплекных чисел %s.",
                        task,
                        Arrays.toString(complexArray),
                        Arrays.toString(modules),
                        unsortedMap,
                        Arrays.toString(sortedModules),
                        sortedMap,
                        getKeysFromLinkedHashMap(sortedMap)
                );

            }
            case "task 6" -> {
                double[] hashValues = getArrayFromHashMapDouble(mapDouble);
                double[] sortedValues = quickSortDouble(hashValues, 0, hashValues.length - 1);
                return String.format("Задание номер: %s; \n Начальный массив: %s; \n Конечный массив: %s; \n Итоговый HashMap - %s",
                        task,
                        Arrays.toString(hashValues),
                        Arrays.toString(sortedValues),
                        getKeysFromValuesDouble(sortedValues , mapDouble)
                );
            }
            case null, default -> {
                return "pizdas";
            }

        }
    }

    public static int[] getArrayFromHashMapInt(HashMap<String,Integer> hashMap){

        ArrayList<Integer> valuesList = new ArrayList<>(hashMap.values());
        int[] values = new int[valuesList.size()];
        for (int i = 0; i < valuesList.size(); i++) {
            values[i] = valuesList.get(i);
        }
        return values;
    }
    public static double[] getArrayFromHashMapDouble(HashMap<String,Double> hashMap){

        ArrayList<Double> valuesList = new ArrayList<>(hashMap.values());
        double[] values = new double[valuesList.size()];
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
    public static double[] getComplexModules(Complex[] compArr){
        double[] abs = new double[compArr.length];
        for (int i = 0; i< compArr.length; i++){
            abs[i] = compArr[i].module();
        }
        return abs;
    }

    public static HashMap<String, Double> getHashMapForComplexNums(Complex[] arrayComplex, double[] modules){
        HashMap<String,Double> unsortedHashMap = new HashMap<>(); //соеднинение несортированного массива комплексны чисел и их модулей
        for (int i = 0; i < arrayComplex.length; i++){
            String toStrComplex = arrayComplex[i].toString();
            unsortedHashMap.put(toStrComplex, modules[i]);
        }
        return unsortedHashMap;
    }
    public static LinkedHashMap<String, Double> getKeysFromValuesDouble(double[] array, HashMap<String,Double> oldMap){
        LinkedHashMap<String,Double> newMap =new LinkedHashMap<>();
        for (double v : array) {
            for (Map.Entry entry : oldMap.entrySet()) {
                double entryValue = (Double) entry.getValue();
                String keyValue = (String) entry.getKey();
                if (entryValue == v) {
                    newMap.put(keyValue, entryValue);
                }
            }
        }
        return newMap;
    }
    public static Set<String> getKeysFromLinkedHashMap(LinkedHashMap<String, Double> map){
        return map.keySet();
    }


    public static double[] quickSortDouble(double[] arr, int low, int high){
        if (low < high) {
            int pi = pivotDouble(arr, low, high);

            quickSortDouble(arr, low, pi - 1);
            quickSortDouble(arr, pi + 1, high);
        }
        return arr;
    }

    public static int pivotDouble(double[] arr, int less, int greater){
        int middle = less + (greater - less) / 2;
        double pivot = arr[middle];

        // Обмен опорного элемента с последним, чтобы использовать существующую логику
        double temp = arr[middle];
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