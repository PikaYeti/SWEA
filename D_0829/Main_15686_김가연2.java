package D_0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_15686_김가연2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<int []> chi = new ArrayList<>();
		ArrayList<int []> home = new ArrayList<>();
		
		int [][] arr = new int [n][n];
		for (int i = 0 ; i < n ; i++) {
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			for (int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st1.nextToken());
				if (arr[i][j] == 1) {
					home.add(new int[] {i, j});
				} else if (arr[i][j] == 2) {
					chi.add(new int[] {i, j});
				}
			}
		}
		
		int dis = 0;
		ArrayList<int []> mindis = new ArrayList<>();
		
		for (int i = 0 ; i < chi.size() ; i++) {
			dis = 0;
			int [] ck = chi.get(i);
			for (int j = 0 ; j < home.size() ; j++) {
				int [] hm = home.get(j);
				dis += Math.abs(ck[0] - hm[0]) + Math.abs(ck[1] - hm[1]);
			}
			mindis.add(new int[] {ck[0], ck[1], dis});
		}
		
		Collections.sort(mindis,((o1, o2) -> Integer.compare(o1[2], o2[2])));
		
		for (int i = 0 ; i < mindis.size() ; i++) {
			System.out.println(Arrays.toString(mindis.get(i)));
		}

	}

}
