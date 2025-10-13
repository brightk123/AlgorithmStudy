// BOJ 1406

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_에디터 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());
		
		Stack<Character> leftStack = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			leftStack.push(str.charAt(i));
		}
		
		Stack<Character> rightStack = new Stack<>();
		
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			
			if (command.equals("P")) {
				char letter = st.nextToken().charAt(0);
				leftStack.push(letter);
			} else if (command.equals("L")) {
				if (!leftStack.isEmpty()) {
					char letter = leftStack.pop();
					rightStack.push(letter);
				}
			} else if (command.equals("D")) {
				if (!rightStack.isEmpty()) {
					char letter = rightStack.pop();
					leftStack.push(letter);
				}
			} else if (command.equals("B")) {
				if (!leftStack.isEmpty()) {
					leftStack.pop();					
				}
			}
		}
		
		// 최종 결과 출력
		// 1. 왼쪽 스택의 내용을 오른쪽 스택으로 모두 이동
		// (순서를 맞추기 위함)
		while (!leftStack.isEmpty()) {
			rightStack.push(leftStack.pop());
		}
		
		// 2. 오른쪽 스택의 내용을 모두 꺼내 sb에 추가
		while (!rightStack.isEmpty()) {
			sb.append(rightStack.pop());
		}
		
		System.out.println(sb.toString());
	}
}
