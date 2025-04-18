import java.util.Arrays;

public class Q18_22SCSE1010708 {
    static class Activity {
        int start;
        int finish;

        Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    static void activitySelection(Activity[] arr, int n) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a.finish, b.finish));

        System.out.println("Following is maximum number of activities that can be done : ");
        int i = 0;
        System.out.print(arr[i].start + " ");
        for (int j = 1; j < n; j++) {
            if (arr[j].start >= arr[i].finish) {
                System.out.print(arr[j].start + " ");
                i = j;
            }
        }
    }

    public static void main(String[] args) {
        Activity[] arr = new Activity[5];
        arr[0] = new Activity(1, 2);
        arr[1] = new Activity(3, 4);
        arr[2] = new Activity(0, 6);
        arr[3] = new Activity(5, 7);
        arr[4] = new Activity(8, 9);

        int n = arr.length;
        activitySelection(arr, n);
    }
}
