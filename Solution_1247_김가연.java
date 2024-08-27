package D_0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_김가연 {
	
	static int[][] consu;
	static int min;
	static int [] home;
	
	static void permutation(int [] arr, boolean [] visit, int cnt, int r, int x, int y, int sum) {
		if (cnt == r) {
			sum += Math.abs(home[0] - x) + Math.abs(home[1] - y);
			if (min == -1) {
				min = sum;
			}
			
			if (min > sum) {
				min = sum;
			}
			return;
		}
		
		for (int i = 0 ; i < arr.length ; i++) {
			if (!visit[i]) {
				
				if ((min < sum)) {
					if (min != -1) {
						return;
					}
				}
				
				visit[i] = true;
				sum += Math.abs(consu[i][0] - x) + Math.abs(consu[i][1] - y);
				if ((min == -1) || (sum < min)) {
					permutation(arr, visit, cnt + 1, r, consu[i][0], consu[i][1], sum);
				}
				visit[i] = false;
				sum -= Math.abs(consu[i][0] - x) + Math.abs(consu[i][1] - y);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			int n  = Integer.parseInt(bf.readLine());
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int [] company = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			home = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			consu = new int[n][2];
			min = -1;
			
			boolean [] visit = new boolean[n];
			int [] arr = new int[n];
			
			
			for (int i = 0 ; i < n ; i ++) {
				consu[i][0] = Integer.parseInt(st.nextToken());
				consu[i][1] = Integer.parseInt(st.nextToken());
			}
			
			permutation(arr, visit, 0, n , company[0], company[1], 0);
			System.out.printf("#%d %d \n", test_case, min);
		}
		
		
		

	}

}
