package D_0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_15686_김가연 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// 도시의 크기
		int n = Integer.parseInt(st.nextToken());
		// 도시 정보 받아줄 배열 선언
		int [][] city = new int [n][n];
		// 도시의 남아야 치킨집의 수 
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList[][] info = new ArrayList[n][n];
		for(int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < n ; j ++) {
				info[i][j] = new ArrayList<Integer>();
			}
		}
		
		ArrayList<int[]> home = new ArrayList<>();
		ArrayList<int[]> chi = new ArrayList<>();
		
		for (int i = 0 ; i < n ; i++) {
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			for (int j = 0 ; j < n ; j++) {
				city[i][j] = Integer.parseInt(st1.nextToken());
				if (city[i][j] == 1) {
					home.add(new int[] {i, j});
				} else if (city[i][j] == 2)  {
					chi.add(new int[] {i, j});
				}
			}
		}
		
		int dis = 0;
		ArrayList<int[]> mindis = new ArrayList<>();
		
		for (int i = 0 ; i < chi.size() ; i++) {
			int [] c = chi.get(i);
			for (int j = 0 ; j < home.size() ; j++) {
				int [] h = home.get(j);
				dis = Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]);
				if (j == 0) {
					info[c[0]][c[1]].add(dis);
					info[c[0]][c[1]].add(1);
				} else {
					int bdis = (int) info[c[0]][c[1]].get(0);
					if (bdis > dis) {
						info[c[0]][c[1]].set(0, dis);
						info[c[0]][c[1]].set(1, 1);
					} else if (bdis == dis) {
						info[c[0]][c[1]].set(1, (int)info[c[0]][c[1]].get(1) + 1);
					}
				}
			}
			mindis.add(new int[] {(int) info[c[0]][c[1]].get(0), (int) info[c[0]][c[1]].get(1), c[0], c[1]});
		}

		Collections.sort(mindis, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					if (o1[0] == o2[0]) {
						if (o1[2] == o2[2]) {
							return Math.abs(o1[3] - (int)(n / 2)) -  Math.abs(o2[3] - (int)(n / 2));
						}
						else {
							return Math.abs(o1[2] - (int)(n / 2)) -  Math.abs(o2[2] - (int)(n / 2));
						}
					} else {
						return o1[0] - o2[0];
					}
				} else {
					return o2[1] - o1[1];
				}
			}
		});
		
		for (int i = 0 ; i < mindis.size() ; i++) {
			System.out.println(Arrays.toString(mindis.get(i)));
		}
		
		int sum = 0;
		int cdis = 0;
		
		for (int i = 0 ; i < home.size() ; i++) {
			int [] h = home.get(i);
			int min = -1;
			for (int j = 0 ; j < m ; j++) {
				int [] c = mindis.get(j);
				cdis = Math.abs(h[0] - c[2]) + Math.abs(h[1] - c[3]);
				
				if (min == -1) {
					min = cdis;
				}
				
				if (cdis < min) {
					min = cdis;
				}
			}
			sum += min;
		}
		
		System.out.println(sum);

	}

}
