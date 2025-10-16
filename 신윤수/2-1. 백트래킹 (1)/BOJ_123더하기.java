// 정수 n을 1, 2, 3의 합으로 나타낼 수 있는 방법의 갯수는 몇개인지 구하는 문제

import java.util.Scanner;

public class BOJ_123더하기 {
	static int count;
	static final int[] CHOICES = {1, 2, 3};
	
	static void dfs(int sum, int n) {
		if (sum == n) {
			count++;
			return;
		}

		if (sum > n) return; // 이미 목표 넘겼으니 종료
		
		for (int i = 0; i < CHOICES.length; i++) {
		    int add = CHOICES[i];
		    dfs(sum + add, n);
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int n = sc.nextInt();
			count = 0;

			// DFS 시작점: 아직 아무것도 더하기 않았으므로 sum=0에서 출발
			dfs(0, n);
			
			System.out.println(count);
		}	
	}
}
