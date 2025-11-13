import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	
	int page;
	int value;
	
	public Node(int page, int value) {
		this.page = page;
		this.value = value;
	}
}

public class BOJ_1966_프린터_큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int TC = 1; TC<=t; TC++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 문서의 갯수
			int M = Integer.parseInt(st.nextToken()); // 인쇄 순서를 알고 싶은 페이지
			
			Queue<Node> q = new ArrayDeque<>(); // 프린터 작업을 저장할 큐 생성
			
			
			// 중요도를 내림차순으로 리스트에 저장하고
			// 해당 중요도를 가진 페이지가 출력될 때마다 리스트에서 중요도 값 제거
			List<Integer> values = new ArrayList<>();
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			for(int i = 0; i<N; i++) {
				
				int page = i;
				int value = Integer.parseInt(st2.nextToken()); // 중요도
				values.add(value);
				
				q.add(new Node(page, value));
				
			}// 문서 노드 생성 + 큐에 저장
			
			Collections.sort(values, Collections.reverseOrder());
			
			int answer = 0; // 궁금한 페이지가 출력되는 순서
			
			while(! q.isEmpty()) {
				
				Node curr = q.poll();
				
				if(curr.value==values.get(0)) {
					// 프린터 출력
					values.remove(0);
					answer ++;

					if(curr.page==M) {
						// 내가 원하는 페이지가 출력하는 순서가 왔다면
						System.out.println(answer);
						break;
					}
					
				}else if(curr.value<values.get(0)) {
					// 최대 중요도가 아니면 큐의 맨 뒤로 삽입
					q.add(curr);
				}
			}
		}// 테스트 케이스
	}
}
