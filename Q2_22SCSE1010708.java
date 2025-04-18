import java.util.Scanner;

public class Q2_22SCSE1010708 {
    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        insertionSort(arr);
        System.out.println("Sorted array in ascending order:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        int targetNumber = 25;
        int result = linearSearch(arr, targetNumber);

        if (result!= -1) {
            System.out.println(targetNumber + " found at index " + result + ".");
        } else {
            System.out.println(targetNumber + " not found in the array.");
        }
    }
}