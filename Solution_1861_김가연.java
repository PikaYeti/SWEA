package D_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1861_김가연 {
	
	static int [][] room;
	static int [][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int n;
	
	
	static boolean ifroom(int x, int y) {
		if (((0 <= x) && (x < n)) && ((0 <= y) && (y < n))) {
			return true;
		} else {
			return false;
		}
	}
	
	static int wdir(int [] loc) {
		for (int i = 0 ; i < dir.length ; i++) {
			int dx = loc[0] + dir[i][0];
			int dy = loc[1] + dir[i][1];
			if (ifroom(dx, dy)) {
				if ((room[loc[0]][loc[1]] + 1) == room[dx][dy]) {
					return i;
				}
			}
		}
		return -1;
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case++) {
			
			n = Integer.parseInt(bf.readLine());
			room = new int[n][n];
			int [] vcnt = new int[n * n];
			
			Queue<int[]> vque = new LinkedList<>();
			
			
			for (int i = 0 ; i < n ; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < n ; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int [] a;
			int next;
			int num = -1;
			int maxcnt = -1;
			
			for (int i = 0 ; i < n ; i ++) {
				for (int j = 0 ; j < n ; j ++) {
					int cnt = 0;
					vque.add(new int[] {i, j});
					while(!vque.isEmpty()) {
						cnt += 1;
						a = vque.poll();
						next = wdir(a);
						if (next != -1) {
							vque.add(new int[] {a[0] + dir[next][0], a[1] + dir[next][1]});
						}
					}
					vcnt[room[i][j] - 1] = cnt;
					if (num == - 1 && maxcnt == -1) {
						num = room[i][j];
						maxcnt = cnt;
					}
					
					if (cnt > maxcnt) {
						num = room[i][j];
						maxcnt = cnt;
					} else if (maxcnt == cnt) {
						if (room[i][j] < num) {
							num = room[i][j];
						}
					}
				}
			}
			
			System.out.printf("#%d %d %d \n", test_case, num, maxcnt);
			
		}

	}

}
