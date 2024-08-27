package D_0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

import java.util.StringTokenizer;

public class Solution_2105_김가연 {
	
	static int [][] dir = new int [][] {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
	static int n = 0; 
	static int [][] desert;
	static int max;
	
	static boolean ifdesert(int x, int y) {
		if (((0 <= x) && (x < n)) && ((0 <= y) && (y < n))) {
			return true;
		} else {
			return false;
		}

	}
	
	
	static void tour(int [] visit, int x, int y, Deque<Integer> road, int i, int j, int k) {
		
		if ((visit[0] < visit[2]) || (visit[1] < visit[3])) {
			return;
		}
		
		for (int t = k ; t < 4 ; t++) {
			int dx = x + dir[t][0];
			int dy = y + dir[t][1];

			if (t == 3) {
				if ((dx == i) && (dy == j)) {
					if (max == -1) {
						max = road.size();
					}
					
					if (max < (road.size() + 1)) {
						max = road.size();
					}
					}
			}
			
			if (ifdesert(dx, dy)) {
				if (!road.contains(desert[dx][dy])) {
					road.addLast(desert[dx][dy]);
					visit[t] += 1;
					tour(visit, dx, dy, road, i, j, t);
					visit[t] -= 1;
					road.pollLast();			
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			n = Integer.parseInt(bf.readLine());
			desert  = new int[n][n];
			
			for (int i = 0 ; i < n ; i ++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < n ; j++) {
					desert[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = -1;
			
			int [] cidr = new int[4];
			
			for (int i = 0 ; i < n - 1 ; i ++) {
				for (int j = 1 ; j < n - 1 ; j ++) {
					Deque<Integer> road = new ArrayDeque<>();
					road.push(desert[i][j]);
					tour(cidr, i, j, road, i , j, 0);
				}
			}
			
			if (max <= 2) {
				System.out.printf("#%d -1 \n", test_case);
			} else {
				System.out.printf("#%d %d \n", test_case, max);
			}
		}
		
	}

}
