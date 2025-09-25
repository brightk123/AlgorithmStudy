import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_수정렬하기3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		// 시간초과 나서 원본 배열 저장하지않고 각 숫자가 몇번 나왔는지 빈도만 센다
		int count[] = new int[10001];
		
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			count[x]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < 10001; i++) {
			for (int j = 0; j < count[i]; j++) {
				sb.append(i).append('\n');
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
