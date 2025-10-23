import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, ans;
	static int[] col;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		col = new int[N]; // 퀸이 놓인 열을 저장할 배열
		Arrays.fill(col, -1);
		ans = 0;

		queen(0);

		System.out.println(ans);
	}

	private static void queen(int row) {
		if (row == N) {
			ans++;
			return;
		}

		// 열 확인
		for (int nc = 0; nc < N; nc++) {
			boolean isOk = true;

			// 이전 행들 검사
			for (int r = 0; r < row; r++) {
				// 같은 열에 있나?
				if (col[r] == nc) {
					isOk = false;
					break;
				}

				// 대각선에 있나?
				if (Math.abs(row - r) == Math.abs(col[r] - nc)) {
					isOk = false;
					break;
				}
			}

			if (isOk) {
				col[row] = nc;
				queen(row + 1);
				col[row] = -1;
			}
		}
	}

}
