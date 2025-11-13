//풀이시간: 2시간

import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_AC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			String order = sc.next(); // 명령 문자열
			int n = sc.nextInt();
			String s = sc.next(); // 배열 한 줄 ( [ ] 포함 )
			
			StringTokenizer st = new StringTokenizer(s, "[],");
			
			int[] arr = new int[n];
			
			// 입력받기
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int L = 0;
			int R = n - 1;
			boolean reverse = false;
			boolean error = false;
			
			// 오더 입력 읽기
			for (int i = 0; i < order.length(); i++) {
				char c = order.charAt(i);
				
				if (c == 'R') {
					reverse = !reverse;
				} else { // 'D'
					if (L > R) { // 비었으면
						error = true;
						break; // 더 볼필요 없음
					}
					if (!reverse) // 정방향이라면
						L++;
					else 
						R--;
				}
			}
			
			// 출력 전 구조 짜놓기
			StringBuilder sb = new StringBuilder();
			
			sb.append('[');

			boolean first = true;  // 아직 아무 것도 안 찍었다는 의미
			if (!reverse) {
			    for (int i = L; i <= R; i++) {
			        if (!first) sb.append(','); // 첫 번째 이후부터 콤마 추가
			        sb.append(arr[i]);
			        first = false;              // 이제부터는 첫 번째가 아님
			    }
			} else {
			    for (int i = R; i >= L; i--) {
			        if (!first) sb.append(',');
			        sb.append(arr[i]);
			        first = false;
			    }
			}
			
			sb.append(']');
			
			// 출력
			if (error) {
				System.out.println("error");
			} else {
				System.out.println(sb.toString());
			}
		}
	}
}
