import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1149_RGB거리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] cost = new int[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken()); // Red
			cost[i][1] = Integer.parseInt(st.nextToken()); // Green
			cost[i][2] = Integer.parseInt(st.nextToken()); // Blue
		}
		
		int[][] dp = new int[n][3];

		// 초기
		dp[0][0] = cost[0][0]; // Red
		dp[0][1] = cost[0][1]; // Green
		dp[0][2] = cost[0][2]; // Blue
		
		for (int i = 1; i < n; i++) {
			// 현재 집을 Red로 칠하는 경우 → 이전 집은 Green 또는 Blue
            dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            
            // 현재 집을 Green으로 칠하는 경우 → 이전 집은 Red 또는 Blue
            dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            
            // 현재 집을 Blue로 칠하는 경우 → 이전 집은 Red 또는 Green
            dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}

		// 마지막 집 R, G, B 중에서 가장 작은 값이 정답
		int answer = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
		
		System.out.println(answer);
	}
}
