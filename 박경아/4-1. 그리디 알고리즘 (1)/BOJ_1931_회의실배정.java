import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931_회의실배정 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 회의 갯수
		
		int[][] meetings = new int[N][2];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken()); // 회의 시작 시간
			meetings[i][1] = Integer.parseInt(st.nextToken()); // 회의 종료 시간
		}
		
		
		// 가장 많은 회의를 감당하기 위해서는
		// 회의 종료시간이 빠를 수록 유리, 회의 시작 시간은 굳이 따지자면 빠를 수록 유리
		
		Arrays.sort(meetings, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				// 만약 끝나는 시간이 동일할 경우 시작하는 시간을 비교
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}

				// 기본적으로는 회의시간이 빨리 끝나는 회의를 기준으로 정렬
				return o1[1]-o2[1];
			}
			
		});
		
		int count = 0; // 회의 갯수를 담을 변수
		int end = 0; // 회의 끝나는 시간을 담아 비교할 변수 
		
		for(int i = 0; i<N; i++) {
			if(meetings[i][0] >= end) {
				count++;
				end = meetings[i][1];
			}
		}
		
		System.out.println(count);
	}// main 
}