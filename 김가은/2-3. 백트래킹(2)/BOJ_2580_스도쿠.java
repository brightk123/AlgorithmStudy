import java.util.*;

public class Main {
    static int[][] board = new int[9][9];
    static List<int[]> blanks = new ArrayList<>();
    static boolean solved = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 0) blanks.add(new int[]{i, j});
            }
        }
        dfs(0);
    }

    static void dfs(int depth) {
        if (solved) return; // 이미 답 찾음
        if (depth == blanks.size()) {
            printBoard();
            solved = true;
            return;
        }

        int[] pos = blanks.get(depth);
        int r = pos[0], c = pos[1];

        for (int num = 1; num <= 9; num++) {
            if (isValid(r, c, num)) {
                board[r][c] = num;
                dfs(depth + 1);
                board[r][c] = 0;
            }
        }
    }

    static boolean isValid(int r, int c, int num) {
        // 행, 열 검사
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == num || board[i][c] == num) return false;
        }

        // 3x3 박스 검사
        int sr = (r / 3) * 3;
        int sc = (c / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }

    static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
