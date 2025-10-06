import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

public class BOJ_10816_숫자카드2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자 카드 갯수
		
		HashMap<Integer, Integer> nums = new HashMap<>(); // 상근이가 가지고 있는 숫자 카드 목록
		
		String[] temp = br.readLine().split(" ");
		
		for(int i = 0; i<N; i++) {
		
			if(nums.containsKey(Integer.parseInt(temp[i]))){
				// 상근이가 가지고 있는 숫자카드가 중복일 경우 중복된 카드의 숫자 세기
				
				int count = nums.get(Integer.parseInt(temp[i]));
				nums.replace(Integer.parseInt(temp[i]), count, ++count);
				
			}else {
				// 처음 등장한 숫자카드 일 경우 숫자 + 갯수(1, 기본값) 입력
				nums.put(Integer.parseInt(temp[i]), 1);
			}
		}
		
		////
		
		int M = Integer.parseInt(br.readLine()); // 비교할 카드 갯수
		
		String[] temp2 = br.readLine().split(" ");
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<M; i++) {

			int compNum = Integer.parseInt(temp2[i]);
			
			if(nums.containsKey(compNum)) {
				// 상근이가 비교할 카드를 가지고 있는 경우 해당 카드와 갯수 저장
				sb.append(nums.get(compNum)).append(" ");
			}else {
				// 상근이가 가지고 있지 않은 카드의 경우 0 출력
				sb.append(0).append(" ");
			}
		}
		
		////
		
		System.out.println(sb);
		
		
	}// main 
}