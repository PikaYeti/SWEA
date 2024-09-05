package D_0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1494_김가연2 {
	
	static ArrayList<int []> az;
	static long min;
	
	static void zc(boolean [] visit, int cx, int cy, int depth, int select) {
		
		if (min == 0) {
			return;
		}
		
		
		if (select == 0) {
			
			long cnt = (long)cx * cx + (long)cy * cy;
			
			if (min > cnt) {
				min = cnt;
			}
			
			return;
		}
		
		for (int i = depth ; i < az.size() ; i++) {
			
			int [] c = az.get(i);
			
			if ((!visit[c[0]]) && (!visit[c[1]])) {
				
				visit[c[0]] = true;
				visit[c[1]] = true;
				
				if ((select <= 2) && (((Math.pow(cx + c[3], 2) + Math.pow(cy + c[3], 2)) > min) || ((Math.pow(cx - c[3], 2) + Math.pow(cy - c[3], 2)) > min))) {
					return;
				}
				
				zc(visit, cx + c[2], cy + c[3], i + 1, select - 2);
				zc(visit, cx - c[2], cy - c[3], i + 1, select - 2);
				
				visit[c[0]] = false;
				visit[c[1]] = false;
			}
		}
		
		return;
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			int n = Integer.parseInt(bf.readLine());
			
			int [][] zr = new int[n][2];
			
			
			for (int i = 0 ; i < n ; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < 2 ; j++) {
					zr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			az = new ArrayList<>();
			
			for (int i = 0 ; i < n ; i++) {
				for (int j = i + 1 ; j < n ; j++) {
					int cx = zr[i][0] - zr[j][0];
					int cy = zr[i][1] - zr[j][1];
					az.add(new int[] {i, j, cx, cy});
				}
			}
			
			min = Long.MAX_VALUE;
			boolean [] visit = new boolean[n];
			
			for (int i = 0 ; i < az.size() ; i++) {
				
				int [] c = az.get(i);
				
				visit[c[0]] = true;
				visit[c[1]] = true;
				
				zc(visit, c[2], c[3], i+1, n - 2);
				zc(visit, -c[2], -c[3], i+1, n - 2);
				
				visit[c[0]] = false;
				visit[c[1]] = false;
			}
			System.out.println(min);
		}
		

	}

}
