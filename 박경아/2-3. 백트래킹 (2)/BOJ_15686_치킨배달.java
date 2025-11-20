import java.io.*;
import java.util.*;

public class BOJ_15686_치킨배달 {
	
	static int N; // 도시의 크기
	static int M; // 폐업시키지 않을 치킨집의 갯수
	
	static int[][] city;
	
	// 집집마다 치킨거리를 저장할 리스트 생성
	static List<Integer[]> home;
	
	// 각 집의 좌표를 저장할 리스트 생성
	static List<Integer[]> homeRC;
	
	// 각 치킨집의 좌표를 저장할 리스트 생성
	static List<Integer[]> chickenRC;
	
	static int chicken; // 현재 존재하는 전체 치킨집 갯수
	static int calChickenLength; // 도시의 치킨 거리 합
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N*N 크기의 도시
		// 도시의 각 칸은 빈 칸, 치킨집, 집 중 하나
		// 0 : 빈 칸, 1: 집, 2 : 치킨집
		
		// 각 도시의 칸은 (r,c) 좌표로 표현
		// r과 c는 1부터 시작
		// 첫번째칸 => (1,1)
		
		// 치킨 거리 : 집과 가장 가까운 치킨집 사이의 거리
		// 도시의 치킨 거리 : 모든 집의 치킨 거리의 합
		
		// 핵심 아이디어
		// 각 집마다 인근 치킨집에 대한 치킨 거리를 구함
		// 그리고 그 중에서 M개의 치킨집을 선정해서 치킨거리 합을 조합
		// 최종적으로 최소 치킨 거리 합을 구함
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 도시의 크기
		M = Integer.parseInt(st.nextToken()); // 수익을 많이 낼 수 있는 치킨집의 최대 갯수
		
		city = new int[N+1][N+1]; // 도시 맵 생성
		// 1~N까지의 r,c 좌표 설정을 위해서 N+1 크기의 배열 생성
		
		// 집집마다 치킨거리를 저장할 리스트 생성
		home = new ArrayList<>();
		
		// 각 집의 좌표를 저장할 리스트 생성
		homeRC = new ArrayList<>();
		
		// 각 치킨집의 좌표를 저장할 리스트 생성
		chickenRC = new ArrayList<>();
		
		for(int i = 1; i<N+1; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			for(int j = 1; j<N+1; j++) {
				city[i][j]= Integer.parseInt(temp.nextToken());		
				if(city[i][j]==1) {
					// 도시 내 집 좌표 찾기
					Integer[] rc = {i,j};
					homeRC.add(rc);
				}else if(city[i][j]==2) {
					Integer[] rc = {i,j};
					chickenRC.add(rc);
				}
			}
		}
		
		// 집 갯수를 나타내는 변수
		int homes = 0;
		
		// 치킨집 갯수
		chicken = chickenRC.size();
		
		// 각 집마다 인근 치킨집에 대한 치킨 거리를 구함
		while(homes<homeRC.size()) {
			Integer[] chickenLength = new Integer[chicken];
			
			int r = homeRC.get(homes)[0];
			int c = homeRC.get(homes)[1];
			
			for(int i =0 ; i<chicken; i++) {
				int cr = chickenRC.get(i)[0];
				int cc = chickenRC.get(i)[1];
				
				int calLength = Math.abs(r-cr)+Math.abs(c-cc);
				chickenLength[i] = calLength;
			}
			
			// 계산한 집 별 치킨 거리 저장
			home.add(chickenLength);
			homes++;
		}
		
		// 도시별 치킨 거리 구하기
		// 폐업시키지 않을 치킨집의 갯수가 M일 때
		calChickenLength = Integer.MAX_VALUE;
		List<Integer> selected = new ArrayList<>(); // 선택할 M개의 치킨집을 담을 리스트
		choose(0, selected);
		
		System.out.println(calChickenLength);
		
	}

	private static void choose(int start, List<Integer> selected) {
		
		// M개의 치킨집을 선택했다면 그에 대한 치킨 거리 합을 계산
		if(selected.size()==M) {
			int totalDistance = calculateChickenDistance(selected);
			calChickenLength = Math.min(calChickenLength, totalDistance);
			return;
		}
		
		// 치킨집을 선택하는 과정
		for(int i = start; i<chicken; i++) {
			selected.add(i);
			choose(i+1, selected); // 다음 치킨집 선택
			selected.remove(selected.size()-1); // 백트레킹
		}
		
	}

	private static int calculateChickenDistance(List<Integer> selected) {
		int totalDistance = 0;
		
		// 각 집에 대해 가장 가까운 치킨집과의 거리 합산
		for(Integer[] h : home) {
			int minDistance = Integer.MAX_VALUE;
			for(Integer s : selected) {
				minDistance = Math.min(minDistance, h[s]);
			}
			totalDistance += minDistance;
		}
		
		return totalDistance;
	}
}