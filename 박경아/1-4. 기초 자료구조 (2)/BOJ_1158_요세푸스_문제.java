import java.util.*;


public class BOJ_1158_요세푸스_문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		List<Integer> nums = new ArrayList<>();
		
		for(int i = 1; i<=N; i++) {
			nums.add(i);
		}
		
		// 1~N번째 사람이 원을 이루며 앉아 있음 (순환)
		// 순서대로 K번째 사람을 제거
		// N명의 사람이 모두 제거될때까지 반복
		int idx = 0;
		int count = 0;
		
		System.out.print("<");
		
		for(int i = 0; i<N; i++) {
			
			if(i>=nums.size()) {
				i = i%nums.size();
			}
			
			count++;
			
			if(count == K) {
				
				int num = nums.get(i);
				nums.remove(i);
				
				if(nums.size()==0) {
					System.out.print(num);
				}else {
					System.out.print(num+", ");
				}
				
				count = 0;
				i--;
			}
			
			if(nums.size()==0) {
				break;
			}
		}
		System.out.print(">");
	}
}
