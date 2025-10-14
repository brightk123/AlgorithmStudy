import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point o) {
		if (this.y != o.y) {
			return this.y - o.y;
		}
		
		return this.x - o.x;
	}
}

public class 백준_11651_좌표정렬하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Point[] points = new Point[N];
		
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			points[i] = new Point(x, y);
		}
		
		Arrays.sort(points);
		
		StringBuilder sb = new StringBuilder();
		for (Point p : points) {
			sb.append(p.x).append(" ").append(p.y).append('\n');
		}
		
		System.out.println(sb);
	}
}
