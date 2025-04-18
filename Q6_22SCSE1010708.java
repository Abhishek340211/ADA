import java.util.*;
public class Q6_22SCSE1010708 {
    void countSort(int arr[], int n) {
        int x = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > x)
                x = arr[i];
        }
        int[] count_arr = new int[x + 1];

        for (int i = 0; i <= x; i++) {
            count_arr[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            count_arr[arr[i]]++;
        }

        for (int i = 1; i <= x; i++) {
            count_arr[i] += count_arr[i - 1];
        }

        int arr1[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            arr1[count_arr[arr[i]] - 1] = arr[i];
            count_arr[arr[i]]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr1[i];
        }
    }

    void display(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {4, 2, 2, 8, 3, 3, 1};
        int n = arr.length;
        Q6_22SCSE1010708 cs = new Q6_22SCSE1010708();
        cs.countSort(arr, n);
        cs.display(arr,n);
    }
}
