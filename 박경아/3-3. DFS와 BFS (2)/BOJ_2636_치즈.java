import java.util.*;
import java.io.*;


public class BOJ_2636_치즈 {
	static int N;
	static int M;
	
	static int[][] delta = {{-1,0}, {0,1}, {1,0},{0,-1}}; // 상-우-하-좌
	
	static int[][] czMap;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 사각형 모양 판의 세로 길이 (행의 수)
		M = Integer.parseInt(st.nextToken()); // 사각형 모양 판의 가로 길이 (열의 수)

		czMap = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			for(int j =0; j<M; j++) {
				czMap[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		
		int meltedCZ = 0; // 한 겹당 녹는 치즈의 수
		int lastMeltedCZ = 0; // 마지막으로 녹은 치즈의 수
		int time = 0; // 녹는데 걸리는 시간
		
		while(true) {
			visited = new boolean[N][M];
			meltedCZ = bfs();
			time++;
			
			if(meltedCZ==0) {
				time--;
				break;
			}
			
			lastMeltedCZ = meltedCZ;
		}
		
		System.out.println(time);
		System.out.println(lastMeltedCZ);
		
				
	}// 메인

	private static int bfs() {
		
		Queue<Integer[]> q = new ArrayDeque<>();
		q.add(new Integer[] {0,0}); // (0,0) 좌표를 시작 점으로 입력해주기
		visited[0][0] = true;
		int meltedCZ = 0; // 이번 시간에 녹은 치즈의 갯수를 반환할 것
		
		while(!q.isEmpty()) {
			
			Integer[] curr = q.poll();
			
			int r = curr[0];
			int c = curr[1]; 
			
			for(int i = 0; i<4; i++) {
				int nr = r + delta[i][0];
				int nc = c + delta[i][1];
				
				// 인접 좌표 탐색 진행
				if(nr>=0 && nc>=0 && nr<N && nc<M && !visited[nr][nc]) {
					if(czMap[nr][nc]==1) {
						// 해당 좌표가 치즈인 경우
						czMap[nr][nc] = 0; // 치즈 녹임
						meltedCZ++;
					}else {
						q.add(new Integer[] {nr,nc});
					}
					visited[nr][nc] = true;
				}
			}
		}
		return meltedCZ;
	}
}
