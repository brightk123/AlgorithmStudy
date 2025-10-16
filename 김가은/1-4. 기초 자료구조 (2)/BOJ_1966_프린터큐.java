import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준 1966 - 프린터 큐 (우선순위큐 풀이) 아이디어: 현재 큐의 "최대 중요도"만 빠르게 알면, - 큐 맨 앞 문서의 중요도가 최대
 * == 바로 출력 - 아니면 뒤로 보냄 이를 위해 max-heap(PriorityQueue reverseOrder)로 현재 최대 중요도를
 * 추적한다.
 */
public class 프린터큐 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt(); // 테스트 케이스 수

		while (tc-- > 0) {
			int N = sc.nextInt(); // 문서 개수
			int M = sc.nextInt(); // 타깃 문서의 "원래 인덱스"

			Queue<int[]> q = new LinkedList<>(); // {원래 인덱스, 중요도}
			PriorityQueue<Integer> pq = new PriorityQueue<>( // 현재 큐 안의 최대 중요도를 O(1)에 조회
					Collections.reverseOrder());

			// 입력: 큐와 최대힙 초기화
			for (int i = 0; i < N; i++) {
				int priority = sc.nextInt();
				q.add(new int[] { i, priority });
				pq.add(priority);
			}

			int printed = 0; // 출력(인쇄)된 문서 수

			// 큐가 빌 때까지 반복 (타깃 문서 출력 시 바로 종료)
			while (true) {
				int[] cur = q.poll(); // 현재 맨 앞 문서
				int idx = cur[0]; // 원래 인덱스
				int pr = cur[1]; // 중요도

				// 현재 큐의 "최대 중요도"와 같다면 → 지금 출력 대상
				if (pr == pq.peek()) {
					pq.poll(); // 최대힙에서도 제거
					printed++; // 출력 카운트 증가

					// 타깃 문서면 결과 출력 후 종료
					if (idx == M) {
						System.out.println(printed);
						break;
					}
				} else {
					// 더 높은 중요도가 뒤에 있으므로 현재 문서를 뒤로 보냄
					q.add(cur);
				}
			}
		}
		sc.close();
	}
}
