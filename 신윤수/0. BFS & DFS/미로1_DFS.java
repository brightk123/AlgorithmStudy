// 주어진 미로 입력값에서 도착점까지 도달이 가능한지 불가능한지
// 가능하면 1을 출력, 불가능하면 0을 출력하는 문제

import java.util.Scanner;

public class 미로1_DFS {
	static final int N =16;
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};
	static int sr, sc, er, ec; // 시작좌표, 도착좌표
	static boolean[][] visited = new boolean[N][N];
	static int[][] map = new int[N][N];


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
				
		for (int tc = 1; tc <= 10; tc++) {
			
			int caseNo = scanner.nextInt();
			
			// 매 테스트 케이스마다 상태를 초기화
			visited = new boolean[N][N];
			map = new int[N][N];
			sr = sc = er = ec = -1; // 아직 못찾았다는 의미로 -1로 초기화
			
			for (int r = 0; r < N; r++) {
				
				String line = scanner.next();
				
				for (int c = 0; c < N; c++) {
					char ch = line.charAt(c);
					if (ch == '1') {
						map[r][c] = 1; // 벽
					} else {
						map[r][c] = 0; // 길
						if (ch == '2') {
							sr = r;
							sc = c;
						}
						if (ch == '3') {
							er = r;
							ec = c;
						}
					}
				}				
			}
			
			boolean reachable  = dfs(sr,sc);
			System.out.println("#" + tc + " " + (reachable ? 1 : 0));
		}
	}

	// 깊이 우선 탐색, 재귀함수
	static boolean dfs(int r, int c) {
		// 기저조건
		if (r == er && c == ec) { // 만약 도착좌표와 같다면 (도착을 했다면)
			return true;
		}
		visited[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d]; // 다음 행
			int nc = c + dc[d]; // 다음 열
			
			// 경계체크, 방문 안했는지 체크, 그 칸이 길(0)인지 체크 
			if (nr >= 0 && nr < N && nc >= 0 && nc < N 
					&& !visited[nr][nc] && map[nr][nc] == 0) {
				
				// 조건 다 맞으면 재귀로 더 깊이 탐색
				if (dfs(nr, nc)) return true;
			}
		}
		
		// 4방향 모두 시도했지만 도착하지 못하면 false
		return false;
	}
}
