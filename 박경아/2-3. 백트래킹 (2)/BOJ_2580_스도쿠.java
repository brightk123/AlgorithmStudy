import java.util.*;
import java.io.*;

public class BOJ_2580_스도쿠 {
    static int[][] board = new int[9][9];
    static List<int[]> targets = new ArrayList<>();
    static boolean solved = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 9x9 스도쿠 전체 데이터 입력
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0)
                    // 스도쿠 데이터 중 빈칸인 부분의 좌표를 targets 리스트에 저장
                    targets.add(new int[]{i, j});
            }
        }
        searchTarget(0);
        
        //출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
           
    }

    // 빈칸 좌표 채우기
    static void searchTarget(int idx) {
        if (solved) return; // 이미 답을 찾았으면 종료

        if (idx == targets.size()) {
            // 인덱스가 targets 리스트의 마지막 데이터에 도달했을 경우
            solved = true;
            return;
        }
        
        // 빈칸 좌표 가져오기
        int[] RC = targets.get(idx);
        int R = RC[0];
        int C = RC[1];

        for (int num = 1; num <= 9; num++) {
            if (isOK(R, C, num)) {      // 유효성 검사 실시 후 가능한 경우이면
                board[R][C] = num;      // 빈칸 숫자 넣기
                searchTarget(idx + 1);  // 다음 빈칸으로 넘어가기
                if(solved) return;      // 답을 찾았을 경우 함수 종료
                board[R][C] = 0;        // 해당 숫자가 틀린 값일 경우 되돌리기
            }
        }
    }

    // 유효성 검사 (행, 열, 3x3 박스)
    static boolean isOK(int R, int C, int num) {
        // 1. 행 검사 (세로)
        // 세로 줄 중에 이미 해당 값이 존재할 경우 fasle 반환 (불가)
        for (int i = 0; i < 9; i++)
            if (board[R][i] == num) return false;

        // 2. 열 검사 (가로)
        // 가로 줄 중에 이미 해당 값이 존재할 경우 fasle 반환 (불가)
        for (int i = 0; i < 9; i++)
            if (board[i][C] == num) return false;

        // 3. 3x3 작은 사각형 검사
        // 작은 사각형의 왼쪽 꼭대기 좌표를 찾기
        int startR = (R / 3) * 3;
        int startC = (C / 3) * 3;

        for (int i = startR; i < startR + 3; i++) {
            for (int j = startC; j < startC + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }
        
        // 모든 유효성 검사를 통과했을 경우 해당 좌표에 해당 숫자가 와도 됨 
        return true;
    }
}
