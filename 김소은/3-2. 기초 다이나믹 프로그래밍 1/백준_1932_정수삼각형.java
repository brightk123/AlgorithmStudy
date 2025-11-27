import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1932_정수삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] tri = new int[n][n];
		int[][] dp = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// i번째 줄은 0~i만큼 입력받음
			for (int j = 0; j <= i; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// dp 초기값 (삼각형 가장 위)
		dp[0][0] = tri[0][0];
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				// 가장 왼쪽
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + tri[i][j];
				} 
				// 가장 오른쪽
				else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + tri[i][j];
				}
				// 중간
				else {
					dp[i][j] = dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + tri[i][j];
				}
			}
		}
		
		int answer = 0;
		// 마지막 줄 중에서 가장 최댓값 선택
		for (int j = 0; j < n; j++) {
			answer = Math.max(answer, dp[n - 1][j]);
		}
		
		System.out.println(answer);
	}
}
