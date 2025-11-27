import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] ropes = new int[N];

    for (int i = 0; i < N; i++) ropes[i] = sc.nextInt();

    // 오름차순 정렬 (작은 로프가 뒤에서 "가장 약한 로프" 역할을 하게 만들기 위함)
    Arrays.sort(ropes);

    long ans = 0;
    // i번째 로프를 "가장 약한 로프"로 선택한다고 가정하면
    // 사용할 수 있는 로프 개수 k = N - i (i~N-1까지)
    // 가능한 최대 무게 = ropes[i] * k
    for (int i = 0; i < N; i++) {
      long k = N - i;
      long candidate = (long) ropes[i] * k;
      if (candidate > ans) ans = candidate;
    }

    System.out.println(ans);
    sc.close();
  }
}
