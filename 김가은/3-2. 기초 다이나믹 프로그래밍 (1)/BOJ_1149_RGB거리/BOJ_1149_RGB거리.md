# ㅁ

![RGB.png](RGB.png)

```java
import java.util.Scanner;

public class BOJ_1149_RGB거리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] arr = new int[n][3];

		arr[0][0] = sc.nextInt();
		arr[0][1] = sc.nextInt();
		arr[0][2] = sc.nextInt();

		for (int i = 1; i < n; i++) {
			int r = sc.nextInt();
			int g = sc.nextInt();
			int b = sc.nextInt();

			arr[i][0] = r + Math.min(arr[i - 1][1], arr[i - 1][2]);
			arr[i][1] = g + Math.min(arr[i - 1][0], arr[i - 1][2]);
			arr[i][2] = b + Math.min(arr[i - 1][1], arr[i - 1][0]);
		}

		System.out.println(Math.min(arr[n - 1][0], Math.min(arr[n - 1][1], arr[n - 1][2])));

	}
}
```