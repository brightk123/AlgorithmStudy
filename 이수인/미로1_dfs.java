import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class 미로1_dfs {
	static int[][] maze;
	static int[] start;
	static boolean isPossible;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
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
			dfs(start[0], start[1]);

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

	private static void dfs(int row, int col) {
		// 도착지점 찾으면 종료
		if (maze[row][col] == 3) {
			isPossible = true;
			return;
		}

		// 방문 표시
		maze[row][col] = 1;

		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];

			if (nr < 16 && nr >= 0 && nc < 16 && nc >= 0 && maze[nr][nc] != 1) {
				dfs(nr, nc);
			}
		}

	}

}
