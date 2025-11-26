import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2217_로프 {

    public static void main(String[] args) {

        // 1) 입력 받기
        // - N: 로프 개수
        // - ropes: 각 로프가 버틸 수 있는 최대 중량을 저장
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int N = sc.nextInt();

        // Collections.sort를 쓰기 위해 int[] 대신 ArrayList<Integer> 사용
        ArrayList<Integer> ropes = new ArrayList<>();

        // N개의 로프 최대중량을 입력받아 저장
        for (int i = 0; i < N; i++) {
            if (!sc.hasNextInt()) break;
            ropes.add(sc.nextInt());
        }

        // 2) 핵심 아이디어(그리디)
        // 로프를 여러 개 사용하면 "무게를 분산"시킬 수 있지만,
        // 전체가 버틸 수 있는 최대 무게는 '선택한 로프들 중 가장 약한 로프'가 결정합니다.
        //
        // 예) k개의 로프를 쓰면, 각 로프에 동일하게 W/k가 걸림
        // -> 가장 약한 로프가 버틸 수 있어야 하므로
        // -> W/k <= (가장 약한 로프의 최대중량)
        // -> W <= k * (가장 약한 로프의 최대중량)
        //
        // 따라서, 로프를 내림차순으로 정렬해두고
        // i번째 로프를 "가장 약한 로프"로 두고(즉, 0~i까지 k=i+1개 사용),
        // 그때 가능한 최대 무게 k * ropes[i]를 계산해서 최댓값을 찾습니다.

        // 3) 내림차순 정렬
        // - 강한 로프부터 앞에 오도록 정렬
        Collections.sort(ropes, Collections.reverseOrder());

        // 최대 중량은 최대 10,000 * 100,000 = 1,000,000,000(10억)까지 가능
        // int도 가능하긴 하지만, 안전하게 long 사용
        long maxWeight = 0;

        // 4) 정렬된 로프를 기준으로 가능한 경우를 전부 체크
        // i번째 로프까지 총 k=i+1개를 사용한다고 가정할 때
        // - 그 중 가장 약한 로프는 ropes[i]
        // - 들어올릴 수 있는 최대 무게는 ropes[i] * k
        for (int i = 0; i < N; i++) {

            long weakest = ropes.get(i); // 현재 선택한 k개 로프 중 가장 약한 로프(내림차순이므로 i번째)
            long k = i + 1;              // 사용한 로프 개수

            long candidate = weakest * k; // 이 조합으로 가능한 최대 무게

            // 최댓값 갱신
            if (candidate > maxWeight) {
                maxWeight = candidate;
            }
        }

        // 5) 결과 출력: 가능한 최대 중량
        System.out.println(maxWeight);
    }
}
