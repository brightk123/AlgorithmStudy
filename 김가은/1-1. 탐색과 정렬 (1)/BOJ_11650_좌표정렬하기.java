package 탐색과정렬;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11650_좌표정렬하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] points = new int[N][2]; // x, y 좌표 저장

		for (int i = 0; i < N; i++) {
			points[i][0] = sc.nextInt(); // x
			points[i][1] = sc.nextInt(); // y
		}

		// 정렬: x 오름차순, x 같으면 y 오름차순
		Arrays.sort(points, (a, b) -> {
			if (a[0] == b[0])
				return a[1] - b[1];
			return a[0] - b[0];
		});

		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(points[i][0]).append(" ").append(points[i][1]).append("\n");
		}

		System.out.print(sb);
		sc.close();
	}
}
