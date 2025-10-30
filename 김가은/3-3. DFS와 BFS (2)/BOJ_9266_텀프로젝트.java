import java.util.Scanner;

public class BOJ_9266_텀프로젝트 {
	static int[] student;
	static boolean[] done;
	static boolean[] visited;
	static int count; // 팀에 속한 학생 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();

			student = new int[n + 1];
			done = new boolean[n + 1];
			visited = new boolean[n + 1];
			count = 0;

			for (int i = 1; i <= n; i++) {
				student[i] = sc.nextInt();
			}
			
			
			
			
			for (int i = 1; i <= n; i++) {
				if (!done[i]) { // 아직 탐색이 끝나지 않은 학생만 탐색
					dfs(i);
				}
			}
			// 전체 학생 수에서 팀을 이룬 학생 수를 뺀 값 출력
			System.out.println(n - count);
		}
	}

	static void dfs(int now) {
		/*
		 * now 학생이 선택한 사람(next)으로 이동할 준비
		 * 방문 여부를 기록 (visited는 “현재 경로 상에서 방문 중임”을 의미)
		 */
		visited[now] = true; // 현재 노드 방문 처리
		int next = student[now];  // 다음 학생
		
		/*
		 * 아직 next 학생을 방문한 적이 없다면, 계속 깊이 탐색
		 * 즉, "아직 탐색 안 했으니 다음 학생으로 이동"
		 */
		if (!visited[next]) {
			// 아직 방문하지 않은 학생이면 DFS 계속 진행
			dfs(next);
			
			
		/*
		 * next는 이미 visited[next] == true → 이미 현재 경로에서 방문한 적이 있다
		 * 그런데 done[next] == false → 아직 완전히 처리되지 않은 학생
		 * 
		 * 두 가지가 동시에 참이면, 사이클 발견! = “자기 자신으로 돌아오는 루프”가 존재한다
		 * */	
		} else if (!done[next]) {
			// next가 이미 방문되었지만 아직 done이 안 된 경우 → 사이클 발견
			count++;// 사이클 시작점 포함
			
			/*
			 * next부터 시작해서 now로 돌아올 때까지 student[i]를 따라 이동하며 인원 수를 셈.
			 * 사이클에 포함된 모든 학생을 count에 더함.
			 */
			for (int i = next; i != now; i = student[i]) {
				count++; // 사이클 내 모든 노드 카운트
			}
		}
		/*
		 * now 학생의 DFS 탐색이 끝났음을 표시
		 * 즉, 이 학생은 다시 탐색할 필요가 없음 (이미 어떤 사이클에 속하거나, 사이클이 아님이 판별됨)
		 */
		done[now] = true;
	}
}
