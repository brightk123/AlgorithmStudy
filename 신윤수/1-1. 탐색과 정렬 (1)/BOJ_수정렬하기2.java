import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_수정렬하기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// br.readline() 에서 에러가 떠서 보니 throws exception 을 에드하라고했다...
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}
}
