import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // dp[n] = 1,2,3의 합으로 n을 만드는 경우의 수 (순서 고려)
        int[] dp = new int[12]; // n 최대 11
        dp[0] = 1;              // 공집합 한 가지
        dp[1] = 1;              // 1
        dp[2] = 2;              // 1+1, 2
        dp[3] = 4;              // 1+1+1, 1+2, 2+1, 3
        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            sb.append(dp[n]).append('\n');
        }
        System.out.print(sb.toString());
        sc.close();
    }
}
