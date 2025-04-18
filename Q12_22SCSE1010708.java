public class Q12_22SCSE1010708 {
    private static final int N = 4;

    private static boolean isSafe(int board[][], int row, int col) {
        int i, j;

        for (i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        for (i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    private static boolean solveNQueen(int board[][], int row) {
        if (row == N)
            return true;

        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;

                if (solveNQueen(board, row + 1))
                    return true;

                board[row][col] = 0;
            }
        }

        return false;
    }

    private static void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int board[][] = new int[N][N];

        if (solveNQueen(board, 0) == false) {
            System.out.print("Solution does not exist");
            return;
        }

        printSolution(board);
    }
}
