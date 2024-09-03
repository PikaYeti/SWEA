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
	
	// 선택할 수 있는 꿀 중에서 조합을 돌리는 함수
	static void combi(boolean [] visit, int depth, int r, int sum, int cnt) {
		
		// 만약 최대 꿀 양 모다 많으면 그대로 리턴
		if (sum > c) {
			return;
		}
		
		
		// 모을수 있는 꿀 칸을 다 ㅁ았으면
		if (depth == r) {
			
			// 만약 0칸, 전부 다 선택했다면 리턴
			if ((cnt < 1) || (cnt == r)) {
				return;
			}
			
			int sumall = 0;
			
			// 선택한 꿀 칸 제곱해서 더해주기
			for (int i = 0 ; i < visit.length ; i++) {
				if (visit[i]) {
					sumall += Math.pow(arr[i], 2);
				}
			}
			
			if (max == -1) {
				max = sumall;
			}
			
			// 최댓값 설정
			if (max < sumall) {
				max = sumall;
			}
			return;
		}
		
		// 부분조합으로 선택해주기
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
					// 꿀양이 최대 양과 같다면 그냥 그대로 제곱해서 더해주기
					} else {
						for (int k = j ; k < j + m ; k ++) {
							maxp += Math.pow(bee[i][k], 2);
						}
					}
					honey.add(new int[] {i, j, maxp});
				}
			}
			
			// 꿀양 기준으로 내림차순 정렬
			Collections.sort(honey, ((o1, o2) -> Integer.compare(o2[2], o1[2])));
			
			// 맨 위에 있는 원소과 최대값이므로 빼주기
			int [] mh = honey.get(0);
			int answer = 0;
			
			// 두번째 원소가 그 다음 최댓값이므로 빼주기
			for (int i = 1 ; i < honey.size() ; i++) {
				int [] nh = honey.get(i);
				
				// X 좌표가 다르다면 상관없으니 그냥 빼주기
				if (mh[0] != nh[0]) {
					answer = mh[2] + nh[2];
					break;
				// 만약 X좌표가 같지만 Y좌표가 M이상 차이난다면 겹치지 않으니 그대로 빼주기
				} else {
					if (Math.abs(mh[1] - nh[1]) >= m) {
						answer = mh[2] + nh[2];
						break;
					}
				}
			}
			// 출력
			System.out.printf("#%d %d \n", test_case, answer);
			
			
		}

	}

}
