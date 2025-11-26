import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1931_회의실배정 {

	public static void main(String[] args) {

		// 1) 입력 처리
		// - Scanner로 표준 입력을 읽습니다.
		// - 첫 줄: 회의 개수 N
		Scanner scanner = new Scanner(System.in);

		// N이 없으면 그냥 종료(예외 방지)
		if (!scanner.hasNextInt())
			return;
		int N = scanner.nextInt();

		// 2) 데이터 저장
		// meetings[i][0] = i번째 회의 시작 시간
		// meetings[i][1] = i번째 회의 종료 시간
		int[][] meetings = new int[N][2];

		// N개의 회의 정보를 입력받아 저장합니다.
		// (문제 입력은 보통 정확히 N줄이 들어오지만, 안전하게 hasNextInt 체크를 넣어둔 상태입니다.)
		for (int i = 0; i < N; i++) {
			if (!scanner.hasNextInt())
				break;
			meetings[i][0] = scanner.nextInt(); // 시작 시간

			if (!scanner.hasNextInt())
				break;
			meetings[i][1] = scanner.nextInt(); // 종료 시간
		}

		// 3) 핵심 아이디어(그리디)
		// "가장 빨리 끝나는 회의부터 선택하면, 이후에 더 많은 회의를 넣을 여지가 커진다"는 전략입니다.
		// 따라서 '종료 시간 오름차순' 정렬을 합니다.
		//
		// - 종료 시간이 같다면? 시작 시간이 더 빠른 회의를 먼저 두는 것이 일반적으로 안전합니다.
		// (동일 종료시간일 때 더 일찍 시작한 회의를 먼저 보더라도,
		// 선택 조건(시작 >= lastEndTime)만 만족하면 결과는 동일하게 최대가 됩니다.
		// 관례적으로 tie-break를 둡니다.)
		Arrays.sort(meetings, (o1, o2) -> {
			// 종료 시간이 같으면 시작 시간 기준 오름차순
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			// 종료 시간이 다르면 종료 시간 기준 오름차순
			return o1[1] - o2[1];
		});

		// 4) 그리디로 회의 선택
		// count: 지금까지 선택한 회의 개수(최대값을 만들어갈 변수)
		// lastEndTime: 마지막으로 선택된 회의의 종료 시간
		int count = 0;
		int lastEndTime = 0;

		// 정렬된 순서대로 보면서,
		// "이 회의가 마지막 회의가 끝난 이후(또는 같은 시간)에 시작하면 선택"
		for (int i = 0; i < N; i++) {
			// 겹치지 않는 조건: 현재 시작 시간이 마지막 종료 시간 이상
			if (meetings[i][0] >= lastEndTime) {
				count++; // 회의 하나 확정
				lastEndTime = meetings[i][1]; // 마지막 종료 시간 갱신
			}
		}

		// 5) 출력: 선택 가능한 최대 회의 개수
		System.out.println(count);

	}
}
