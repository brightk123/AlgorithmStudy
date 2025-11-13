import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_2583_영역구하기 {
	static int m, n, k;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();

		map = new int[m][n];
		visited = new boolean[m][n];

		for (int i = 0; i < k; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					map[y][x] = 1; // 채워진 부분 표시
				}
			}
		}

		List<Integer> areas = new ArrayList<>();

		// 전체 탐색
		for (int y = 0; y < m; y++) {
			for (int x = 0; x < n; x++) {
				if (!visited[y][x] && map[y][x] == 0) {
					int area = dfs(y, x);
					areas.add(area);
				}
			}
		}

		Collections.sort(areas);

		System.out.println(areas.size());
		for (int i = 0; i < areas.size(); i++) {
			System.out.print(areas.get(i) + " ");
		}
	}

	static int dfs(int y, int x) {
		visited[y][x] = true;
		int count = 1;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			// 맵 범위 안에 있고, 방문하지 않았으며, 막히지 않은 경우
			if (ny >= 0 && ny < m && nx >= 0 && nx < n) {
				if (!visited[ny][nx] && map[ny][nx] == 0) {
					count += dfs(ny, nx); // 재귀 호출로 이어진 영역 탐색
				}
			}
		}
		return count; // 해당 영역의 넓이 반환
	}
}
