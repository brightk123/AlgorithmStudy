import java.util.LinkedList;
import java.util.Scanner;

public class 요세푸스 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> q = new LinkedList<>();

		int N = sc.nextInt();
		int K = sc.nextInt();

		// 큐에 넣기
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append('<');

		int index = 0;
		
		while (q.size() > 1) {
			index = (index + (K - 1)) % q.size();
			
			sb.append(q.remove(index)).append(", ");
		}

		// 마지막 원소 출력한 뒤 > 도 붙여준다.
		sb.append(q.poll()).append('>');
		System.out.println(sb);
	}
}
