import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_좌표정렬하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		// [x, y] 좌표를 저장하기 위한 2차원 배열 
		int[][] points = new int[N][2];
				
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken()); // x
			points[i][1] = Integer.parseInt(st.nextToken()); // y
		}
		
		// **Comparator를 이용한 정렬**
		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] p1, int[] p2) {
				// x좌표가 다르면 x기준으로 오름차순 정렬
				if (p1[0] != p2[0]) {
					return p1[0] - p2[0];
				}
				
				// x좌표가 같으면 y좌표 기준으로 오름차순 정렬
				return p1[1] - p2[1];
			}
		});
		
		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(points[i][0]).append(" ").append(points[i][1]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
