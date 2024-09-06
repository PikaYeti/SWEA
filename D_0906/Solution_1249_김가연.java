package D_0906;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1249_김가연 {
	
	// 배열의 크기 저장해 줄 변수 선언
	static int N;
	
	// 현재 선택된 좌표가 배열 내부인지 확인하는 함수
	static boolean ifmap(int x, int y) {
		if (((0 <= x) && (x < N)) && ((0 <= y) && (y < N))) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1; test_case <= tc ; test_case ++) {
			
			// 배열 크기 저장해주기
			N = Integer.parseInt(bf.readLine());
			// 사방탐색 해주기 위한 좌표 배열 설정
			int [][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
			
			// 현재 지도 정보를 저장할 지도 배열 선언
			int [][] map = new int[N][N];
			
			// 방문했는지를 체크할 방문 배열 설정
			int [][] visit = new int [N][N];
			
			// 현재 좌표까지의 최소값을 저장할 배열 설정
			int [][] answer = new int [N][N];
			
			// 현재 지도 정보를 저장
			for (int i = 0 ; i < N ; i++) {
				String str = new String(bf.readLine());
				for (int j = 0 ; j < N ; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			// 우선순위 큐 선언 -> 복구시간을 기준으로 설정
			PriorityQueue<int []> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
			
			// 현재 시작 좌표 (0, 0)과 현재 좌표의 값(0)을 큐에 넣어서 시작
			q.add(new int[] {0, 0, map[0][0]});
			
			// 큐가 빌 때까지
			while(!q.isEmpty()) {
				
				int [] r = q.poll();
				// 정답 배열에 지난 경로 작업시간 + 현재 위치 작업시간을 더한 값을 넣기
				answer[r[0]][r[1]] = r[2];
				// 방문처리 해주기
				visit[r[0]][r[1]] = 1;
				
				// 현재 좌표에서 사방 탐색 돌려주기
				for (int [] d : dir) {
					int dx = r[0] + d[0];
					int dy = r[1] + d[1];
					
					// 만약 그 위치가 배열을 벗어나지 않고, 방문하지 않은 위치라면
					if ((ifmap(dx, dy)) && (visit[dx][dy] != 1)) {
						// 다음 좌표값과 현재 좌표값에 저장되어 있는 경로값 + 다음 좌표의 작업시간을 넣기
						q.add(new int[] {dx, dy, r[2] + map[dx][dy]});
					}
				}
			}
			// 테스트 케이스와 정답배열의 도착 위치 ([N-1][N-1]) 출력해주기
			System.out.printf("#%d %d \n", test_case, answer[N-1][N-1]);
			
		}

	}

}
