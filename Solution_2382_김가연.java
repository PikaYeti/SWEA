package D_0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2382_김가연 {
	
	static boolean iflab(int x, int y, int n) {
		if ((x == 0) || (x == n - 1) || (y == 0) || (y == n - 1)) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int [][] lab = new int [n][n];
			int m = Integer.parseInt(st.nextToken());
			// 미생물 정보 담을 배열 생성 [][0] : 미생물 수 , [][1] : 이동 방향
			int k = Integer.parseInt(st.nextToken());
			int [][] info = new int[k][2];
			
			int [][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
			Queue<int[]> inlab = new LinkedList<>();
			
			
			for (int i = 0 ; i < k ; i++) {
				StringTokenizer st1 = new StringTokenizer(bf.readLine());
				
				int x = Integer.parseInt(st1.nextToken());
				int y = Integer.parseInt(st1.nextToken());
				inlab.add(new int[] {x, y, i+1});
				
				info[i][0] = Integer.parseInt(st1.nextToken());
				info[i][1] = Integer.parseInt(st1.nextToken());
			}
			
			for (int i = 0 ; i < m ; i++) {
				
				lab = new int [n][n];
				int [][] max = new int [n][n];
				int tmp = 0;
				int cnt = 0;
				
				while (cnt < k) {
					int [] mi = inlab.poll();
					int d = info[mi[2] - 1][1] - 1;
					int mx = mi[0] + dir[d][0];
					int my = mi[1] + dir[d][1];
					
					if (lab[mx][my] != 0) {
						if (info[lab[mx][my] - 1][0] < info[mi[2] - 1][0]) {
							lab[mx][my] = mi[2];
						}
						if (max[mx][my] == 0) {
							max[mx][my] = info[lab[mx][my] - 1][0] + info[mi[2] - 1][0];
						} else {
							max[mx][my] += info[mi[2] - 1][0];
						}
						
					} else {
						lab[mx][my] = info[mi[2] - 1][0];
					}
					cnt ++;
				}
				
				for (int j = 0 ; j < max.length ; j++) {
					System.out.println(Arrays.toString(max[i]));
				}
				
				
			}
			
		}

	}

}
