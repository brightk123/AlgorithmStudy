import java.util.Scanner;

public class 백준_9663_N_Queen {
	
	static int N, ans;
	static int[] col;
	
	static boolean isSafe(int row, int c) {
		for (int i = 0; i < row; i++) {
			if (col[i] == c) return false;
			
			if (Math.abs(row - i) == Math.abs(c - col[i])) return false;
		}
		
		return true;
	}
	
	static void dfs(int row) {
		if (row == N) {
			ans++;
			return;
		}
		
		for (int c = 0; c < N; c++) {
			if (isSafe(row, c)) {
				col[row] = c;
				dfs(row + 1);
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
