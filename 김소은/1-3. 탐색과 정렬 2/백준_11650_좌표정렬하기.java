import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class 백준_11650_좌표정렬하기 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Point[] points = new Point[N];
		
		for (int i = 0; i < N; i++) {
			String[] tokens = br.readLine().split(" ");
			points[i] = new Point(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		}
		
		Arrays.sort(points, (p1, p2) -> {
			if (p1.x != p2.x) {
				return p1.x - p2.x;
			} else {
				return p1.y - p2.y;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for (Point p : points) {
			sb.append(p.x).append(" ").append(p.y).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
