// 그래프의 구조로 침을 이루는 방식을 생각하면,
// 각 학생을 노드로 보고 학생이 다른 학생을 선택하는 것을 간선으로 생각할 수 있음
// 모든 노드에서는 오직 하나의 간선이 나감
// 팀이 되는 경우는 ㅅ그래프에서 사이클을 이루는 것과 같음
// -> dfs를 이용하여 사이클을 탐색하는 전략을 세움

import java.util.Scanner;

public class 백준_9466_텀프로젝트 {
	
	static int N;
	static int[] select; // 선택한 학생 번호
	static boolean[] visited; // 방문여부검사
	static boolean[] finished; // 탐색이 끝났는지 여부
	static int team; // 팀에 속한 학생수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
				
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			// 매칭 편하게 하기 위해서 0번 인덱스 비워둠
			select = new int[N + 1];
			visited = new boolean[N + 1];
			finished = new boolean[N + 1];
			team = 0;
			
			for (int i = 1; i <= N; i++) {
				select[i] = sc.nextInt();
			}
			
			// 모든 학생에 대해 탐색
			for (int i = 1; i <= N; i++) {
				// 탐색이 완료되지 않은 경우 dfs 실행
				if (!finished[i]) {
					dfs(i);
				}
			}
			
			System.out.println(N - team);
		}		
	}
	
	static void dfs(int node) {
		visited[node] = true; // 현재 노드를 방문표시
		
		int next = select[node]; // 다음 노드 찾음
		// 다음 노드를 이미 방문했고, 탐색이 끝나지 않았다면 사이클 존재함을 의미
		if (visited[next]) {
			// next 부터 시작해서 사이클을 따라가면서 팀원의 수 계산
			if (!finished[next]) {
				for (int current = next; current != node; current = select[current]) {
					team++;
				}
				
				team++; // node 자신 포함
			}
		} else {
			dfs(next); // 다음노드가 방문되지 않았으므로 dfs 계속 진행
		}
		
		finished[node] = true; // 현재 노드의 탐색완료 여부 표시
	}
}
