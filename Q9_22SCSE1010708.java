public class Q9_22SCSE1010708 {
    static class Item {
        int value, weight;
        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    static int knapSack(int W, Item arr[], int n) {
        int K[][] = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (arr[i - 1].weight <= w)
                    K[i][w] = Math.max(arr[i - 1].value + K[i - 1][w - arr[i - 1].weight], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }

    public static void main(String args[]) {
        Item arr[] = {new Item(60, 10), new Item(100, 20), new Item(120, 30)};
        int W = 50;
        int n = arr.length;
        System.out.println("Maximum value in knapsack = " + knapSack(W, arr, n));
    }
}
