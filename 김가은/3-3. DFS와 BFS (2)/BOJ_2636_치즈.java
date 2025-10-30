import java.util.Scanner;

public class BOJ_2636_치즈 {
	static int r, c;
	static int[][] cheese;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		cheese = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				cheese[i][j] = sc.nextInt();
			}
		}

		int time = 0; // 치즈가 모두 녹을 때까지 걸린 시간
		int lastCheese = 0; // 마지막으로 녹은 치즈 개수

		// 치즈가 모두 녹을 때까지 반복
		while (true) {
			visited = new boolean[r][c]; // 방문 배열 초기화
			int melt = dfs(0, 0); // 외부 공기(0,0)부터 탐색 시작 → 녹을 치즈 개수 반환

			// 녹을 치즈가 더 이상 없으면 종료
			if (melt == 0)
				break;

			// 모두 탐색하고 실제로 녹이기(예정인 2를 실제로 녹여서 0으로 만들기)
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (cheese[i][j] == 2) {
						cheese[i][j] = 0;
					}
				}
			}

			lastCheese = melt; // 이번 턴에 녹은 치즈 개수 저장
			time++; // 한 턴(1시간) 증가
		}

		System.out.println(time);
		System.out.println(lastCheese);
	}

	static int dfs(int x, int y) {
		visited[x][y] = true;
		int meltCount = 0;

		for (int d = 0; d < 4; d++) {
			int nx = x + dr[d];
			int ny = y + dc[d];

			if (nx < 0 || ny < 0 || nx >= r || ny >= c)
				continue;
			if (visited[nx][ny])
				continue;

			if (cheese[nx][ny] == 1) {
				cheese[nx][ny] = 2;
				meltCount++;
			/*
			 * (nx, ny)는 공기
			 * 이 공기 칸에서 다시 상하좌우로 탐색을 이어갑니다.
			 * 외부 공기 영역 전체를 탐색하는 과정이에요.
			 */
			} else if (cheese[nx][ny] == 0) {
				/*
				 * 하위 DFS 탐색에서 반환된 “녹을 치즈 개수”를 합산.
				 * DFS가 재귀적으로 호출되면서 전체 탐색 내에서 녹을 치즈 수를 누적합니다.
				 * */
				meltCount += dfs(nx, ny); // 공기면 계속 탐색
			}
		}

		return meltCount;
	}
}
