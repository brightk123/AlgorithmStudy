import java.util.*;
import java.io.*;


public class BOJ_2583_영역구하기 {
	
	static boolean[][] grid;
	
	static int N;
	static int M;
	static int K;
	
	static int count;
	
	static int[][] delta = {{-1,0}, {0,1}, {1,0},{0,-1}}; // 상-우-하-좌
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // 직사각형의 갯수
		
		grid = new boolean[M][N];
		
		
		for(int i = 0; i<K; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int lr = Integer.parseInt(temp.nextToken()); // 왼쪽 아래
			int lc = Integer.parseInt(temp.nextToken());
			int rr = Integer.parseInt(temp.nextToken()); // 오른쪽 위
			int rc = Integer.parseInt(temp.nextToken());
			
			for(int x = lr; x<rr; x++) {
				for(int y = lc; y<rc; y++) {
					grid[y][x] = true;
				}
			} // 사각형 영역 입력
		}
		
		count = 0;
		int gridSize = 0;
		List<Integer> sizes = new ArrayList<>();
		
		// 그리드에서 비어있는 곳을 찾아 BFS 수행
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!grid[i][j]) { // 비어있는 곳이면
                    gridSize = bfs(i, j); // BFS 실행
                    sizes.add(gridSize); // 크기 추가
                    count++;
                }
            }
        }
        
		System.out.println(count);
		Collections.sort(sizes);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<sizes.size(); i++) {
			sb.append(sizes.get(i)).append(" ");
		}
		
		System.out.println(sb);
		
				
	}// 메인

	private static int bfs(int sr, int sc) {
		Queue<Integer[]> q = new ArrayDeque<>();
		q.add(new Integer[] {sr,sc});
		grid[sr][sc] = true;
		
		int size = 1;
		
		while(!q.isEmpty()) {
			
			Integer [] curr = q.poll();
			
			int r = curr[0];
			int c = curr[1];
			
			// 인접 좌표 탐색
			for(int i = 0; i<4; i++) {
				int nr = r + delta[i][0];
				int nc = c + delta[i][1];
				
				// 인접 좌표 탐색 진행
				if(nr>=0 && nc>=0 && nr<M && nc<N && !grid[nr][nc]) {
					size++;
					grid[nr][nc] = true;
					q.add(new Integer[] {nr,nc}); // 다음 좌표 탐색
				}
			}
		}
		return size;
		
	}
}
