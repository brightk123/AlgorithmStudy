import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9095_123더하기 {
	public static void main(String[] args) throws NumberFormatException, IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int t = Integer.parseInt(br.readLine());
		
		int[] DP = new int[12];
		
		DP[1] = 1;
		DP[2] = 2;
		DP[3] = 4;
		
		for(int i = 4; i<=11; i++) {
			DP[i] = DP[i-1] + DP[i-2] + DP[i-3];
		}
		
		for(int TC = 1; TC<=t; TC++) {
			
			int n = Integer.parseInt(br.readLine()); // 1,2,3의 합으로 나타낼 숫자
			System.out.println(DP[n]);
		}
	}// 메인
}
