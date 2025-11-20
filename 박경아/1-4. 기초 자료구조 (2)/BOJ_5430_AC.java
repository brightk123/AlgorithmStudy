import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_5430_AC {
	public static void main(String[] args) throws NumberFormatException, IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int TC = 1; TC<=t; TC++) {
			
			// 1. 명령어 입력 받기
			String[] order = br.readLine().split("");
			
			// 2. 배열에 들어 있는 수의 갯수 n
			int n = Integer.parseInt(br.readLine());
			
			// 3. 배열에 들어 있는 정수 입력 받기
			// but 계산의 편의성을 위해 리스트에 저장하기
			
			List<Integer> numbers = new ArrayList<>();
			
			String[] temp = br.readLine().split("");
			
			for(int i = 0; i<temp.length; i++) {
				
				String toChangeNum = "";
				
				if(temp[i].equals("[") || temp[i].equals("]") || temp[i].equals(",")) {
					// StringToken이 숫자가 아닐 경우 넘어가기
					continue;
				}
				
				while(!temp[i].equals(",") && !temp[i].equals("[") && !temp[i].equals("]")) {
					// 숫자로 시작해서 쉼표가 나올 때까지 숫자 토큰 저장
					toChangeNum = toChangeNum + temp[i];
					i++;
				}
				
				numbers.add(Integer.parseInt(toChangeNum));
				
			}// 수열을 리스트로 입력 받기
			
			boolean chkError = false;
			
			int countReverse = 0;
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("[");
			
			for(int i = 0; i<order.length; i++) {
				if(order[i].equals("R")) {
					// 배열을 뒤집어야하는 횟수만 저장
					countReverse++;
				}else if(order[i].equals("D")) {
					
					if(numbers.isEmpty()) {
						// 숫자 배열에 숫자가 하나도 없는데 D를 사용하면 에러 출력
						chkError = true;
						break;
					}
					
					if(countReverse>0 && countReverse%2==1) {
						//뒤집힌 상태라면 값 뒤에서 빼기
						numbers.remove(numbers.size()-1);
					}else if(countReverse>=0 && countReverse%2==0 )
						//뒤집힌 상태가 아니면 값 앞에서 빼기
						numbers.remove(0);
				}
			}
			
			if(countReverse%2==1) {
				Collections.reverse(numbers);
			}
			
			if(chkError) {
				System.out.println("error");
			}else {
				
				if(numbers.isEmpty()) {
					System.out.println("[]");
				}else {
					for(int i = 0; i<numbers.size()-1; i++) {
						sb.append(numbers.get(i)).append(",");
					}
					
					sb.append(numbers.get(numbers.size()-1)).append("]");
					System.out.println(sb);
				}
			}
		}// 테스트 케이스
	}// 메인
}
