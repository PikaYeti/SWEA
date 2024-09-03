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
			
			// 도시 정보 저장할 배열 선언
			int [][] city = new int [n][n];
			// 집 좌표 저장할 리스트 선언
			ArrayList<int[]> ins = new ArrayList<>();
			
			// 도시 정보를 저장해주며 집을 만났을 때 집의 좌표를 리스트에 추가해준다.
			for (int i = 0 ; i < n ; i ++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < n ; j++) {
					city[i][j] = Integer.parseInt(st.nextToken());
					if (city[i][j] == 1) {
						ins.add(new int[] {i, j});
					}
				}
			}
			
			// 방범 서비스의 처음 크기가 도시 지도를 다 덮을 수 있도록 n+1로 설정해주기
			int k = n+1;
			// 최대값을 저장하기 위해여 가장 최소값으로 초기화해준다.
			int max = Integer.MIN_VALUE;
			
			// 마름모 크기 k가 1보다 크거나 같을때 반복하기
			while(k >= 1) {
				
				// 몇개의 집을 지킬 수 있는지 체크하기 위해 변수 선언
				int hmax = Integer.MIN_VALUE;
				
				// 배열을 처음부터 끝까지 돌면서 현재 좌표에서 마름모가 몇개의 집을 지킬 수 있는지 확인하고 저장
				for (int i = 0 ; i < n ; i ++) {
					for (int j = 0 ; j < n ; j ++) {
						int cnt = 0;
						// 좌표에서 집까지의 거리 체크하기
						for (int h = 0 ; h < ins.size() ; h++) {
							int [] home = ins.get(h);
							
							// 만약 현재 좌표에서 집까지의 거리가 마름모의 크기보다 작거나 같다면 +1해주기
							if ((Math.abs(i - home[0]) + Math.abs(j - home[1])) <= k - 1)  {
								cnt += 1;
							}
						}
						// 만약 그 전 마름모가 지킬수 있는 집보다 현재 마름모가 지킬 수 있는 집이 더 많다면 최대값 교체
						if (hmax < cnt) {
							hmax = cnt;
						}
					}
				}
				// 손해 비용 구하기
				int cost = (int) (Math.pow(k, 2) + Math.pow(k-1, 2));
				int mcost = hmax * m - cost;
				
				// 만약 손해를 보지 않고 저장된 집 최대 개수보다 현재 카운트한 집 개수가 더 많으면 최대값 변경
				if ((mcost >= 0) && (hmax > max)) {
					max = hmax;
				}
				
				// 만약 저장된 최대값이 지도 전체에 있는 집의 개수와 같으면 더 큰 최대값이 나올 수 없으므로 반복문 종료
				if (max == ins.size()) {
					break;
				}
				
				// k를 줄여가며 다시 확인하기
				k--;

			}
			
			// 테스트 케이스와 최대값 출력
			System.out.printf("#%d %d \n", test_case, max);
			
		}
	
	}

}
