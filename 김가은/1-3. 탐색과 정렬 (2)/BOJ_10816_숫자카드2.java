package 탐색과정렬;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_10816_숫자카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Map<Integer, Integer> map = new HashMap<>();

		// 상근이의 카드 입력
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		// 찾을 숫자들 입력 후 개수 출력
		for (int i = 0; i < M; i++) {
			int query = sc.nextInt();
			sb.append(map.getOrDefault(query, 0)).append(" ");
		}

		System.out.println(sb.toString().trim());
		sc.close();
	}
}
