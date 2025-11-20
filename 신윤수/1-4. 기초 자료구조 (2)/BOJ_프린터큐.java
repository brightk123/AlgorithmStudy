import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_프린터큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
				
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken()); // 문서의 개수
			int M = Integer.parseInt(st.nextToken()); // 구해야 하는 문서가 큐에 몇번째에 놓여있는지
			
			Queue<Integer> doc = new LinkedList<>(); // 문서 인덱스 배열
			int[] priorities = new int[N]; // 문서 중요도 배열
			
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				priorities[j] = Integer.parseInt(st.nextToken());
				doc.offer(j);
			}
			
			int count = 0;
			
			while (!doc.isEmpty()) {
				int currentDoc = doc.poll();
				boolean hasHigher = false; // 해당문서보다 더 중요한 문서가 있는지
				
				for (int idx : doc) { // 큐에 남아있는 문서만
					if (priorities[idx] > priorities[currentDoc]) {
						hasHigher = true;
						break; // 더 중요한 문서있음 반복 종료
					}
				}
				
				if (hasHigher) {
					// 현재문서보다 더 중요한 문서있으면, 현재문서 큐 뒤로 보냄
					doc.offer(currentDoc);
				} else { // 그렇지 않으면 현재 문서 인쇄
					count++;
					
					if (currentDoc == M) {
						System.out.println(count);
						break;
					}
				}
			}
		}
	}
}
