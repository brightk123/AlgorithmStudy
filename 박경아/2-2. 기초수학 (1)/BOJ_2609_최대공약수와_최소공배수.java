import java.util.Scanner;

public class BOJ_2609_최대공약수와_최소공배수 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int fstNum = sc.nextInt();
		int lstNum = sc.nextInt();
		
		int minNum = Math.min(fstNum, lstNum);
		int maxNum = Math.max(fstNum, lstNum);
		
		// 1. 최대공약수 구하기
		for(int i = minNum; i>=1; i--) {
			// 두 수 중 가장 큰 수부터 공약수를 구하기 시작
			if(fstNum%i==0 && lstNum%i==0) {
				System.out.println(i);
				break;
			}
		}
		
		// 2. 최소공배수 구하기
		outer :
		for(int i = 1; i<=minNum; i++) {
			// 큰 수의 최소공배수는 1~minNum을 곱한 값 중 나옴
			int chkNumMax = i*maxNum;
			
			for(int j = 1; j<=maxNum; j++) {
				// 작은 수의 최소공배수는 1~maxNum을 곱한 값 중 나옴
				// 두 수의 최소공배수는 최대 minNum * maxNum임
				int chkNumMin = j*minNum;
				
				if(chkNumMax==chkNumMin) {
					System.out.println(chkNumMax);
					break outer;
				}
				
			}
		}
	}
}