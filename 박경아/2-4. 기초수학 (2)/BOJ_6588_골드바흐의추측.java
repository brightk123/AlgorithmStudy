import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_6588_골드바흐의추측 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		// 에라토스테네스의 체 알고리즘 (소수구하기)
		// 최대 입력 범위 (4 ~ 10^6까지)
        int MAX = 1000000;
        boolean[] isPrime = new boolean[MAX + 1];
        
        // 0과 1은 소수가 아니므로 false로 설정
        isPrime[0] = isPrime[1] = false;
        
        // 에라토스테네스의 체로 소수 구하기
        
        //1. 모든 수가 소수라고 가정
        for (int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }

        //2. 2부터 시작해서 i*i가 MAX보다 작을 때까지, i가 소수일 경우 i의 배수를 모두 false로 설정
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
		
        int num = Integer.MIN_VALUE;
		while(num!=0) {
			num = Integer.parseInt(br.readLine()); // 숫자 입력 받기
			
			// 가능한 경우 8 = 3 + 5 형식으로 출력
			// 불가능한 경우 "Goldbach's conjecture is wrong" 출력
			
			int minNum = 0; // 작은 홀수 소수
			int maxNum = 0; // 큰 홀수 소수
			
			// 출력확인 변수
			boolean chkPrint = false;
			
			for(int k = 2; k<=num/2; k++) {
				minNum = k;
				maxNum = num - minNum;
				if(isPrime[minNum] && isPrime[maxNum]) {
					System.out.println(num + " = " + minNum + " + " + maxNum);
					chkPrint = true;
					break;
				}
			}
			
			
			if(!chkPrint && num != 0) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}
	}
}
