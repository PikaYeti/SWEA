package D_0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution_2805_김가연 {
	// 맨해튼 거리 사용

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			int n = Integer.parseInt(bf.readLine());
			
			int [][] garden = new int[n][n];
			for (int i = 0 ; i < n ; i++) {
				String str = new String(bf.readLine());
				for (int j = 0 ; j < n ; j++) {
					garden[i][j] = (str.charAt(j) - 48);
				}
			}

			int sum = 0;			
			
			int d = n/2;
			for (int i = 0 ; i < n ; i++) {
				for (int j = 0 ; j < n ; j++) {
					if ((Math.abs(i - d) + Math.abs(j - d)) <= d) {
						sum += garden[i][j];
					}
				}
			}
			
			System.out.printf("#%d %d \n",test_case, sum);
		}

	}

}
