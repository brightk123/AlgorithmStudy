import java.util.Scanner;

public class Main {

    static int N;
    static boolean found = false; // 가장 작은 수열을 찾으면 탐색 중단

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();

        dfs(""); // 빈 문자열부터 시작
    }

    // 백트래킹 함수
    static void dfs(String seq) {
        if (found) return; // 이미 답을 찾은 경우 중단
        if (seq.length() == N) {
            System.out.println(seq);
            found = true;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (isGood(seq + i)) {
                dfs(seq + i);
            }
        }
    }

    // "좋은 수열"인지 검사
    static boolean isGood(String s) {
        int len = s.length();

        // 뒤에서부터 절반 길이씩 비교
        for (int i = 1; i <= len / 2; i++) {
            String a = s.substring(len - i);
            String b = s.substring(len - 2 * i, len - i);
            if (a.equals(b)) return false; // 인접한 두 부분 수열이 같으면 나쁜 수열
        }

        return true;
    }
}
