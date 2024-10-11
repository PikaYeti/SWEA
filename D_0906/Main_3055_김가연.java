package D1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_김가연 {
	
	static int r;
	static int c;
	
	static boolean ifmap(int x, int y) {
		if (((0 <= x) && (x < r)) && ((0 <= y) && (y < c))) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		char [][] forest = new char [r][c];
		int bx = 0, by = 0;

		boolean [][] wvisit = new boolean [r][c];
		Queue<int []> wq = new LinkedList<int[]>();
		
		for (int i = 0 ; i < r ; i++) {
			String line = bf.readLine();
			for (int j = 0 ; j < c ; j ++) {
				forest[i][j] = line.charAt(j);
				
				if (forest[i][j] == 'S') {
					bx = i;
					by = j;
				} else if (forest[i][j] == '*') {
					wvisit[i][j] = true;
					wq.add(new int[] {i, j, 0});
				}
			}
		}
		
		boolean [][] visit = new boolean [r][c];
		visit[bx][by] = true;
		forest[bx][by] = '.';
		
		int bd = 0;
		
		int answer = 0;
		int [][] dir = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		
		Queue<int []> q = new LinkedList<int[]>();
		q.add(new int[] {bx, by, bd});
		
		while(!q.isEmpty()) {
			
			if (answer != 0) {
				break;
			}
			
			int [] qp = q.poll();
			
			while((!wq.isEmpty()) && (qp[2] == wq.peek()[2])) {
				
				int [] wp = wq.poll();
				
				for (int [] d : dir) {
					
					int dx = d[0] + wp[0];
					int dy = d[1] + wp[1];
					
					if (ifmap(dx, dy)) {
						if (!wvisit[dx][dy]) {
							if (forest[dx][dy] == '.') {
								forest[dx][dy] = '*';
								wvisit[dx][dy] = true;
								wq.add(new int[] {dx, dy, wp[2] + 1});
							}
						}
					}
					
				}
			}
			
				
				for (int [] d : dir) {
					
					int dx = d[0] + qp[0];
					int dy = d[1] + qp[1];
					
					if (ifmap(dx, dy)) {
						if (!visit[dx][dy]) {
							if (forest[dx][dy] == '.') {
								visit[dx][dy] = true;
								q.add(new int [] {dx, dy, qp[2] + 1});
							} else if (forest[dx][dy] == 'D') {
								visit[dx][dy] = true;
								answer = qp[2] + 1;
							}
						}
					}
					
				}
				
			}

		
		if (answer != 0) {
			System.out.println(answer);
		} else {
			System.out.println("KAKTUS");
		}

	}

}
