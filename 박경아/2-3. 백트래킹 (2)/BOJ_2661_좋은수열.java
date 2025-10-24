import java.util.*;

public class BOJ_2661_좋은수열 {

    static int N; // 수열의 길이
    static int[] nums; // 수열을 담을 배열
    static String minNums; // 정답 (문자열로 저장하여 비교)
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        nums = new int[N];
        nums[0] = 1; // 첫 번째 수는 1로 고정

        minNums = "3".repeat(N); // 가장 큰 수로 초기화 ("333...")        
        
        // 수열 생성 시작
        createNums(1);

        // 결과 출력
        System.out.println(minNums);
    }

    private static void createNums(int k) {
        // 좋은 수열 검사
        if (!isOK(k)) {
            return; // 나쁜 수열이면 탐색 종료
        }

        // 수열 길이가 N에 도달하면 중간 값 확인
        if (k == N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(nums[i]);
            }
            String ansChk = sb.toString();
            if (ansChk.compareTo(minNums) < 0) { // String으로 비교하여 최소값 갱신
                minNums = ansChk;
            }
            return;
        }

        // 수열 확장 (1, 2, 3을 넣어서 재귀 호출)
        for (int i = 1; i <= 3; i++) {
            nums[k] = i; // 수열에 숫자 1, 2, 3을 넣어가며 재귀 호출
            createNums(k + 1); // 재귀적으로 수열 생성

            // 최소값이 갱신되었으면 더 이상 탐색할 필요 없음
            if (!minNums.equals("3".repeat(N))) {
                return;
            }
        }
    }

    // 좋은 수열 검사
    private static boolean isOK(int k) {
        // 수열 길이가 1일 때는 나쁜 수열이 아님
        if (k < 2) {
            return true;
        }

        // 수열 내 연속된 두 부분이 같은지 체크
        for (int i = 1; i <= k / 2; i++) {
            boolean isFalse = true;
            for (int j = 0; j < i; j++) {
                if (nums[k - j - 1] != nums[k - i - j - 1]) {
                    isFalse = false;
                    break;
                }
            }
            if (isFalse) {
                return false; // 나쁜 수열이면 false 반환
            }
        }
        return true; // 좋은 수열이면 true 반환
    }
}
