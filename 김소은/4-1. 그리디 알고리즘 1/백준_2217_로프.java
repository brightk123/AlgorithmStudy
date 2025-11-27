import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_2217_로프 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] weight = new int[N];
		for (int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(weight);
		
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			int w = weight[i] * (N - i);
			
			if (w > max) {
				max = w;
			}
		}
		
		System.out.println(max);
	}
}