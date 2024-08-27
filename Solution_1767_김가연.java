package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class Solution_1767_김가연 {
	
	static ArrayList<int []> incore;
	static int end;
	static int [][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int min;
	static int minidx;
	
	static boolean ifmap(int x, int y, int n) {
		if (((0 <= x) && (x < n)) && ((0 <= y) && (y < n))) {
			return true;
		} else {
			return false;
		}
	}
	
	static void processor(int [][] visit, int depth, int n, int sum, int connect) {
		
		if (depth == end) {
			if (minidx == -1) {
				minidx = connect;
				min = sum;
			}
			
			if (minidx < connect) {
				minidx = connect;
				min = sum;
			}
			
			if ((minidx == connect) && (min > sum)) {
				min = sum;
			}
			return;
		}
		
		int [] pro = incore.get(depth);
		depth += 1;
		for (int d = 0 ; d < 4 ; d++) {
			int cnt = 0;
			int dx = pro[0] + dir[d][0];
			int dy = pro[1] + dir[d][1];
			int [][] vclone = new int[n][n];
			for (int i = 0 ; i < visit.length ; i++) {
				for (int j = 0 ; j < visit[0].length ; j++) 
					vclone[i][j] = visit[i][j];
			}
			
			boolean meet = false;
			
			while(ifmap(dx, dy, n)) {
				if (visit[dx][dy] == -1) {
					cnt = 0;
					break;
				} 
				
				if (visit[dx][dy] == 1) {
					cnt = 0;
					break;
				}
				
				vclone[dx][dy] = 1;
				cnt += 1;
				
				dx += dir[d][0];
				dy += dir[d][1];
			}
			if (cnt == 0){
				processor(visit, depth, n, sum, connect);
			} else {
				processor(vclone, depth, n, sum + cnt, connect + 1);
			}
		}
		
		return;

		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());

		for (int test_case = 1 ; test_case <= tc ; test_case++) {
			
			int n = Integer.parseInt(bf.readLine());
			int [][] core = new int [n][n];
			incore = new ArrayList<>();
			
			
			int [][] visit = new int[n][n];
			min = -1;
			minidx = -1;
			
			for(int i = 0 ; i < n ; i++) {
				StringTokenizer st1 = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < n ; j++) {
					core[i][j] = Integer.parseInt(st1.nextToken());
					if (((i != 0) && (i != n - 1) && (j != 0) && (j != n - 1)) && (core[i][j] != 0)) {
						incore.add(new int[] {i, j});
						visit[i][j] = -1;
					} else if (((i == 0) || (i == n - 1) || (j == 0) || (j == n - 1)) && (core[i][j] != 0)) {
						visit[i][j] = -1;
					}
				}
			}
			
			end = incore.size();
			processor(visit, 0, n, 0, 0);
			
			System.out.printf("#%d %d \n", test_case, min);
			
		}

	}

}
