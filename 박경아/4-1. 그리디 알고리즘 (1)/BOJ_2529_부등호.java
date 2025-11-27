import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ_2529_부등호 {
	
	static int N; // 부등호의 개수 (순열 길이는 N+1)
	
	static List<Integer> minAns; // 최소값 순열 저장
	static List<Integer> maxAns; // 최대값 순열 저장
	static List<Integer> ans;    // 현재 순열 (백트래킹)
	
	static boolean[] numChk; // 숫자 사용 여부 확인 배열 (0~9)
	static String[] signs;  // 부등호 배열
	
	static boolean foundMin = false; // 최소값 발견 시 조기 종료 플래그
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N: 부등호 개수
		N = Integer.parseInt(br.readLine());
		
		// signs: 부등호 입력
		signs = new String[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i<N; i++) {
			signs[i] = st.nextToken();
		}
		
		// 초기화
		numChk = new boolean[10];
		ans = new ArrayList<>();
		
		// DFS 실행 (count는 현재까지 선택한 숫자의 개수)
		dfs(0);
		
		// 결과 출력 (최대값, 최소값 순)
		System.out.println(listToString(maxAns));
		System.out.println(listToString(minAns));
	}

	
	/**
	 * 백트래킹을 사용하여 조건을 만족하는 순열을 찾습니다.
	 * @param count 현재까지 선택한 숫자의 개수
	 */
	private static void dfs(int count) {
		
		// 기저 조건: N+1개의 숫자를 모두 선택한 경우
		if(count == (N+1)) {
			
			// 1. 최소값 순열 저장 (가장 먼저 발견된 순열)
			if(minAns == null) {
				minAns = new ArrayList<>(ans);
				foundMin = true; // 최소값을 찾았으므로 조기 종료 플래그 설정
			}
			
			// 2. 최대값 순열 저장 (가장 마지막에 발견된 순열)
			maxAns = new ArrayList<>(ans);
			return;
		}
		
		
		// 0부터 9까지 오름차순으로 숫자를 시도 (최소값 먼저 발견)
		for(int i = 0; i <= 9; i++) {
			
			// 1. 사용된 숫자 건너뛰기
			if(numChk[i]) continue;
			
			// 2. 조건 확인 (첫 번째 숫자이거나, 부등호 조건 만족 시)
			if(count == 0 || check(ans.get(count - 1), i, signs[count - 1])) {
				
				// 선택
				numChk[i] = true;
				ans.add(i);
				
				// 재귀 호출
				dfs(count + 1);
				
				// 최소값을 찾았으면, 더 이상 이 경로를 탐색할 필요가 없으므로 백트래킹 후 리턴
				if(foundMin && minAns != null) {
				    numChk[i] = false;
				    ans.remove(ans.size()-1);
				    return; 
				}
				
				// 백트래킹
				numChk[i] = false;
				ans.remove(ans.size()-1);
			}
		}
	}
	
	
	/**
	 * 부등호 조건을 확인하는 헬퍼 함수
	 */
	private static boolean check(int prev, int current, String sign) {
		
		if(sign.equals("<")) {
			return prev < current;
		} else { // sign.equals(">")
			return prev > current;
		}
	}
	
	
	/**
	 * List<Integer>를 문자열로 변환하여 반환
	 */
	private static String listToString(List<Integer> list) {
	    StringBuilder sb = new StringBuilder();
	    for (int num : list) {
	        sb.append(num);
	    }
	    return sb.toString();
	}
}