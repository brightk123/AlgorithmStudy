import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_15711_환상의짝꿍 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		// 소수구하기
		
		// 에라토스테네스의 체 알고리즘 (소수구하기)
		// 최대 입력 범위 (1 ~ 2*10^12까지)
		
		Long MAX = 2000000000000L;
		HashMap<Long, Boolean> isPrime = new HashMap<>();
		
		// 소수이면 True, 아니면 False
		isPrime.put((long) 0, false);
		isPrime.put(1L, false);

		// 에라토스테네스의 체로 소수 구하기

		//1. 모든 수가 소수라고 가정
		for (Long i = 2L; i <= MAX; i++) {
			isPrime.put(i,true);
		}

		//2. 2부터 시작해서 i*i가 MAX보다 작을 때까지, i가 소수일 경우 i의 배수를 모두 false로 설정
		for (Long i = 2L; i * i <= MAX; i++) {
			if (isPrime.get(i)) {
				for (Long j = (Long) (i * i); j <= MAX; j += i) {
					// 소수가 아닐 경우 
					isPrime.replace(j, true, false);
				}
			}
		}
		
		
		
		for(int TC = 1; TC<=t; TC++) {
			
			boolean chkPrint = false;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			Long a = Long.parseLong(st.nextToken());
			Long b = Long.parseLong(st.nextToken());
			Long sum = a + b;
			
			for(Long i = 2L; i<=sum/2; i++) {
				Long fstNum = i;
				Long secNum = sum - i;
				
				if(isPrime.get(fstNum) && isPrime.get(secNum)) {
					System.out.println("YES");
					chkPrint = true;
					break;
				}
			}
			
			if(!chkPrint) {
				System.out.println("NO");
			}
			
		}// 테스트 케이스
	}
}
