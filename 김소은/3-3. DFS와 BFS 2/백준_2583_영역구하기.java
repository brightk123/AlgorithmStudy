import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_2583_영역구하기 {

    static int M, N, K;
    static int[][] grid;
    
    // 델타탐색 (상하좌우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static class Point {
        int x, y;
        public Point(int x, int y) {
        	this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        
        grid = new int[N][M];

        for (int i = 0; i < K; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    grid[x][y] = 1;
                }
            }
        }
        
        ArrayList<Integer> areaSize = new ArrayList<>();
        int areaCount = 0;
        
        // 순회하면서 칠해지지 않은 영역(0) 찾음
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < M; j++) {
        		// 칠해지지 않은 영역인 경우
        		if (grid[i][j] == 0) {
        			areaCount++; // 영역 개수 증가시킴
        			int size = bfs(i, j); // bfs로 연결된 영역의 넓이를 구함
        			areaSize.add(size); // 넓이를 리스트에 추가
        		}
        	}
        }
        
        System.out.println(areaCount);
        
        // 넓이를 오름차순으로 정렬
        Collections.sort(areaSize);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < areaSize.size(); i++) {
        	int size = areaSize.get(i);
        	
        	sb.append(size).append(" ");
        }
        
        System.out.println(sb.toString());
    }
    
    public static int bfs (int startX, int startY) {
    	Queue<Point> q = new LinkedList<>();
    	q.offer(new Point(startX, startY));
    	grid[startX][startY] = 1; // 다시 탐색하지 않기 위해 시작점 방문처리
    	int size = 1; // 현재 영역의 넓이
    	
    	while (!q.isEmpty()) {
    		Point current = q.poll(); // 탐색할 좌표를 큐에서 꺼냄
    		
    		// 상하좌우 델타탐색
    		for (int d = 0; d < 4; d++) {
    			int nextX = current.x + dx[d];
    			int nextY = current.y + dy[d];
    			
    			// 경계 검사
    			if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
    				// 방문하지 않은 빈 공간인지 확인
    				if (grid[nextX][nextY] == 0) {
    					grid[nextX][nextY] = 1; // 방문처리
    					q.offer(new Point(nextX, nextY)); // 큐에 추가하여 다음 탐색대상으로
    					size++; // 넓이값 증가
    					
    				}
    			}
    		}
    	}
    	
    	return size;
    }
}
