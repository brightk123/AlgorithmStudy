import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // end까지 소수 테이블 생성
        boolean[] isComposite = new boolean[end + 1];
        if (end >= 0) isComposite[0] = true;
        if (end >= 1) isComposite[1] = true;

        for (int i = 2; (long)i * i <= end; i++) {           // i*i 오버플로우 방지
            if (!isComposite[i]) {
                for (long j = (long)i * i; j <= end; j += i) { // i의 제곱부터 지우기
                    isComposite[(int) j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int s = Math.max(start, 2);
        for (int x = s; x <= end; x++) {
            if (!isComposite[x]) sb.append(x).append('\n');
        }
        System.out.print(sb.toString());
    }
}
