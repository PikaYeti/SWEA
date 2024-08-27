package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution_2805_김가연 {
	// 맨해튼 거리 알고리즘 사용

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			int n = Integer.parseInt(bf.readLine());
			// 농작물 배열 저장할 배열
			int [][] garden = new int[n][n];
			for (int i = 0 ; i < n ; i++) {
				String str = new String(bf.readLine());
				for (int j = 0 ; j < n ; j++) {
					garden[i][j] = (str.charAt(j) - 48);
				}
			}

			int sum = 0;			
			// 가운데 좌표, 기준거리 설정
			int d = n/2;
			// 만약 현재 x좌표, y좌표가 가운데 좌표에서 기준거리보다 멀다면 마름모 내부가 아니므로 덧셈 X
			// 만약 기준거리와 같거나 가깝다면 마름모 내부이므로 덧셈
			for (int i = 0 ; i < n ; i++) {
				for (int j = 0 ; j < n ; j++) {
					if ((Math.abs(i - d) + Math.abs(j - d)) <= d) {
						sum += garden[i][j];
					}
				}
			}
			// 모두 더해 출력
			System.out.printf("#%d %d \n",test_case, sum);
		}

	}

}
