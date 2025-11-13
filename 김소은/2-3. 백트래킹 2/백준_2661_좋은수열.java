import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 백준_2661_좋은수열 {
    
	static int N;
    static boolean found = false; // 가장 작은 수를 가장 먼저 찾으면 프로그램을 종료시키기 위한 boolean

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        // 백트래킹
        // 초기 길이는 0, 수열은 빈 문자열
        solve(0, "");
    }

    // 현재까지 만들어진 수열이 좋은 수열인지 확인하는 함수
    // 새로 추가된 마지막 숫자를 포함하는 인접한 부분 수열 쌍만 검사
    // s : 현재 수열
    // 좋은 수열이면 true, 나쁜 수열이면 false
    public static boolean isGoodSequence(String s) {
        int length = s.length();
        
        // 비교할 부분 수열의 길이 k는 1부터 (전체 길이 / 2)까지
        for (int k = 1; k <= length / 2; k++) {
            // 뒷부분 수열: s.substring(length - k)
            String back = s.substring(length - k);
            
            // 앞부분 수열: s.substring(length - 2 * k, length - k)
            String front = s.substring(length - 2 * k, length - k);

            // 두 부분 수열이 동일하면 나쁜 수열
            if (front.equals(back)) {
                return false; 
            }
        }
        
        return true; // 모든 검사를 통과했으므로 좋은 수열
    }
  
    // 백트래킹을 통해 길이가 N인 가장 작은 좋은 수열을 찾는 함수
    // 숫자를 1, 2, 3 순서로 시도하여 최소값을 보장
    // len : 현재까지 만들어진 수열의 길이
    // sequence : 현재까지 만들어진 수열
    public static void solve(int len, String sequence) {
        // 이미 답을 찾았으면 더 이상 탐색하지 않고 종료
        if (found) return;

        if (len == N) {
            // 길이가 N에 도달하면 가장 작은 수열이므로 출력하고 플래그를 true로 설정하여 종료
            System.out.println(sequence);
            found = true;
            return;
        }

        // 1, 2, 3 순서로 숫자를 시도
        for (int i = 1; i <= 3; i++) {
            String nextSequence = sequence + i;
            
            // 1. nextSequence가 좋은 수열인지 확인
            if (isGoodSequence(nextSequence)) {
                // 2. 좋은 수열이라면 다음 자릿수 탐색 (재귀 호출)
                solve(len + 1, nextSequence);
            }
            // 3. 나쁜 수열이라면 (else) 이 경로 포기 (백트래킹)하고 다음 i 값 시도
        }
    }
}
