package D_0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2117_김가연 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			// 도시 가로, 세로 크기
			int n = Integer.parseInt(st.nextToken());
			// 한 집이 지불할 수 있는 비용
			int m = Integer.parseInt(st.nextToken());
			
			int [][] city = new int [n][n];
			ArrayList<int[]> ins = new ArrayList<>();
			
			for (int i = 0 ; i < n ; i ++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < n ; j++) {
					city[i][j] = Integer.parseInt(st.nextToken());
					if (city[i][j] == 1) {
						ins.add(new int[] {i, j});
					}
				}
			}
			int k = n+1;
			int max = Integer.MIN_VALUE;
			
			while(k > 0) {
				int hmax = Integer.MIN_VALUE;
				for (int i = 0 ; i < n ; i ++) {
					for (int j = 0 ; j < n ; j ++) {
						int cnt = 0;
						for (int h = 0 ; h < ins.size() ; h++) {
							int [] home = ins.get(h);
							if ((Math.abs(i - home[0]) + Math.abs(j - home[1])) <= k - 1)  {
								cnt += 1;
							}
						}
						if (hmax < cnt) {
							hmax = cnt;
						}
					}
				}
				
				int cost = (int) (Math.pow(k, 2) + Math.pow(k-1, 2));
				int mcost = hmax * m - cost;
				
				if ((mcost >= 0) && (hmax > max)) {
					max = hmax;
				}
				if (max == ins.size()) {
					break;
				}
				
				k--;

			}
			
			System.out.printf("#%d %d \n", test_case, max);
			
		}
	
	}

}
