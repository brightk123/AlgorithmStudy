import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 백준_5430_AC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String arrStr = br.readLine();
			
			Deque<Integer> deque = parseArray(arrStr, n);
			
			String result = executeFunctions(p, deque);
			
			sb.append(result).append('\n');
		}
		
		System.out.println(sb.toString());
	}
	
	private static Deque<Integer> parseArray(String arrStr, int n) {
		Deque<Integer> deque = new ArrayDeque<>();
		
		if (n > 0) {
			String numbers = arrStr.substring(1, arrStr.length() - 1);
			String[] parts = numbers.split(",");
			
			for (String part : parts) {
				deque.addLast(Integer.parseInt(part));
			}
		}
		
		return deque;
	}
	
	private static String executeFunctions(String p, Deque<Integer> deque) {
		boolean isReversed = false;
		
		for (char func : p.toCharArray()) {
			if (func == 'R') {
				isReversed = !isReversed;
			} else if (func == 'D') {
				if (deque.isEmpty()) {
					return "error";
				}
			
				if (isReversed) {
					deque.removeLast();
				} else {
					deque.removeFirst();
				}
			}
		}
		
		return formatResult(deque, isReversed);
	}
	
	private static String formatResult(Deque<Integer> deque, boolean isReversed) {
		StringBuilder sb = new StringBuilder("[");
		
		int size = deque.size();
		
		for (int i = 0; i < size; i++) {
			int num;
			if (isReversed) {
				num = deque.removeLast();
			} else {
				num = deque.removeFirst();
			}
			
			sb.append(num);
			
			if (i < size - 1) {
				sb.append(",");
			}
		}
		
		sb.append("]");
		return sb.toString();
	}
}
