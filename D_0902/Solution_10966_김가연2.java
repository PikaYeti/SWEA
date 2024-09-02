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
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			char [][] water = new char [n][m];
			
			Queue<int[]> wl = new LinkedList<>();
			
			for (int i = 0 ; i < n ; i ++) {
				String st1 = new String(bf.readLine());
				for (int j = 0 ; j < m ; j++) {
					water[i][j] = st1.charAt(j);
					if (water[i][j] == 'W') {
						wl.add(new int[] {i, j});
					}
				}
			}
			Queue<int []> findw;
			int [][] visit;
			int [][] answer = new int [n][m];
			
			int [][] dir = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
			int sum = 0;
			
			while(!wl.isEmpty()) {
				
				findw = new LinkedList<>();
				visit = new int [n][m];
				
				int [] w = wl.poll();
				
				visit[w[0]][w[1]] = 1;
				findw.add(new int[] {w[0], w[1], 0});
				
				while(!findw.isEmpty()) {
					
					int [] t = findw.poll();
					for (int [] d : dir) {
						int dx = t[0] + d[0];
						int dy = t[1] + d[1];
						if(ifmap(dx, dy, n, m)) {
							if ((water[dx][dy] == 'L') && (visit[dx][dy] != 1)) {
								
							}
						}
					}
				}
			}
			
			System.out.printf("#%d %d \n", test_case, sum);
		}

	}

}