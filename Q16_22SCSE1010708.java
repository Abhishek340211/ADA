public class Q16_22SCSE1010708 {
    static boolean isSubsetSum(int set[], int n, int sum) {
        if (sum == 0)
            return true;
        if (n == 0 && sum!= 0)
            return false;

        if (set[n - 1] > sum)
            return isSubsetSum(set, n - 1, sum);

        return isSubsetSum(set, n - 1, sum) ||
                isSubsetSum(set, n - 1, sum - set[n - 1]);
    }

    public static void main(String args[]) {
        int set[] = {3, 9, 8, 4, 5, 7};
        int sum = 15;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset with sum " + sum);
        else
            System.out.println("No subset with sum " + sum);
    }
}
