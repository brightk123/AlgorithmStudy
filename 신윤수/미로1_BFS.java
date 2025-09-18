// 주어진 미로 입력값에서 도착점까지 도달이 가능한지 불가능한지
// 가능하면 1을 출력, 불가능하면 0을 출력하는 문제

import java.util.ArrayDeque;
import java.util.Scanner;

public class 미로1_BFS {
	static final int N =16;
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};
	static int sr, sc, er, ec; // 시작좌표, 도착좌표
	static int[][] map = new int[N][N];


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
				
		for (int tc = 1; tc <= 10; tc++) {
			
			int caseNo = scanner.nextInt();
			
			sr = sc = er = ec = -1;
			
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
			
			boolean reacheable = bfs(sr, sc);
			System.out.println("#" + tc + " " + (reacheable ? 1 : 0));
		}
	}

	static boolean bfs(int r, int c) {
		boolean[][] visited = new boolean[N][N];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		// 시작점을 방문 처리하고 큐에 넣기
		visited[r][c] = true;
		q.offer(new int[] {r,c});
		
		// 큐가 빌 때까지 너비 우선으로 확장
		while (!q.isEmpty()) {
			int[] current = q.poll(); // 현재 탐색 중인 좌표 꺼내기
			int currentR = current[0], currentC = current[1];
			
			// 도착 좌표에 도달하면 성공
			if (currentR == er && currentC == ec) {
				return true;
			}
			
			// 4방향으로 이웃 칸 탐색
			for (int d = 0; d < 4; d++) {
				int nr = currentR + dr[d];
				int nc = currentC + dc[d];
				
				// 범위 안이고, 아직 방문안했고, 길(0)인 경우에만 진행시켜~
				if (nr >= 0 && nr < N && nc >= 0 && nc < N
						&& !visited[nr][nc] && map[nr][nc] == 0) {
					
					visited[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
		}
		return false; // 큐가 빌 때까지 도달하지 못했음
	}
}
