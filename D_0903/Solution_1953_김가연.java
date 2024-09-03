package D_0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_김가연 {
	
	static int [][] dir;
	static int [][] map;
	static int n, m;
	
	static void ifdir(int p) {
		if (p == 1) {
			dir = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		} else if (p == 2) {
			dir = new int [][] {{1, 0}, {-1, 0}};	
		} else if (p == 3) {
			dir = new int [][] {{0, 1}, {0, -1}};	
		} else if (p == 4) {
			dir = new int [][] {{0, 1}, {-1, 0}};	
		} else if (p == 5) {
			dir = new int [][] {{0, 1}, {1, 0}};
		} else if (p == 6) {
			dir = new int [][] {{0, -1}, {1, 0}};
		} else {
			dir = new int [][] {{0, -1}, {-1, 0}};
		}
		return;
	}
	
	static boolean ifmap(int x, int y) {
		if (((0 <= x) && (x < n)) && ((0 <= y) && (y < m))) {
			return true;
		} else {
			return false;
		}
	}
	
	static boolean ifcon(int x, int y, int dx, int dy) {
		int m = map[dx][dy];
		
		if (map[dx][dy] == 0) {
			return false;
		}
		
		ifdir(m);
		
		for (int [] d : dir) {
			int nx = dx + d[0];
			int ny = dy + d[1];
			if (ifmap(nx, ny) && (map[nx][ny] != 0)) {
				if ((nx == x) && (ny == y)) {
					ifdir(map[x][y]);
					return true;
				}
			}
		}
		
		ifdir(map[x][y]);
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		// i, j, 처음위치 0 -> 다음은 + 1
		
		for (int test_case = 1 ; test_case <= tc ; test_case++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			// 지도 세로 크기
			n = Integer.parseInt(st.nextToken());
			// 지도 가로 크기
			m = Integer.parseInt(st.nextToken());
			// 지하 지도 배열 만들기 
			map = new int[n][m];
			// 맨홀 입구 표시 x, y
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			
			// 탈출 후 소요 시간
			int l = Integer.parseInt(st.nextToken());
			
			// 지도 채우기
			for (int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < m ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 방문배열 만들기
			int [][] visit = new int [n][m];
			
			Queue<int[]> inp = new LinkedList<>();
			visit[ex][ey] = 1;
			// x좌표, y좌표, 현재 좌표 파이프 모양, 시간
			inp.add(new int[] {ex, ey, map[ex][ey], 0});
			
			int cnt = 0;
			int dx = 0, dy = 0;
			
			while(!inp.isEmpty()) {
				int [] p = inp.poll();
				
				if (p[3] < l) {
					cnt ++;
				}
				
				ifdir(p[2]);
				
				for (int [] d : dir) {
					dx = p[0] + d[0];
					dy = p[1] + d[1];
					if (ifmap(dx, dy)) {
						if ((ifcon(p[0], p[1], dx, dy)) && (visit[dx][dy] != 1)) {
							visit[dx][dy] = 1;
							if ((p[3] + 1) < l) {
								inp.add(new int[] {dx, dy, map[dx][dy], p[3] + 1});
							}
						}
					}
				}
				
			}
			
			System.out.printf("#%d %d \n", test_case, cnt);
		}

	}

}
