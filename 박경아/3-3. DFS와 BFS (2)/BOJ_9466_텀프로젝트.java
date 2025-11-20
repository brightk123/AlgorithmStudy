import java.io.*;
import java.util.*;

public class BOJ_9466_텀프로젝트 {
    static int[] studentNum;
    static boolean[] visited;
    static boolean[] finished;
    static int count;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int TC = 1; TC<=T; TC++) {
        	int n = Integer.parseInt(br.readLine());

            studentNum = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                studentNum[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            // 팀을 이루지 못한 학생 수 출력
            System.out.println(n - count);
        }
    }
            
    static void dfs(int now) {
        visited[now] = true;
        int next = studentNum[now];

        if (!visited[next]) {
            dfs(next);
        } else {
            if (!finished[next]) { // 팀원 구성의 사이클 발견 Sn->S1을 가리키는 순간
                count++; // now 자신 포함
                for (int i = next; i != now; i = studentNum[i]) {
                    count++;
                }
            }
        }

        finished[now] = true;
    }
}
