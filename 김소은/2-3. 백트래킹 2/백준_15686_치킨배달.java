import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.lang.Math;

public class 백준_15686_치킨배달 {

    // 좌표 정보를 저장할 클래스 선언
    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M;
    static List<Pos> houses = new ArrayList<>(); // 모든 집의 좌표 리스트
    static List<Pos> chickens = new ArrayList<>(); // 모든 치킨집의 좌표 리스트
    
    static boolean[] selected; // 현재 조합에서 선택된 치킨집의 인덱스 여부를 저장
    static int minCityChickenDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 도시 정보를 읽고 집과 치킨집의 좌표를 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 1) { // 집
                    houses.add(new Pos(i + 1, j + 1));
                } else if (type == 2) { // 치킨집
                    chickens.add(new Pos(i + 1, j + 1));
                }
            }
        }

        // 치킨집의 개수만큼 selected 배열 초기화
        selected = new boolean[chickens.size()];

        // 조합 탐색
        combination(0, 0);

        System.out.println(minCityChickenDistance);
    }

    // DFS를 이용해 전체 치킨집 중 M개를 고르는 조합을 탐색
    // start : 현재 탐색을 시작할 chickens 리스트의 인덱스
    // count : 현재까지 선택된 치킨집의 개수
    static void combination(int start, int count) {
        // M개의 치킨집을 모두 선택한 경우
        if (count == M) {
            // 현재 조합에서의 도시 치킨 거리를 계산
            calculateCityChickenDistance();
            return;
        }

        // 남은 치킨집을 순회하며 다음 치킨집을 선택
        for (int i = start; i < chickens.size(); i++) {
            selected[i] = true;
            combination(i + 1, count + 1);
            
            selected[i] = false;
        }
    }

    // 현재 선택된 M개의 치킨집을 기준으로 도시의 치킨 거리를 계산
    static void calculateCityChickenDistance() {
        int totalCityDistance = 0;

        // 모든 집에 대해 반복
        for (Pos house : houses) {
            int minChickenDistance = Integer.MAX_VALUE;
            
            // 현재 집과 선택된 치킨집들 사이의 최소 거리를 찾음
            for (int i = 0; i < chickens.size(); i++) {
                // 선택된 치킨집만 고려
                if (selected[i]) {
                    Pos chicken = chickens.get(i);
                    // 맨해튼 거리 계산: |r1-r2| + |c1-c2|
                    int distance = Math.abs(house.r - chicken.r) + Math.abs(house.c - chicken.c);
                    minChickenDistance = Math.min(minChickenDistance, distance);
                }
            }
            
            // 이 집의 치킨 거리를 도시의 총 치킨 거리에 합산
            totalCityDistance += minChickenDistance;
        }

        // 최소 도시 치킨 거리 갱신
        minCityChickenDistance = Math.min(minCityChickenDistance, totalCityDistance);
    }
}
