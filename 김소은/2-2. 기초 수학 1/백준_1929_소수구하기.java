import java.util.Scanner;

public class 백준_1929_소수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        // 소수인지 판별하는 배열 생성 -> true면 소수
        boolean[] isPrime = new boolean[N + 1]; 
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true; // 처음에는 소수라고 가정
        }

        // 에라토스테네스의 체 알고리즘
        // 2부터 루트N 까지 확인하면서 배수를 제거함
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // M 이상 N 이하의 소수 출력
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}
