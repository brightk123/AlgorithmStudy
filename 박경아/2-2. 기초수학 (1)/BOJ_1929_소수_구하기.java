import java.util.*;

public class BOJ_1929_소수_구하기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int fstNum = sc.nextInt();
		int lstNum = sc.nextInt();
		
		List<Integer> primeNums = new ArrayList<>();

		
		StringBuilder sb = new StringBuilder();
		
		boolean chkPrime;
		
		for(int i = 2; i<=lstNum; i++) {
			
			chkPrime = true;
			
			for(int j : primeNums) {
				
				// j가 i의 제곱근보다 클 경우 더 이상 확인할 필요 없음
				if((j*j)>i) break;
				
				if(i%j==0) {
					chkPrime = false;
					break;
				}
			}
			
			if(chkPrime) {
				primeNums.add(i);
				if(i>=fstNum) {
					sb.append(i).append("\n");
				}
			}
		}
		
		//출력
		System.out.print(sb);
	}
}
