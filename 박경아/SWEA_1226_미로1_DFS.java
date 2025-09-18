import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

public class SWEA_1226_미로1_DFS {

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
			
			
			findWay(startR, startC);
			
			if(found) {
				System.out.println("#"+t+" 1"); // 가능하면 1출력
			}else {
				System.out.println("#"+t+" 0");
			}
			
		}
		
		
	}

	private static void findWay(int startR, int startC) {
		
		if(startR==endR && startC==endC) {
			found = true;
			return;
		}
		
		if(startR<0 || startC<0 || startR>=N || startC>=N ) {
			// 미로의 범위를 초과할 경우 탐색 중지
			return;
		}
		
		if(visited[startR][startC] || maze[startR][startC]==1) {
			// 이미 방문한 칸이거나
			// 미로의 벽을 만난 경우 탐색 중지
			return;
		}
		
		
		visited[startR][startC] = true;
		
		for(int i = 0; i<4; i++) {
			
			if(found) {
				// 만약 도착지점까지 도달하는 경로가 존재한다면 더 이상 탐색 중지
				return;
			}else {
				findWay(startR+dr[i], startC+dc[i]);
			}
		}
		
		visited[startR][startC] = false; // 백트레킹
		
	}
	
	
}
