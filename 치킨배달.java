import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	// 치킨집의 좌표 저장할 리스트 선언
	static ArrayList<int[]> chi;
	
	// 집의 좌표 저장할 리스트 선언
	static ArrayList<int[]> home;
	
	// 조합 선택 후 최종 최소 거리 저장해 줄 변수 선언
	static int min = -1;
	
	static int m;
	
	static void combination(boolean [] visit, int depth, int end, int choose) {
		
		if ((choose == m) || (depth == end)) {
			if ((depth == end) && (choose < m)) {
				return;
			}
			// 거리 저장해줄 변수 선언 후 초기화
			int dis = 0;
			// 현재 거리 저장해줄 변수 선언
			int nowdis = 0;
			// 현재 폐업 선택에서 최솟값 저장
			int nowmin = 0;
						
			for (int i = 0 ; i < home.size() ; i++) {
				// 집 좌표 꺼내오기
				int [] h = home.get(i);
				
				// 거리 저장해줄 변수 초기화
				dis = 0;
				for (int j = 0 ; j < end ; j++) {
					
					// 현재 치킨집과의 거리 저장해 줄 변수 초기화
					nowdis = 0;
					// 만약 현재 치킨집이 폐업하지 않았다면
					if (visit[j]) {
						// 치킨집 좌표 꺼내오기
						int [] c = chi.get(j);
						nowdis = Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]);
						
						// 만약 거리에 값이 저장되어 있지 않다면 현재 거리 저장
						if (dis == 0) {
							dis = nowdis;
						}
						
						// 만약 저장된 치킨집과의 거리보다 현재 거리가 짧다면 현재 거리 저장하기
						if (dis > nowdis) {
							dis = nowdis;
						}
					}
				}
				// 현재 최소 거리의 합에 방금 구한 치킨집과의 거리 더해주기
				nowmin += dis;
                
                if ((nowmin > min) && (min != -1)) {
					return;
				}
			}
			
			// 만약 최종 최소 거리가 설정되지 않은 상태라면 거리 저장
			if (min == -1) {
				min = nowmin;
			}
			
			// 최종 최소 거리보다 현재 최소 거리가 작다면 거리 저장
			if (min > nowmin) {
				min = nowmin;
			}
			
			return;
		}
		
			visit[depth] = true;
			combination(visit, depth + 1, end, choose + 1);
			
			visit[depth] = false;
			combination(visit, depth + 1, end, choose);
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// 도시의 크기
		int n = Integer.parseInt(st.nextToken());
		// 도시 정보 받아줄 배열 선언
		int [][] city = new int [n][n];
		// 도시의 남아야 치킨집의 수 
		m = Integer.parseInt(st.nextToken());
		
		// 선언한 리스트들 초기화 시켜주기
		home = new ArrayList<>();
		chi = new ArrayList<>();
		
		// 도시 정보 저장하기
		for (int i = 0 ; i < n ; i++) {
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			for (int j = 0 ; j < n ; j++) {
				city[i][j] = Integer.parseInt(st1.nextToken());
				// 만약 집 좌표가 나타나면 좌표를 홈 리스트에 추가
				if (city[i][j] == 1) {
					home.add(new int[] {i, j});
					
				// 만약 치킨집의 좌표가 나타나면 좌표를 치킨집 리스트에 추가
				} else if (city[i][j] == 2)  {
					chi.add(new int[] {i, j});
				}
			}
		}
		
		// 치킨집의 갯수 end 변수에 저장하기
		int end = chi.size();
		
		// 조합에서 몇번째 치킨집을 방문했는지 체크할 방문 배열 boolean으로 생성
		boolean [] visit = new boolean[end];
		
		// 몇번째 치킨집인지를 확인할 치킨집의 인덱스가 담긴 chicken 배열 생성 후 인덱스로 초기화
		int [] chicken = new int [end];
		for (int i = 0 ; i < end ; i++) {
			chicken[i] = i;
		}
		
		// 최종 최소 거리 값 변수 초기화
		min = -1;
		
		combination(visit, 0, end, 0);
		
		System.out.println(min);
	}

}
