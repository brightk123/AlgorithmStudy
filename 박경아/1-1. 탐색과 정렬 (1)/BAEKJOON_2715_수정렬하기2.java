import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BAEKJOON_2715_수정렬하기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 입력 받을 수의 갯수

		int[] num = new int[N]; // 숫자열을 입력 받을 배열

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(num);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(num[i]).append("\n");
		}

		System.out.println(sb);

	}

}
