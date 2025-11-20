import java.util.Scanner;

public class BOJ_6588_골드바흐의추측 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* ===============================================================
         * 1. 에라토스테네스의 체를 이용해 1,000,000까지의 소수를 미리 구한다.
         *    - 문제에서 입력되는 값의 최댓값이 1,000,000이므로 한 번만 계산하면 된다.
         *    - isPrime[x] = true  → x는 소수
         *    - isPrime[x] = false → x는 소수가 아님
         * =============================================================== */
        boolean[] isPrime = new boolean[1000001];
        // 처음에 2 이상 모든 숫자를 소수(true)라고 가정
        for (int i = 2; i <= 1000000; i++) isPrime[i] = true;

        // 소수 제크!
     // 소수 판별: i*i 이하만 검사하면 충분
        for (int i = 2; i * i <= 1000000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        /* ===============================================================
         * 2. 입력된 각 짝수 num에 대해 골드바흐의 추측을 적용한다.
         *    - 골드바흐의 추측: 4 이상의 모든 짝수는 두 소수의 합으로 표현 가능하다.
         *    - num = a + b 형태에서 a ≤ b 라고 할 때,
         *      a는 3부터 시작해서 num/2까지만 확인하면 충분하다.
         * =============================================================== */
        while (true) {
            int num = sc.nextInt();
            // 입력이 0이면 프로그램 종료
            if (num == 0) break;

            boolean found = false; // 두 소수의 조합을 찾았는지 여부

            /* ---------------------------------------------------------------
             * a는 3부터 시작하며 홀수만 검사한다.
             *    - 짝수 소수는 2 하나뿐인데, num이 짝수이므로 (num - 2)는 짝수.
             *    - 대부분의 골드바흐 조합은 홀수 + 홀수 → 짝수 형태다.
             * 그래서 a는 홀수만 증가시키며 탐색한다.
             * --------------------------------------------------------------- */
            for (int a = 3; a <= num / 2; a += 2) {  // 홀수만
                if (isPrime[a] && isPrime[num - a]) {
                    System.out.println(num + " = " + a + " + " + (num - a));
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }
}
