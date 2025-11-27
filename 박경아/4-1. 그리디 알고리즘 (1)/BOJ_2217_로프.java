import java.io.*;
import java.util.*;

public class BOJ_2217_로프 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 로프의 갯수
		
		int[] ropes = new int[N];
		
		// 로프의 무게 배열에 담기
		for(int i = 0; i<N; i++) {
			ropes[i] = Integer.parseInt(br.readLine());
		}
		
		// 로프 무게 오름차순으로 정렬
		Arrays.sort(ropes);
		
		// 최대 하중을 담을 변수 생성
		int maxWeight = 0;
		
		// 최대 하중 비교
		// ropes[i] * (N-i)의 값부터 시작해서
		// ropes[N]까지 비교
		for(int i = 0; i<N; i++) {
			int compWeight = ropes[i] * (N-i);
			maxWeight = Math.max(compWeight, maxWeight);
		}
		
		System.out.println(maxWeight);
		
	}// main 
}