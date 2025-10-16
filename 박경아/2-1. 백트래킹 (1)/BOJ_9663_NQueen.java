import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class BOJ_9663_NQueen {
    static int result; // 경우의 수
    static int[] board; // 보드판 (일차원 배열)
    static boolean[] visited; // 퀸의 세로 위치 여부 확인 
    // 보드판이 N x N 정사각형이므로 퀸의 세로 여부도 일차원 배열로 가능
    static int N; // 보드의 크기
     
     
    private static void nQueen(int i) {
        // 기저 조건
        if(i==N) {
            // 모든 행에서 퀸이 정상적으로 배치되었으므로 경우의 수 카운트
            result++;
            return;
        }
         
        // 유도 조건
        // (i,j) 위치에 현재 퀸을 배치 시도
        for(int j = 0; j<N; j++) {
            // i : 보드판의 행을 의미
            // j에 대한 반복문 : 보드판의 열에 대한 반복
             
            // (i,j) 위치에 퀸 배치 가능 여부 확인
            if(visited[j] || crossCheck(i,j)) continue;
            // 같은 열에 다른 퀸이 배치되어 있거나, 대각선에 퀸이 존재할 경우 배치 불가
             
            // 주변에 퀸이 없을 경우 (i,j)위치에 퀸 배치 가능
            board[i] = j;
            visited[j] = true;
            nQueen(i+1); // 다음 행으로 이동
            visited[j] = false;
            // 다음 행(i+1)에서 퀸 배치가 불가할 경우 i행의 퀸 위치를 재 탐색해야함
            // 백트래킹을 위해 visited[j] 초기화
            // borad의 경우 값이 덮어 씌워지므로 초기화해줄 필요 없음
        }
         
    }
     
    // 대각선 위치에 다른 퀸이 이미 존재하는지 여부 확인
    private static boolean crossCheck(int i, int j) {
        // 이전에 배치되어 있는 퀸들의 위치를 (x,y)로 임시 저장
        for(int x = 0; x<i; x++) {
            int y = board[x];
             
            // (x,y)좌표가 (i,j) 좌표에 대해 대각선에 존재하는지 여부 확인
            if(Math.abs(x-i)==Math.abs(y-j)) {
                return true;
            }
        }
         
        // 대각선에 존재하지 않을 경우 false 반환
        return false;
    }
     
    public static void main(String[] args) {
 
        Scanner sc = new Scanner (System.in);
        
        // N : 배치할 퀸의 갯수 / 보드의 크기
        N = sc.nextInt();
         
        // result : N X N 체스판에 N개의 퀸을 서로 다른 두 퀸이 공격하지 못하게 두는 경우의 수
        result = 0;
        board = new int[N];
        visited = new boolean[N];
         
        // 완전탐색 + 백트레킹 진행
        nQueen(0);
        System.out.println(result);
    }
}
