import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Q3_22SCSE1010708 {
    static int[] quicksort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int pivot = arr[arr.length / 2];
        int[] left = new int[0];
        int[] middle = new int[0];
        int[] right = new int[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < pivot) {
                left = concat(left, new int[]{arr[i]});
            } else if (arr[i] == pivot) {
                middle = concat(middle, new int[]{arr[i]});
            } else {
                right = concat(right, new int[]{arr[i]});
            }
        }
        return concat(quicksort(left), middle, quicksort(right));
    }

    static int[] mergesort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergesort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergesort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int l = 0, r = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                result[l + r] = left[l];
                l++;
            } else {
                result[l + r] = right[r];
                r++;
            }
        }
        System.arraycopy(left, l, result, l + r, left.length - l);
        System.arraycopy(right, r, result, l + r, right.length - r);
        return result;
    }

    static int[] concat(int[]... arrays) {
        int length = 0;
        for (int[] array : arrays) {
            length += array.length;
        }
        int[] result = new int[length];
        int pos = 0;
        for (int[] array : arrays) {
            System.arraycopy(array, 0, result, pos, array.length);
            pos += array.length;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] randomList = new int[10000];
        Random random = new Random();
        for (int i = 0; i < randomList.length; i++) {
            randomList[i] = random.nextInt(1000);
        }

        long quicksortTime = System.currentTimeMillis();
        int[] sortedListQuicksort = quicksort(randomList.clone());
        quicksortTime = System.currentTimeMillis() - quicksortTime;

        long mergesortTime = System.currentTimeMillis();
        int[] sortedListMergesort = mergesort(randomList.clone());
        mergesortTime = System.currentTimeMillis() - mergesortTime;

        System.out.println("Quicksort time: " + quicksortTime + " milliseconds");
        System.out.println("Mergesort time: " + mergesortTime + " milliseconds");
    }
}

