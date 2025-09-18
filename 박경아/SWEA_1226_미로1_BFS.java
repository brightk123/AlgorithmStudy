import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

public class SWEA_1226_미로1_BFS {

	static int[][] maze; // 미로 배열
	static int N = 16; // 미로 한 변의 크기
	
	// 시작 지점 좌표와 도착 지점 좌표
	static int startR;
	static int startC;
	
	static int endR;
	static int endC;
	
	// 방향 탐색을 위한 델타 배열 생성
	static int[] dr = {0, 1, 0, -1}; // 우-하-좌-상
	static int[] dc = {1, 0, -1, 0}; // 우-하-좌-상
	
	static boolean[][] visited; // 방문 확인 배열 생성
	static boolean found;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner (System.in);
		
		
		for(int TC = 1; TC<=10; TC++) {
			
			int t = Integer.parseInt(sc.nextLine());
			
			maze = new int[N][N]; // 미로 배열 생성
			visited = new boolean[N][N]; // 방문 확인 배열 생성
			found = false;
			
			for(int i = 0; i<16; i++) {
				char[] temp = sc.nextLine().toCharArray();
				for(int j = 0; j<16; j++) {
					maze[i][j] = temp[j]-'0';
					if(maze[i][j] == 2) {
						startR = i;
						startC = j;
					}
					if(maze[i][j] == 3) {
						endR = i;
						endC = j;
					}
				}
			}// 미로 입력
			
			
			if(BFS(startR, startC)) {
				System.out.println("#"+TC+" 1"); // 가능하면 1출력
			}else {
				System.out.println("#"+TC+" 0");
			}
			
		}
	}

	private static boolean BFS(int startR, int startC) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {startR, startC});
		visited[startR][startC] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int cr = current[0];
			int cc = current[1];
			
			// 도착지에 도달하면 true
			if(maze[cr][cc] == 3) {
				return true;
			}
			
			for(int i = 0; i<4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if(nr >= 0 && nc>= 0 && nr<N && nc<N) {
					if(!visited[nr][nc] && maze[nr][nc] != 1) {
						queue.offer(new int[] {nr,nc});
						visited[nr][nc] = true;
					}
				}
			}
		}
		return false;
	}
}
