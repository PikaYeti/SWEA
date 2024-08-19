package D_0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5215_±è°¡¿¬ {
	
	static boolean np(int [] cal, int n) {
		int i = n - 1;
		
		while((i > 0) && (cal[i - 1] >= cal[i])) {
			--i;
		}
		
		if(i == 0) {
			return false;
		}
		
		int j =  n - 1;
		while(cal[i - 1] >= cal[j]) {
			--j;
		}
		
		int temp = cal[i - 1];
		cal[i - 1] = cal[j];
		cal[j] = temp;
		
		int k = n - 1;
		while(i < k) {
			temp = cal[i];
			cal[i] = cal[k];
			cal[k] = temp;
			i++;
			k--;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			int [][] ham = new int [n][2];
			int [] ifcal = new int [n];
			
			int max = -1;
			
			for (int i = 0 ; i < n ; i ++) {
				StringTokenizer st1 = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < 2 ; j++) {
					ham[i][j] = Integer.parseInt(st1.nextToken());
				}
			}
			
			Arrays.sort(ham, (o1, o2) -> {
				return o1[0] - o2[0];
			});
			
			for (int i = 0 ; i < n ; i ++) {
				ifcal = new int[n];
				for (int j = (n - 1) ; j >= (n-1-i) ; j --) {
					ifcal[j] = 1;
				}
				do {
					int sum = 0;
					int score = 0;
					for (int k = 0 ; k < ifcal.length ; k++) {
						if (ifcal[k] == 1) {
							score += ham[k][0];
							sum += ham[k][1];
							if (sum > l) {
								sum = 0;
								score = 0;
								break;
							}
						}
					}
					if (score > max) {
						max = score;
					}
				} while(np(ifcal, n));
				
				
			}
			
			System.out.printf("#%d %d \n",test_case, max);
			
		}
		
	}

}
