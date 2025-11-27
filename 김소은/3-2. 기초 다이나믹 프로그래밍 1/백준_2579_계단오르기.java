import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2579_계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n + 1]; // 각 계단 점수
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        // 계단이 1개인 경우
        if (n == 1) {
            System.out.println(score[1]);
            return;
        }
        
        dp[1] = score[1];
        dp[2] = score[1] + score[2];

        // 점화식
        // dp[i] = i번 계단을 밟는 경우의 최대 점수
        // 1) i-2 → i (i-1 안 밟음)
        // 2) i-3 → i-1 → i (i-1 밟음, i-2는 밟으면 안 됨 → 연속 3칸 방지
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2] + score[i], dp[i-3] + score[i-1] + score[i]);
        }

        // 마지막 계단은 반드시 밟아야 하므로 해당 값 출력
        System.out.println(dp[n]);
    }
}
