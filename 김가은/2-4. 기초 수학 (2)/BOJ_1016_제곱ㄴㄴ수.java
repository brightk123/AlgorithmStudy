import java.util.Scanner;

public class BOJ_1016_제곱ㄴㄴ수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력되는 범위 (최대 10^12 → long 필수)
        long min = sc.nextLong();
        long max = sc.nextLong();

        /*
         * 범위 길이만큼만 배열을 만든다.
         * 예: min=10, max=20 → 총 11개 체크.
         * 전체 10^12 크기의 배열을 만들 수 없기 때문에
         * '세그먼트 방식'으로 필요한 범위만 관리한다.
         */
        int size = (int) (max - min + 1);

        /*
         * check[i] = true  → 제거된 숫자 (제곱으로 나눠떨어지는 수)
         * check[i] = false → 아직 남아 있는 숫자 (제곱 ㄴㄴ 수 후보)
         */
        boolean[] check = new boolean[size];

        /*
         * 제곱수 i^2을 기준으로 min~max 범위를 걸러낸다.
         * i^2 <= max 까지만 보면 된다.
         * 예: max=100 → i=10까지만 확인 (10^2 = 100)
         */
        for (long i = 2; i * i <= max; i++) {

            long pow = i * i; // 제거 기준이 되는 제곱수 (4, 9, 16, 25 ...)

            /*
             * min 이상에서 pow(제곱수)로 나누어떨어지는 "첫 번째 숫자"를 찾는 과정.
             *
             * (min + pow - 1) / pow → min을 pow로 나눈 몫을 올림한 값.
             * 여기에 pow를 곱하면: min 이상에서 pow로 나누어떨어지는 첫 수.
             *
             * 예: min=10, pow=4 → 10 이상 중 4의 배수 → 12가 됨.
             */
            long start = ((min + pow - 1) / pow) * pow;

            /*
             * start, start + pow, start + 2*pow ... 와 같이
             * pow의 배수들은 모두 제곱으로 나누어떨어지는 수이므로 제거한다.
             *
             * (x - min)을 index로 사용하면
             * check[0] = min, check[size-1] = max 에 대응됨.
             */
            for (long x = start; x <= max; x += pow) {
                check[(int) (x - min)] = true; // 해당 숫자 제거 표시
            }
        }

        /*
         * check 배열에서 제거되지 않은(false) 값의 개수가
         * "제곱 ㄴㄴ 수"의 개수이다.
         */
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (!check[i]) {
                count++;
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
