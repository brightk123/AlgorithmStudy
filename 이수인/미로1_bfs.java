import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로1_bfs {
	static int[][] maze;
	static int[] start;
	static boolean isPossible;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			int tc = Integer.parseInt(br.readLine());
			maze = new int[16][16];

			// 미로 정보 받기
			for (int i = 0; i < 16; i++) {
				String s = br.readLine();
				for (int j = 0; j < 16; j++) {
					int tmp = Character.getNumericValue(s.charAt(j));
					maze[i][j] = tmp;

					// 시작 지점 정보 저장
					if (tmp == 2) {
						start = new int[2];
						start[0] = i;
						start[1] = j;
					}
				}
			}

			isPossible = false;
			bfs(start[0], start[1]);

			// 출력
			if (isPossible) {
				System.out.println("#" + tc + " 1");
			} else {
				System.out.println("#" + tc + " 0");
			}
		}
	}

	// 델타 배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void bfs(int sR, int sC) {
		Queue<int[]> q = new LinkedList<>();

		// 시작 좌표 큐에 넣기
		q.offer(new int[] { sR, sC });

		// 큐가 빌때까지
		while (!q.isEmpty()) {
			// 큐에서 하나 꺼내기
			int[] curr = q.poll();
			int row = curr[0];
			int col = curr[1];

			// 방문처리
			maze[row][col] = 1;

			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				if (nr < 16 && nr >= 0 && nc < 16 && nc >= 0 && maze[nr][nc] != 1) {
					// 도착 지점 도달 가능하면 종료
					if (maze[nr][nc] == 3) {
						isPossible = true;
						return;
					}

					// 큐에 가능한 다음 경로 저장
					q.offer(new int[] { nr, nc });
				}
			}
		}
	}
}
