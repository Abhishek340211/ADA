import java.util.Arrays;

public class Q8_22SCSE1010708 {
    static class Item {
        int value, weight;
        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, (a, b) -> Double.compare(b.value / b.weight, a.value / a.weight));
        int curWeight = 0;
        double finalvalue = 0.0;

        for (int i = 0; i < n; i++) {
            if (curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;
                finalvalue += arr[i].value;
            } else {
                int remain = W - curWeight;
                finalvalue += arr[i].value * ((double) remain / arr[i].weight);
                break;
            }
        }

        return finalvalue;
    }

    public static void main(String args[]) {
        Item arr[] = {new Item(60, 10), new Item(100, 20), new Item(120, 30)};
        int W = 50;
        int n = arr.length;
        System.out.println("Maximum value in knapsack = " + fractionalKnapsack(W, arr, n));
    }
}
