import java.util.*;

public class BOJ_1016_제곱ㄴㄴ수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        
        // 제곱수 리스트 구하기 (1부터 √max까지의 제곱수들)
        List<Long> squares = new ArrayList<>();
        for (long i = 2; i * i <= max; i++) {
            squares.add(i * i);
        }
        
        // HashMap으로 세그먼트 배열 초기화
        // Map의 키는 min부터 max까지의 값, 값은 제곱 ㄴㄴ 수 여부 (false = 제곱 ㄴㄴ 수)
        Map<Long, Boolean> isNotSquareFree = new HashMap<>();
        
        // 제곱수들의 배수를 제거
        for (long square : squares) {
            // min에서 시작하여 제곱수의 배수들을 처리
            long start = square * (min + square - 1) / square;
            for (long j = start; j <= max; j += square) {
                isNotSquareFree.put(j, true);  // 해당 값은 제곱수의 배수
            }
        }
        
        // 제곱 ㄴㄴ 수 카운트
        int count = 0;
        for (long i = min; i <= max; i++) {
            if (!isNotSquareFree.getOrDefault(i, false)) {  // default는 false
                count++;
            }
        }
        
        // 결과 출력
        System.out.println(count);
    }
}
