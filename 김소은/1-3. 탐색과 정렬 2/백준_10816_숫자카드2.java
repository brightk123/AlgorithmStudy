import java.util.HashMap;
import java.util.Scanner;

public class 백준_10816_숫자카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 숫자 카드의 개수 N 입력
		int N = sc.nextInt();

		// 각 숫자 카드의 개수를 저장할 HashMap 생성
		HashMap<Integer, Integer> card = new HashMap<>();
		
		// N개의 숫자 카드를 입력받아 HashMap에 저장
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			// 이미 있는 숫자면 개수를 +1, 없으면 0에서 시작해서 +1
			card.put(num, card.getOrDefault(num, 0) + 1);
		}
		
		// 숫자의 개수 M 입력
		int M = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		
		// M개의 숫자를 입력받고, 각 숫자가 card에 몇 개 있는지 확인
		for (int i = 0; i < M; i++) {
			int query = sc.nextInt();  // 확인할 숫자 입력

			// 해당 숫자의 개수를 가져와 출력 문자열에 추가 (없으면 0)
			sb.append(card.getOrDefault(query, 0));
			
			// 마지막 숫자가 아니라면 공백 추가
			if (i < M - 1) sb.append(" ");
		}

		// 출력
		System.out.println(sb.toString());
	}
}
