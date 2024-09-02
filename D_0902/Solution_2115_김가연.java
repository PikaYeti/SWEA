package D_0902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_2115_김가연 {
	
	static int [] arr;
	static int max;
	static int c;
	
	static void combi(boolean [] visit, int depth, int r, int sum, int cnt) {
		
		if (sum > c) {
			return;
		}
		
		if (depth == r) {
			
			if ((cnt < 1) || (cnt == r)) {
				return;
			}
			
			int sumall = 0;
			
			for (int i = 0 ; i < visit.length ; i++) {
				if (visit[i]) {
					sumall += Math.pow(arr[i], 2);
				}
			}
			
			if (max == -1) {
				max = sumall;
			}
			
			if (max < sumall) {
				max = sumall;
			}
			return;
		}
		
		for (int i = depth ; i < r ; i ++) {
			
			visit[i] = true;
			sum += arr[i];
			cnt += 1;
			combi(visit, depth + 1, r, sum, cnt);
			
			visit[i] = false;
			sum -= arr[i];
			cnt -= 1;
			combi(visit, depth + 1, r, sum, cnt);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			// 벌통의 크기
			int n = Integer.parseInt(st.nextToken());
			int [][] bee = new int [n][n];
			
			// 선택할 수 있는 벌통의 개수
			int m = Integer.parseInt(st.nextToken());
			// 채취할 수 있는 최대 꿀 양
			c = Integer.parseInt(st.nextToken());
			
			// 벌통 채워주기
			for (int i = 0 ; i < n ; i++) {
				StringTokenizer st1 = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < n ; j++) {
					bee[i][j] = Integer.parseInt(st1.nextToken());
				}
			}
			
			ArrayList<int[]> honey = new ArrayList<>();
			
			int maxh = 0;
			int maxp = 0;

			for (int i = 0 ; i < n ; i++) {
				for (int j = 0 ; j <= n - m ; j++) {
					
					// 최대로 담을 수 있는 꿀 양 초기화
					maxh = 0;
					
					// 꿀 양 더해주기
					for (int k = j ; k < j + m ; k ++) {
						maxh += bee[i][k];
					}
					maxp = 0;
					// 만약 방금 담은 꿀 양이 담을 수 있는 꿀 양을 초과했다면
					if (maxh > c) {
						max = -1;
						arr = new int[m];
						int sum = 0, cnt = 0;
						boolean [] visit = new boolean[m];
						int idx = 0;
						
						
						// 1개부터 m - 1개까지 더할 수 있는 조합을 구해준다.
						for (int k = j ; k < j + m ; k ++) {
							arr[idx++] = bee[i][k];
						}
						combi(visit, 0, m, sum, 0);
						
						honey.add(new int[] {i, j, max});
					} else {
						for (int k = j ; k < j + m ; k ++) {
							maxp += Math.pow(bee[i][k], 2);
						}
					}
					honey.add(new int[] {i, j, maxp});
				}
			}
			
			Collections.sort(honey, ((o1, o2) -> Integer.compare(o2[2], o1[2])));
			
			int [] mh = honey.get(0);
			int answer = 0;
			
			for (int i = 1 ; i < honey.size() ; i++) {
				int [] nh = honey.get(i);
				
				if (mh[0] != nh[0]) {
					answer = mh[2] + nh[2];
					break;
				} else {
					if (Math.abs(mh[1] - nh[1]) >= m) {
						answer = mh[2] + nh[2];
						break;
					}
				}
			}
			
			System.out.printf("#%d %d \n", test_case, answer);
			
			
		}

	}

}
