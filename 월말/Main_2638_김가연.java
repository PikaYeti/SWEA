package W_10_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2638

public class Main_2638_김가연 {
	
	static int [][] dir;
	static int [][] che;
	static int n;
	static int m;
	
	static boolean ifmap(int x, int y) {
		
		if ((0 <= x) && (x < n) && (0 <= y) && (y < m)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	static void hole(int x, int y) {
		
		if (che[x][y] == 0) {
			che[x][y] = 2;
		}
		
		for (int [] d : dir) {
			
			int dx = d[0] + x;
			int dy = d[1] + y;
			
			if (ifmap(dx, dy) && (che[dx][dy] == 0)) {
				che[dx][dy] = 2;
				hole(dx, dy);
			}
			
		}
		
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		che = new int [n][m];
		dir = new int [][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		
		Queue<int []> no = new LinkedList<>();
		// 공기 : 2 / 접촉 X 공기 : 0
		Queue<int []> q = new LinkedList<>();
		
		for (int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0 ; j < m ; j ++) {
				che[i][j] = Integer.parseInt(st.nextToken());
				
				if (che[i][j] == 1) {
					no.add(new int[] {i, j, 1});
				}
			}
		}

		
		int [][] visit = new int [n][m];
		
		// 바깥 공기 부분 찾으러 가기
		che[0][0] = 2;
		q.add(new int[] {0, 0});
		
		while(!q.isEmpty()) {
			
			int [] qa = q.poll();
			
			for (int [] d : dir) {
				
				int dx = d[0] + qa[0];
				int dy = d[1] + qa[1];
				
				if (ifmap(dx, dy) && (che[dx][dy] == 0)) {
					che[dx][dy] = 2;
					q.add(new int[] {dx, dy});
				}
				
			}
			
		}
		
		while(!no.isEmpty()) {
			
			int [] ciz = no.poll();
			int acnt = 0;
			int bcnt = 0;
			
			// 치즈 사방 탐색 -> 공기와 맞닿아 있는 부분 구하기
			for (int [] d : dir) {
				
				int dx = d[0] + ciz[0];
				int dy = d[1] + ciz[1];
				
				if (ifmap(dx, dy)) {
					
					if (che[dx][dy] == 2) {
						acnt ++;
					} else if (che[dx][dy] == 0) {
						bcnt ++;
					}
					
				}
			}
			
			if (acnt )
			
		}
		
		
		if (che[i][j] == 1) {
			
			int cnt = 0;
			for (int [] d : dir) {
				
				int dx = d[0] + i;
				int dy = d[1] + j;
				
				if (ifmap(dx, dy) && (che[dx][dy] == 2)) {
					cnt = cnt ++;
				}
				
				if (cnt == 2) {
					
					che[i][j] = 2;
					
					for (int [] d2 : dir) {
						
						int dx2 = d2[0] + i;
						int dy2 = d2[1] + j;
						
						if (ifmap(dx2, dy2) && (che[dx][dy] == 0)) {
							hole(dx, dy);
						}
						
					}
					
					break;
				}
			}
			
			if (cnt < 2) {
				no.add(new int [] {i, j, 1});
			}
			
		}
		
//		for (int i = 0 ; i < n ; i++) {
//			System.out.println(Arrays.toString(che[i]));
//		}

	}

}
