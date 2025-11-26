import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2592_부등호 {

	// 1) 입력으로 들어오는 부등호들을 저장 (k개)
	// 예: k=2, signs = ["<", ">"] -> a < b > c 형태
	static String[] signs;

	// 2) 0~9 숫자 중 이미 사용한 숫자인지 체크 (중복 사용 금지)
	static boolean[] visited = new boolean[10];

	// 3) 조건을 만족하는 모든 숫자 문자열을 저장 (나중에 정렬해서 최소/최대 뽑기)
	static List<String> results = new ArrayList<>();

	// 4) 백트래킹(DFS)
	// index: 현재 채울 자리(0부터 시작)
	// currentNum: 지금까지 만든 숫자 문자열
	//
	// 목표: 총 (k+1)자리 숫자를 만들기
	// - 부등호가 k개면 숫자는 k+1개 필요
	public static void findNumbers(int index, String currentNum) {

		// [종료 조건]
		// index가 k+1(=signs.length+1)까지 왔다는 것은 숫자를 전부 채웠다는 뜻
		if (index == signs.length + 1) {
			results.add(currentNum); // 완성된 후보 저장
			return;
		}

		// 다음 자리에 넣을 숫자를 0~9까지 모두 시도
		for (int i = 0; i <= 9; i++) {

			// 이미 사용한 숫자는 스킵 (중복 불가)
			if (visited[i])
				continue;

			// [첫 자리(index=0)]
			// 시작 숫자는 이전 숫자/부등호가 없으므로 조건 검사 없이 바로 사용 가능
			if (index == 0) {
				visited[i] = true;
				findNumbers(index + 1, currentNum + i); // 다음 자리로
				visited[i] = false; // 백트래킹: 복구
			} else {
				// [두 번째 자리부터]
				// 직전에 넣은 숫자(prevDigit)와 지금 넣을 숫자(i)가
				// signs[index-1] 부등호 관계를 만족해야 함

				// currentNum의 마지막(이전 자리 숫자) 추출
				int prevDigit = currentNum.charAt(index - 1) - '0';

				// 이번에 적용할 부등호는 (index-1)번째 부등호
				// 예: index=1이면 첫 번째 부등호 signs[0] 사용
				String sign = signs[index - 1];

				// 부등호가 맞는 경우에만 진행
				if (check(prevDigit, i, sign)) {
					visited[i] = true;
					findNumbers(index + 1, currentNum + i);
					visited[i] = false; // 백트래킹 복구
				}
			}
		}
	}

	// 5) 부등호 관계 검사 함수
	// prev < next 또는 prev > next 인지 판단
	public static boolean check(int prev, int next, String sign) {
		if (sign.equals("<")) {
			return prev < next;
		} else if (sign.equals(">")) {
			return prev > next;
		}
		return false; // 입력은 <, >만 들어오지만 안전장치
	}

	public static void main(String[] args) {

		// 6) 입력 처리
		Scanner sc = new Scanner(System.in);
		// k: 부등호 개수
		// 숫자는 k+1개를 만들어야 함
		int k = sc.nextInt();

		// k개의 부등호 입력
		signs = new String[k];
		for (int i = 0; i < k; i++) {
			signs[i] = sc.next();
		}

		// 7) 백트래킹 시작
		// - index=0(첫 자리)부터
		// - 아직 만든 숫자가 없으니 빈 문자열로 시작
		findNumbers(0, "");

		// 8) 모든 후보(results)를 사전식(문자열) 정렬
		// 자리수가 모두 동일(k+1자리)이고, 0도 포함 가능하므로
		// 문자열 정렬이 곧 숫자 크기 비교와 같은 효과를 냅니다.
		// 예: "021" < "102" (자리수가 같으니 사전식=수치 비교)
		results.sort(null);

		// 9) 정렬 후
		// - 맨 앞: 최소값
		// - 맨 뒤: 최대값
		System.out.println(results.get(results.size() - 1)); // 최대
		System.out.println(results.get(0)); // 최소

	}
}
