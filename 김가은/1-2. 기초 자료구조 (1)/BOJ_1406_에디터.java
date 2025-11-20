package 기초자료구조;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_1406_에디터 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String initial = sc.nextLine();
		int M = sc.nextInt();
		sc.nextLine(); // 개행 처리

		Deque<Character> left = new ArrayDeque<>();
		Deque<Character> right = new ArrayDeque<>();

		for (char c : initial.toCharArray()) {
			left.push(c);
		}

		for (int i = 0; i < M; i++) {
			String cmd = sc.next();

			switch (cmd) {
			case "L":
				if (!left.isEmpty())
					right.push(left.pop());
				break;
			case "D":
				if (!right.isEmpty())
					left.push(right.pop());
				break;
			case "B":
				if (!left.isEmpty())
					left.pop();
				break;
			case "P":
				char ch = sc.next().charAt(0);
				left.push(ch);
				break;
			}
		}

		// 결과 문자열 생성
		StringBuilder sb = new StringBuilder();

		// 왼쪽 스택을 모두 오른쪽으로 옮겨 원래 순서 복원
		while (!left.isEmpty()) {
			right.push(left.pop());
		}

		while (!right.isEmpty()) {
			sb.append(right.pop());
		}

		System.out.println(sb.toString());
		sc.close();
	}
}
