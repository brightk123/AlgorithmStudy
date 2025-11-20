import java.util.Scanner;

public class BOJ_2579_계단오르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// dp[i] : i번째 계단까지 왔을 때 얻을 수 있는 최대 점수
		int[] dp = new int[n + 1];
		// arr[i] : i번째 계단 점수
		int[] arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		if (n >= 1) {
			dp[1] = arr[1];
		}
		if (n >= 2) {
			dp[2] = arr[1] + arr[2];
		}
		if (n >= 3) {
			dp[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
		}
		// 점화식: 연속 3칸 금지
		// 1) dp[i-2] + arr[i]            : 한 칸 쉬고 오기
		// 2) dp[i-3] + arr[i-1] + arr[i] : 두 칸 연속 밟기 (i-1, i)
		if(n>=4) {
			for (int i = 4; i <= n; i++) {
				dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
			}
		}

		int result = dp[n];
		System.out.println(result);

	}
}