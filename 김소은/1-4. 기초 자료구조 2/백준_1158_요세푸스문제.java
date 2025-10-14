import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 백준_1158_요세푸스문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		List<Integer> people = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			people.add(i);
		}
		
		List<Integer> result = new ArrayList<>();
		
		int currentIndex = 0;
		
		while (!people.isEmpty()) {
			currentIndex = (currentIndex + K - 1) % people.size();
			
			int removedPerson = people.remove(currentIndex);
			result.add(removedPerson);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i));
			if (i < result.size() - 1) {
				sb.append(", ");
			}
		}
		
		sb.append(">");
		
		System.out.println(sb.toString());
	}
}
