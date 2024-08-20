package D_0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1486_±è°¡¿¬ {
	
	static int [] arr;
	static int min;
	static int b;
	
	static void set(boolean [] visit, int n, int r) {
		
		if (r == n) {
			int a = 0;
			
			for (int i = 0 ; i < visit.length ; i++) {
				if (visit[i]) {
					a += arr[i];
				}
			}
			
			
			if ((min == -1) && ((a - b) >= 0)) {
				min = a - b;
			}
			
			if (((a - b) >= 0) && (min > (a - b))) {
				min = (a - b);
			}
			
			return;
		}
		
		visit[r] = true;
		set(visit, n, r+1);
		
		visit[r] = false;
		set(visit, n, r+1);
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			min = -1;
			
			arr = new int[n];
			boolean [] visit = new boolean[n];
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			for (int i = 0 ; i < n ; i ++) {
				arr[i] = Integer.parseInt(st1.nextToken());
			}
			
			set(visit, n, 0);
			System.out.printf("#%d %d \n", test_case, min);
		}
	}

}
