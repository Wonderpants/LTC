package pt.ispgaya.trabalho1;


//import pt.ispgaya.trabalho1.File.Ficheiro;

import pt.ispgaya.trabalho1.Algorithms.*;
import pt.ispgaya.trabalho1.File.Ficheiro;

import java.io.IOException;
import java.util.Random;


public class Main {

    private static int[] generateRandomArray(int n) {
        int[] list = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            list[i] = random.nextInt(n);
        }
        return list;
    }

    private static void sort(String method, int n) throws IOException {
        Ficheiro file = new Ficheiro();
        file.open(method + ".csv");
        for (int i = 0; i < n; i++) {
            int[] arr = Main.generateRandomArray((int) Math.pow(10, i));
            long startTime = System.nanoTime();
            if (method.toLowerCase().equals("quicksort")) {
                new QuickSort(arr, 0, arr.length - 1);
            } else if (method.toLowerCase().equals("bubblesort")) {
                new BubbleSort(arr);
            }
            long endTime = System.nanoTime();
            file.write(i + 1 + "," + (endTime - startTime) / 1000);
            System.out.println("Took " + (endTime - startTime) + " ns");
        }
        file.close();
    }

    private static void search(String method, int n) {
        for (int i = 0; i < n; i++) {
            int[] arr = Main.generateRandomArray((int) Math.pow(10, i));
            new QuickSort(arr, 0, arr.length - 1);
            long startTime = System.nanoTime();
            if (method.toLowerCase().equals("linearsearch")) {
                new LinearSearch(arr, 10);
            } else if (method.toLowerCase().equals("binarysearch")) {
                new BinarySearch(arr, 10);
            }
            long endTime = System.nanoTime();
            System.out.println(" Took " + (endTime - startTime) + " ns");
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Bubble Sort:");
        sort("BubbleSort", 5);
        System.out.println("\nQuick Sort:");
        sort("QuickSort", 5);
        /*                                */
        System.out.println("Linear Search:");
        search("LinearSearch", 5);
        System.out.println("\nBinary Search:");
        search("BinarySearch", 5);
    }
}
