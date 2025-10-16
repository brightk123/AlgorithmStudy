import java.util.Scanner;

public class Main {
    static int n, count;
    static int[] colPos;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        colPos = new int[n];
        count = 0;
        dfs(0);
        System.out.println(count);
        sc.close();
    }

    static void dfs(int row) {
        if (row == n) { count++; return; }
        for (int c = 0; c < n; c++) {
            colPos[row] = c;
            if (ok(row)) dfs(row + 1);
        }
    }

    static boolean ok(int row) {
        for (int r = 0; r < row; r++) {
            if (colPos[r] == colPos[row]) return false; // 같은 열
            if (Math.abs(row - r) == Math.abs(colPos[row] - colPos[r])) return false; // 대각선
        }
        return true;
    }
}