package D_0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

import java.util.StringTokenizer;

public class Solution_2105_김가연 {
	
	// 대각선 탐색 할 방향 배열
	static int [][] dir = new int [][] {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
	
	// 배열 크기 저장할 변수
	static int n = 0; 
	
	// 디저트 카페 위치 저장할 변수
	static int [][] desert;
	
	// 정답 찾기 위해 값 저장할 변수 선언
	static int max;
	
	
	// 배열 내부인지 확인하는 함수
	static boolean ifdesert(int x, int y) {
		if (((0 <= x) && (x < n)) && ((0 <= y) && (y < n))) {
			return true;
		} else {
			return false;
		}

	}
	
	
	static void tour(int [] visit, int x, int y, Deque<Integer> road, int i, int j, int k) {
		
		// 만약 마름모가 만들어지지 않는다면 그대로 리턴
		if ((visit[0] < visit[2]) || (visit[1] < visit[3])) {
			return;
		}
		
		// 여러번 꺾여 마름모가 되지 않는걸 방지하기 위해 전에 탐색했던 방향 + 아직 탐색하지 않은 방향만 탐색하도록 k부터 시작
		for (int t = k ; t < 4 ; t++) {
			int dx = x + dir[t][0];
			int dy = y + dir[t][1];
			
			// 만약 3번 꺾어 마름모 모양이 되었고 다음 좌표가 시작 좌표라면 마름모가 완성되기 때문에 다음 좌표 확인
			if (t == 3) {
				// 만약 시작 좌표에 도착하여 마름모가 완성 되었다면 큐 사이즈를 max 값으로 저장
				if ((dx == i) && (dy == j)) {
					if (max == -1) {
						max = road.size();
					}
					
					if (max < (road.size())) {
						max = road.size();
					}
					}
			}
			
			// 만약 좌표가 배열 내부이고
			if (ifdesert(dx, dy)) {
				
				// 경로에 담긴 디저트 카페 번호가 아니라면
				if (!road.contains(desert[dx][dy])) {
					
					// 큐에 카페 번호 저장하기
					road.addLast(desert[dx][dy]);
					
					// 이동향 방향 번호에 + 1
					visit[t] += 1;
					
					// 그대로 다음 재귀로 넘겨주기
					tour(visit, dx, dy, road, i, j, t);
					
					// 다음 for문에 값 넘기기 위해 더했던 값과 큐에 넣었던 값 다시 빼주기
					visit[t] -= 1;
					road.pollLast();			
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			// 카페 정보 담을 배열 설정하기
			n = Integer.parseInt(bf.readLine());
			desert  = new int[n][n];
			
			for (int i = 0 ; i < n ; i ++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < n ; j++) {
					desert[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = -1;
			
			int [] cidr = new int[4];
			
			// 어차피 y좌표 맨 끝은 마름모가 이루어지지 못하고 x좌표 맨 아래는 위에서 탐색해주므로 제외하고 for문 돌리기
			for (int i = 0 ; i < n - 1 ; i ++) {
				for (int j = 1 ; j < n - 1 ; j ++) {
					
					// 좌표가 달라질때마다 큐 새로 생성해주기
					// 맨 뒤에 원소를 넣고 빼기 위해 deque로 설정하기 -> 스택 안쓴 이유 : 스택쓸거면 데큐쓰라고 해성,,
					Deque<Integer> road = new ArrayDeque<>();
					road.push(desert[i][j]);
					tour(cidr, i, j, road, i , j, 0);
				}
			}
			
			// 만약 최대 큐 사이즈가 3이하라면 마름모가 이루어지지 못한것이므로 -1 출력해주기
			if (max <= 2) {
				System.out.printf("#%d -1 \n", test_case);
			
			// 테케값과 max값 출력해주기
			} else {
				System.out.printf("#%d %d \n", test_case, max);
			}
		}
		
	}

}
