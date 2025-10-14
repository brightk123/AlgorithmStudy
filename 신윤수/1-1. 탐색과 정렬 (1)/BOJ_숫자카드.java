// HashSet은 Set 인터페이스를 구현한 클래스
// 활용 사례: 배열/리스트 중복요소 제거, 두 배열/리스트 간의 공통요소 찾기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_숫자카드 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		Set<Integer> setA = new HashSet<>();
		for (int i = 0; i < N; i++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		// M개 카드 정보 읽고 새로운 st 생성
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int nums = Integer.parseInt(st.nextToken());
			
			// HashSet 의 contain()을 이용해 존재 여부 확인
			if (setA.contains(nums)) {
				sb.append(1).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}
		
		// 결과 출력
		System.out.println(sb.toString());
		
		
	}
}
