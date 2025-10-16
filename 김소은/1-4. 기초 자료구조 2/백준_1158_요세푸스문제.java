import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 백준_1158_요세푸스문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// N, K 입력받음
		int N = sc.nextInt();
		int K = sc.nextInt();

		// 원형으로 앉아있는 사람들을 저장할 리스트 people
		List<Integer> people = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			people.add(i);
		}

		// 제거된 사람의 순서를 저장할 리스트
		List<Integer> result = new ArrayList<>();

		// 현재 제거를 시작할 위치 인덱스
		// 사람이 제거된 후 다음 시작 위치를 가리킴
		int currentIndex = 0;

		// 리스트의 사람이 남아있는 동안 아래과정 반복
		while (!people.isEmpty()) {
			// K번째 사람을 찾기 위해서 K-1 만큼 이동함
			// % 연산은 리스트의 끝에 도달했을 때 다시 처음으로 돌아가도록 하는 원형 구조 시뮬레이션
			currentIndex = (currentIndex + K - 1) % people.size();

			// currentIndex 위치의 사람을 리스트에서 제거하고 그 값을 removedPerson에 저장
			int removedPerson = people.remove(currentIndex);
			// 제거된 사람을 결과 리스트에 추가
			result.add(removedPerson);
		}

		// 결과출력
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i));
			if (i < result.size() - 1) {
				sb.append(", ");
			}
		}
		
		sb.append(">");
		
		System.out.println(sb.toString());
	}
}
