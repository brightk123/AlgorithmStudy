import java.util.Scanner;

public class SWEA_1126_dfs {
	
	// 상하좌우 탐색
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static boolean[][] visited = new boolean[16][16]; // 방문여부
	static int[][] maze = new int[16][16];
	static boolean found; // 도착점 도달여부
	
	
	static void dfs(int x, int y) {
		// 1. 범위 밖, 벽, 방문 여부 확인
		if (x < 0 || y < 0 || x >= 16 ||y >= 16) return;
		if (maze[x][y] == 1 || visited[x][y]) return;
		
		// 2. 도착점 확인
		if (maze[x][y] == 3) {
			found = true;
			return;
		}
		
		// 3. 방문처리
		visited[x][y] = true;
		
		// 4. 4방향탐색
		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			dfs(nx, ny);
			
			// 도착점 도달하면 탐색안함
			if (found) return;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int T = 1; T <= 10; T++) {
			int tc= sc.nextInt();
			for (int i = 0; i < 16; i++) {
				String s = sc.next();
				for (int j = 0; j < 16; j++) {
					maze[i][j] = s.charAt(j) - '0';
					visited[i][j] = false; // 방문여부 초기화
				}
			}
			
			found = false;
			
			int startX = 0;
			int startY = 0;
			
			// 시작지점 찾음
			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 16; j++) {
					if(maze[i][j] == 2) {
						startX = i;
						startY = j;
					}
				}
			}
			
			// dfs탐색
			dfs(startX, startY);
			
			// 출력
			if (found == true) {
				System.out.println("#" + tc + " " + 1);
			} else {
				System.out.println("#" + tc + " " + 0);
			}
		}
	}
}
