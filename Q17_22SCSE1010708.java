import java.util.Arrays;

public class Q17_22SCSE1010708 {
        static class Task implements Comparable<Task> {
            int deadline;
            int profit;

            Task(int deadline, int profit) {
                this.deadline = deadline;
                this.profit = profit;
            }

            // Sort tasks based on profit in descending order
            @Override
            public int compareTo(Task other) {
                return other.profit - this.profit;
            }
        }

        public static int maximumProfit(Task[] tasks) {
            // Sort tasks based on profit
            Arrays.sort(tasks);

            int n = tasks.length;
            int maxDeadline = 0;
            for (Task task : tasks) {
                maxDeadline = Math.max(maxDeadline, task.deadline);
            }

            int[] slots = new int[maxDeadline + 1];
            Arrays.fill(slots, -1);

            int totalProfit = 0;
            for (Task task : tasks) {
                for (int i = task.deadline; i > 0; i--) {
                    if (slots[i] == -1) {
                        slots[i] = task.profit;
                        totalProfit += task.profit;
                        break;
                    }
                }
            }

            return totalProfit;
        }

        public static void main(String[] args) {
            Task[] tasks = {
                    new Task(4, 70),
                    new Task(2, 50),
                    new Task(3, 40),
                    new Task(1, 30),
                    new Task(4, 60),
                    new Task(1, 20)
            };

            int maxProfit = maximumProfit(tasks);
            System.out.println("Maximum total profit: " + maxProfit);
        }
    }