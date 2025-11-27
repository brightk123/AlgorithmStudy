import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_로프 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] ropes = new int[N];
		
		// 입력받기
		for (int i = 0; i < N; i++) {
			ropes[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(ropes);
		int maxWeight = 0;
		
		// 지금 로프가 제일 약한 로프라고 가정
		for (int i = 0; i < N; i++) {

			int ropesCount = N - i; // 지금 로프의 개수
			int weight = ropes[i] * ropesCount; // 지금 들 수 있는 무게
			
			if (weight > maxWeight) {
                maxWeight = weight;
            }
		}
		
		System.out.println(maxWeight);
		
	}
}
