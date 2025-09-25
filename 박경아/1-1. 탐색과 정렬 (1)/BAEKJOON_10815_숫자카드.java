import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BAEKJOON_10815_숫자카드 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자 카드의 갯수
		
		
		Set<Integer> cardSet = new HashSet<>(); // 상근이가 가지고 있는 숫자 카드에 적힌 수
		// 숫자 배열을 별도로 정렬하지 않고 빠르게 찾기 위해 HashSet 사용
		
		String[] temp = br.readLine().split(" "); // 숫자 카드 수 임시 입력
		
		for(int i = 0; i<N; i++) {
			cardSet.add(Integer.parseInt(temp[i]));
		} // 숫자 카드 데이터 입력
		
		
		int M = Integer.parseInt(br.readLine()); // 소유 여부를 확인해야할 카드의 갯수
		int[] chkCard = new int[M];
		
		String[] temp2 = br.readLine().split(" ");
		
		for(int i = 0; i<M; i++) {
			chkCard[i] = Integer.parseInt(temp2[i]);
		}// 소유 여부를 확인할 카드 데이터 입력
		
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i<M; i++) {
			if(cardSet.contains(chkCard[i])) {// 만약 확인하고자 하는 숫자의 카드를 상근이가 가지고 있다면 1출력
				sb.append(1).append(" ");
			}else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
	}
	
}
