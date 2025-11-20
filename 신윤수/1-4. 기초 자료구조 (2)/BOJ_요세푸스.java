// offerLast(x): 뒤로 넣기
// pollFirst: 앞에서 빼기
// offerLast(pollFirst()): 앞에서 하나 꺼내서 뒤에 붙인다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_요세푸스 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		int idx = 1;
		sb.append("<");
		
		while(!q.isEmpty()) {
			
			if (q.size() == 1) { // 큐에 마지막 한게 있으면
				sb.append(q.poll()).append(">");
			} else if (idx % K == 0) { // K의 배수일 때 빼서 sb에 추가
				sb.append(q.poll()).append(", ");
			} else { // K배수가 아니면 빼서 뒤에 넣기
				int temp = q.poll();
				q.offer(temp);
			}
			
			idx++;
		}
		System.out.println(sb.toString());
	}
}
