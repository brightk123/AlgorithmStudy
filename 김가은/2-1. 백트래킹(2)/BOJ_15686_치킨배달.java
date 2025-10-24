import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        List<int[]> house = new ArrayList<>();
        List<int[]> chicken = new ArrayList<>();

        // 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int val = sc.nextInt();
                if (val == 1) house.add(new int[]{i, j});
                else if (val == 2) chicken.add(new int[]{i, j});
            }
        }

        int cSize = chicken.size();
        int answer = Integer.MAX_VALUE;
        int[] comb = new int[M]; // 선택할 치킨집 인덱스

        // 조합 생성
        for (int mask = 0; mask < (1 << cSize); mask++) {
            if (Integer.bitCount(mask) == M) { // M개만 선택
                int idx = 0;
                for (int i = 0; i < cSize; i++) {
                    if ((mask & (1 << i)) != 0) comb[idx++] = i;
                }

                // 도시의 치킨 거리 계산
                int total = 0;
                for (int[] h : house) {
                    int min = Integer.MAX_VALUE;
                    for (int c : comb) {
                        int[] ck = chicken.get(c);
                        int dist = Math.abs(h[0] - ck[0]) + Math.abs(h[1] - ck[1]);
                        min = Math.min(min, dist);
                    }
                    total += min;
                }
                answer = Math.min(answer, total);
            }
        }
        System.out.println(answer);
    }
}
