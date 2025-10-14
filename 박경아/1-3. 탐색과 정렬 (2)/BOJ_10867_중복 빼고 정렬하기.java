import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		TreeSet<Integer> nums = new TreeSet<>();
		
		for(int i = 0; i<N; i++) {
			nums.add(sc.nextInt());
		}
		
		StringBuilder sb = new StringBuilder();
		for(Integer num : nums) {
			sb.append(num).append(" ");
		}
		
		System.out.println(sb);
	}// main 

}