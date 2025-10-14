import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정렬해야 할 점의 갯수
		int N = Integer.parseInt(br.readLine());
		
		// 정렬한 좌표를 담을 리스트
		int[][]  xy = new int[N][2];
		
		String[] temp = new String[2];
		
		
		for(int i = 0; i<N; i++) {
			
			temp = br.readLine().split(" ");
			
			xy[i][0] = Integer.parseInt(temp[0]);
			xy[i][1] = Integer.parseInt(temp[1]);
		}
		
		Arrays.sort(xy, new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				
				if(a[0]!=b[0]) {
					return a[0]-b[0];
				}else {
					return a[1]-b[1];
				}
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int[] code : xy) {
			sb.append(code[0]).append(" ").append(code[1]).append("\n");
		}
		
		System.out.println(sb);
		
	}// main 

}