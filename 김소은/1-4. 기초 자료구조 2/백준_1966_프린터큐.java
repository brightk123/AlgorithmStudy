//풀이시간:
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_1966_프린터큐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 수

        for (int tc = 0; tc < T; tc++) {
            int N = sc.nextInt(); // 문서 수
            int M = sc.nextInt(); // 궁금한 문서의 위치 (인덱스)

            int[] priorities = new int[N]; // 각 문서의 중요도를 저장할 배열
            Queue<Integer> queue = new LinkedList<>(); // 문서의 인덱스를 저장할 큐

            // 문서들의 중요도를 입력받고 큐에 인덱스를 저장
            for (int i = 0; i < N; i++) {
                priorities[i] = sc.nextInt(); // i번째 문서의 중요도 저장
                queue.offer(i); // 문서의 위치(인덱스)를 큐에 추가
            }

            int count = 0; // 몇 번째로 인쇄되는지

            // 큐가 빌 때까지 반복
            while (!queue.isEmpty()) {
                int current = queue.poll(); // 큐에서 문서 하나 꺼내기
                boolean hasHigher = false; // 더 높은 중요도를 가진 문서가 있는지 여부

                // 현재 문서보다 높은 중요도를 가진 문서가 큐에 있는지 확인
                for (int idx : queue) {
                    if (priorities[idx] > priorities[current]) {
                        hasHigher = true; // 더 높은 중요도 문서있음
                        break; // 확인했으므로 반복 종료
                    }
                }

                if (hasHigher) {
                    // 현재 문서보다 더 중요한 문서가 있다면, 현재 문서를 다시 큐 뒤로 보냄
                    queue.offer(current);
                } else {
                    // 그렇지 않으면, 현재 문서를 인쇄
                    count++; // 인쇄된 문서 수 증가

                    if (current == M) {
                        System.out.println(count);
                        break;
                    }
                }
            }
        }
    }
}
