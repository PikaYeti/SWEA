package D_0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4485_김가연 {
	
	static boolean ifcave(int x, int y, int n) {
		if (((0 <= x) && (x < n)) && ((0 <= y) && (y < n))) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = 1;
		
		while(true) {
			
			int n = Integer.parseInt(bf.readLine());
			
			if (n == 0) {
				break;
			}
			
			int [][] cave = new int [n][n];
			int [][] rupee = new int [n][n];
			int [][] visit = new int [n][n];
			int [][] dir = new int [][] {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
			
			for (int i = 0 ; i < n ; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < n ; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
					rupee[i][j] = Integer.MAX_VALUE;
				}
			}
			
			PriorityQueue<int []> inc = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
			rupee[0][0] = cave[0][0];
			inc.add(new int[] {0, 0, rupee[0][0]});
			
			while(!inc.isEmpty()) {
				int [] c = inc.poll();
				if (visit[c[0]][c[1]] != 1) {
					visit[c[0]][c[1]] = 1;
					for (int [] d : dir) {
						int dx = c[0] + d[0];
						int dy = c[1] + d[1];
						if (ifcave(dx, dy, n)) {
							if ((visit[dx][dy] != 1) && (rupee[dx][dy] > rupee[c[0]][c[1]] + cave[dx][dy])) {
								rupee[dx][dy] = rupee[c[0]][c[1]] + cave[dx][dy];
								inc.add(new int[] {dx, dy, rupee[dx][dy]});
							}
						}
					}
				}
			}
			
			System.out.printf("Problem %d: %d\n", tc, rupee[n-1][n-1]);
			
			tc++;
		}

	}

}
