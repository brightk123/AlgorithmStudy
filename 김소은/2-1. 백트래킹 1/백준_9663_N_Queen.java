import java.util.Scanner;

public class 백준_9663_N_Queen {
	
	static int N, ans;
	static int[] col;
	
	static boolean isSafe(int row, int c) {
		for (int i = 0; i < row; i++) {
			if (col[i] == c) return false; // 같은 열에 퀸이 있는지 검사
			
			if (Math.abs(row - i) == Math.abs(c - col[i])) return false; // 대각선에 퀸이 있는지 검사
		}
		
		return true;
	}
	
	static void dfs(int row) {
		// N개의 퀸을 모두 성공적으로 놓았을 경우
		if (row == N) {
			ans++;
			return;
		}

		// 전체 행의 모든 열을 확인
		for (int c = 0; c < N; c++) {
			// (row, c)에 놓는것이 안전한지 확인
			if (isSafe(row, c)) {
				col[row] = c; // 안전하면 c열에 배치
				dfs(row + 1); // 다음행으로 이동하여 다음 퀸을 배치
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N];
		ans = 0;
		dfs(0);
		System.out.println(ans);
	}
}
