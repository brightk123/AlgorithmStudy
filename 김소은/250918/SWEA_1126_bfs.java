import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1126_bfs {
	
	// 상하좌우 탐색
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
		
	static boolean[][] visited = new boolean[16][16]; // 방문여부
	static int[][] maze = new int[16][16];
	
	static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            // 도착점 찾음
            if (maze[cx][cy] == 3) {
                return true;
            }

            // 4방향 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                // 범위 체크 & 벽 체크 & 방문 체크
                if (nx >= 0 && nx < 16 && ny >= 0 && ny < 16) {
                    if (!visited[nx][ny] && maze[nx][ny] != 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return false; // 도착점 못 찾음
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
			
			int startX = 0, startY = 0;
            // 출발점 찾기
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    if (maze[i][j] == 2) {
                        startX = i;
                        startY = j;
                    }
                }
            }

            boolean found = bfs(startX, startY);
            
            // 출력
         	if (found == true) {
         		System.out.println("#" + tc + " " + 1);
         	} else {
         		System.out.println("#" + tc + " " + 0);
         	}
		}
	}
}
