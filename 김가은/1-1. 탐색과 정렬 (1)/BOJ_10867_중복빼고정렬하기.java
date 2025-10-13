package 탐색과정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BOJ_10867_중복빼고정렬하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			set.add(sc.nextInt());
		}

		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		for (int num : list) {
			sb.append(num).append(" ");
		}

		System.out.println(sb.toString().trim());
		sc.close();
	}
}
