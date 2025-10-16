import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_숫자카드2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// Key: 카드에 적힌 숫자, Value: 그 숫자의 개수 (count)
		HashMap<Integer, Integer> map = new HashMap<>();		
		
		// 상근이 카드 입력 + 개수 세기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int card1 = Integer.parseInt(st.nextToken());
			
			// map.put(Key, Value)
			// Key: 카드에 적힌 숫자
			// Value: 새로 계싼된, 갱신할 개수
			map.put(card1, map.getOrDefault(card1, 0) + 1);
		}
		
		// 세야할 카드 입력
		int M = Integer.parseInt(br.readLine());

		// M개의 카드 정수 
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			int card2 = Integer.parseInt(st.nextToken());
			int count = map.getOrDefault(card2, 0);
			
			sb.append(count).append(" ");
		}
		System.out.println(sb.toString().trim());
	}
}
