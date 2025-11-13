import java.util.Scanner;

public class 백준_9095_1,2,3더하기 {

    static int[] dp = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        answer();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            System.out.println(dp[N]);
        }
    }

    public static void answer() {
        dp[1] = 1; // 1을 만드는 방법 : 1가지
        dp[2] = 2; // 2를 만드는 방법 : 2가지
        dp[3] = 4; // 3을 만드는 방법 : 4가지

        for (int i = 4; i < 11; i++) {
            // 마지막에 1을 더하는 경우 : 그 앞까지 i-1을 만드는 방법의 수인 dp[i-1]과 같음
            // 마지막에 2을 더하는 경우 : 그 앞까지 i-2을 만드는 방법의 수인 dp[i-2]과 같음
            // 마지막에 3을 더하는 경우 : 그 앞까지 i-3을 만드는 방법의 수인 dp[i-3]과 같음
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
    }
}
