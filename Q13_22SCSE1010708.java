public class Q13_22SCSE1010708 {
    private static final int d = 256;
    private static final int q = 101;

    private static int power(int a, int b) {
        int temp = 1;
        for (int i = 1; i <= b; i++)
            temp = (a * temp) % d;
        return temp;
    }

    private static int search(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();

        int h = power(d, m - 1) % q;
        int p = 0;
        int t = 0;

        for (int i = 0; i < m; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        for (int i = 0; i <= n - m; i++) {
            if (p == t) {
                int j;
                for (j = 0; j < m; j++)
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;

                if (j == m)
                    return i;
            }

            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;

                if (t < 0)
                    t = (t + q);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String txt = "ABHISHEK ARYA";
        String pat = "SHEK";

        int result = search(txt, pat);

        if (result == -1)
            System.out.println("Pattern not found");
        else
            System.out.println("Pattern found at index " + result);
    }

}
