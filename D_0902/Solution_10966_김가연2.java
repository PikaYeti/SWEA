package D_0902;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_10966_김가연2 {
	
	static boolean ifmap(int x, int y, int n, int m) {
		if (((0 <= x) && (x < n)) && ((0 <= y) && (y < m))) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			// 배열의 가로, 세로 길이와 지도의 정보를 담기 위한 변수 설정
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			char [][] water = new char [n][m];
			
			// 방문 처리와 방문 좌표를 넣을 큐를 선언
			int [][] visit = new int [n][m];
			Queue<int[]> wl = new LinkedList<>();
			
			// 지도의 정보를 담으며 만약 물 위치가 되었을 때 큐에 삽입
			for (int i = 0 ; i < n ; i ++) {
				String st1 = new String(bf.readLine());
				for (int j = 0 ; j < m ; j++) {
					water[i][j] = st1.charAt(j);
					if (water[i][j] == 'W') {
						wl.add(new int[] {i, j, 0});
						// 미리 방문처리 해주기
						visit[i][j] = 1;
					}
				}
			}

			// 정답 배열 선언
			int [][] answer = new int [n][m];
			
			// 상, 하, 좌, 우로 갈 수 있으므로 방향배열 설정
			int [][] dir = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
			int sum = 0;
			
			// 큐가 빌 때까지 실행
			// 처음 큐에 들어간 물의 주변 좌표를 한바퀴 돈다 -> 1 고정
			while(!wl.isEmpty()) {
				
				// 큐에서 좌표 빼주기
				int [] w = wl.poll();
				
				// 사방탐색 돌리기
				for (int [] d : dir) {
					int dx = w[0] + d[0];
					int dy = w[1] + d[1];
					// 만약 지도 내부이고
					if (ifmap(dx, dy, n, m)) {
						// 땅 위치이고 방문하지 않은 위치라면
						if ((water[dx][dy] == 'L') && (visit[dx][dy] != 1)) {
							// 현재 좌표가 물에서부터 가지고 있는 거리 값의 + 1을 해준다
							answer[dx][dy] = w[2] + 1;
							// 방문체크
							visit[dx][dy] = 1;
							// 좌표값, 거리값을 넣고 다시 큐에 넣어주기
							wl.add(new int[] {dx, dy, w[2] + 1});
						}
					}
				}
			}
			
			// 정답 전부 더해주기
			for (int i = 0 ; i < n ; i ++) {
				for (int j = 0 ; j < m ; j++) {
					sum += answer[i][j];
				}
			}
			
			// 출력
			System.out.printf("#%d %d \n", test_case, sum);
		}

	}

}