import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_중복빼고정렬하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Set<Integer> nums = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		
		// HashSet은 순서를 보장하지 않아서 List로 옮겨서 정렬해야 함
		List<Integer> sorted = new ArrayList<>(nums);
		
		// List 오름차순 정렬
		Collections.sort(sorted);
		
		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for (int num: sorted) {
			sb.append(num).append(" ");
		}

		System.out.println(sb.toString());
		
	}
}
