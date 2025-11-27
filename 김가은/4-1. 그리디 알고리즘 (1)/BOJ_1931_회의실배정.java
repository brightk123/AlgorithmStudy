import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1931_회의실배정 {

	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[][] meetings = new int[N][2];

    for (int i = 0; i < N; i++) {
      meetings[i][0] = sc.nextInt(); // start
      meetings[i][1] = sc.nextInt(); // end
    }



	/*
	초기 lastEnd = 0으로 두고 한 줄씩 따라가면

		(1,4) : 1 >= 0 이므로 선택, lastEnd = 4

		(3,5) : 3 < 4 이므로 스킵

		(0,6) : 0 < 4 이므로 스킵

		(5,7) : 5 >= 4 이므로 선택, lastEnd = 7

		(3,8) : 3 < 7 이므로 스킵

		(5,9) : 5 < 7 이므로 스킵

		(6,10): 6 < 7 이므로 스킵

		(8,11): 8 >= 7 이므로 선택, lastEnd = 11

		(8,12): 8 < 11 이므로 스킵

		(2,13): 2 < 11 이므로 스킵

		(12,14): 12 >= 11 이므로 선택, lastEnd = 14

		그래서 “되는(선택되는) 회의”는 이 4개입니다.
		(1,4), (5,7), (8,11), (12,14)
	 */
	// 최대 회의 수 탐색에 앞서, 회의가 끝나는 시간 기준으로 오름차순 정렬해줍니다. 
	// 만약, 끝나는 시간이 동일하다면 시작 시간이 빠른순(오름차순)으로 정렬합니다

    Arrays.sort(meetings, (a, b) -> {
      if (a[1] == b[1]) return a[0] - b[0]; // end 같으면 start 오름차순
      return a[1] - b[1];                   // end 오름차순
    });

    int count = 0;
    int lastEnd = 0;

    for (int i = 0; i < N; i++) {
      if (meetings[i][0] >= lastEnd) {
        count++;
        lastEnd = meetings[i][1];
      }
    }

    System.out.println(count);\
  }
}
