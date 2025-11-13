import java.util.Scanner;

public class BOJ_NQueen {
	static int result;
	static int[] board; // 1차원 보드, 각행에 퀸을 둔 열만 기록
	static boolean[] visited; // 퀸의 세로의 위치에 true를 기록
	static int N; // 보드 한변의 길이
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = Integer.parseInt(sc.nextLine());
		
		// NxN 체스판에 퀸을 N개 배치할 수 있는 경우의 수 result
		result = 0;
		board = new int[N];
		visited = new boolean[N];
		
		nQueen(0); // 0행부터 배치 시작
		
		System.out.println(result);
	}

	static void nQueen(int i) {
		if (i == N) { // N행까지 모두 성공적으로 퀸 배치 완료
			result++; // 한가지 유효한 해를 찾음
			return;
		}
		
		// (i, j) 위치에 현재 퀸을 배치 시도
		for (int j = 0; j < N; j++) { // i행에 퀸을 놓을 열 j를 차례대로 시도
			if (visited[j] || check(i, j)) {
				continue; // 같은 열이거나 대각선 충돌이면 이 선택은 버림 (가지치기)
			}
			
			// i행 j열에 퀸 두기
			board[i] = j;
			visited[j] = true;
			
			nQueen(i + 1); // 다음 행으로 내려감
			
			// 백트래킹: 이 열(j)를 비워서 다음 열 시도
			visited[j] = false;
		}
	}

	// 대각선 충돌 검사
	static boolean check(int i, int j) {
		// 전에 배치되어있는 퀸의 위치 (x, y)
		for (int x = 0; x < i; x++) {
			int y = board[x];
			
			// (x, y) 좌표가 (i, j)좌표에 대해 간섭 있는지 확인
			if (Math.abs(x - i) == Math.abs(y - j)) { // 대각선 판정
				return true; // 간섭된다는 뜻
			}
		}
		
		// 간섭이 없다면
		return false;
	}
	
}
