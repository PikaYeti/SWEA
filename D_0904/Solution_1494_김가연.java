package D_0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_1494_김가연 {
	
	static ArrayList<int []> czirung;
	static long min;
	
	static void lsum(boolean [] visit, int cx, int cy, int select, int n, int depth) {
		
		if ((Math.pow(cx, 2) + Math.pow(cy, 2)) > min) {
			return;
		}
		
		
		if (n == select) {
			
			long cnt = (long)(Math.pow(cx, 2) + Math.pow(cy, 2));
			
			if (min > cnt) {
				min = cnt;
			}
			
			return;
		}
		
		for (int i = depth ; i < czirung.size() ; i++) {
			
			int [] c = czirung.get(i);
			
			if ((!visit[c[0]]) && (!visit[c[1]])) {
				
				visit[c[0]] = true;
				visit[c[1]] = true;
				
				if (select == 4) {
					System.out.printf("%d %d %d %d %d\n", cx, cy, c[2], c[3], select);
					System.out.println(Arrays.toString(visit));
				}
				
				lsum(visit, cx + c[2], cy + c[3], select + 2, n, i + 1);
				lsum(visit, cx - c[2], cy - c[3], select + 2, n, i + 1);
				
				
				visit[c[0]] = false;
				visit[c[1]] = false;
				
				lsum(visit, cx + c[2], cy + c[3], select, n, i + 1);
				lsum(visit, cx - c[2], cy - c[3], select, n, i + 1);
				
			}
		}
		
		return;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			int n = Integer.parseInt(bf.readLine());
			
			int [][] zirung = new int [n][2];
			
			for (int i = 0 ; i < n ; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < 2 ; j++) {
					zirung[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			ArrayList[] couple = new ArrayList[n];
//			for (int i = 0 ; i < n ; i++) {
//				couple[i] = new ArrayList<int []>();
//			}
			
			
			
//			for (int i = 0 ; i < n ; i++) {
//				for (int j = i + 1 ; j < n ; j++) {
//					int cx = zirung[i][0] - zirung[j][0];
//					int cy = zirung[i][1] - zirung[j][1];
//					couple[i].add(new int[] {j, cx, cy});
//					
//					cx = zirung[j][0] - zirung[i][0];
//					cy = zirung[j][1] - zirung[i][1];
//					couple[j].add(new int[] {i, cx, cy});
//				}
//			}
			
			czirung = new ArrayList<>();
			
			for (int i = 0 ; i < n ; i++) {
				for (int j = i + 1; j < n ; j++) {
					int cx = zirung[i][0] - zirung[j][0];
					int cy = zirung[i][1] - zirung[j][1];
					czirung.add(new int[] {i, j, cx, cy});
					
//					cx = zirung[j][0] - zirung[i][0];
//					cy = zirung[j][1] - zirung[i][1];
//					czirung.add(new int[] {j, i, cx, cy});
				}
			}
			
			boolean [] visit = new boolean [n];
			
			int idx = 0;
			min = Long.MAX_VALUE;
			
			while(idx < czirung.size()) {
				int [] c = czirung.get(idx);

				
				visit[c[0]] = true;
				visit[c[1]] = true;
				
				lsum(visit, c[2], c[3], 2, n, idx + 1);
				lsum(visit, -c[2], -c[3], 2, n, idx + 1);
				
				visit[c[0]] = false;
				visit[c[1]] = false;
				
				idx++;
			}
			
			System.out.printf("#%d %d \n", test_case, min);
			
		}

	}

}
