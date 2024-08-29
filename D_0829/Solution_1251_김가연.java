package D_0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_1251_김가연 {
	
	static int [] parent;
	
	static void make(int n) {
		parent = new int[n];
		for (int i = 0 ; i < n ; i++) {
			parent[i] = -1;
		}
	}
	
	static int findSet(int a) {
		// 0보다 작은 -1이 저장되어 있다면 아직 union이 일어나지 않아 대표자 자기 자신이거나 현재 집합의 대표자가 자신 -> 자기 자신 리턴
		if (parent[a] < 0) {
			return a;
		}
		// -1이 아니라면 집합에 속해있는 것 이므로
		// 패스압축 해주면서 내 집합의 대표자 찾으러가기
		return parent[a] = findSet(parent[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) {
			return false;
		}
		
		parent[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			int n = Integer.parseInt(bf.readLine());
			int [][] arr = new int[n][2];
			ArrayList<double []> ocean = new ArrayList<>();
			
			for (int i = 0 ; i < 2 ; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < n ; j++) {
					arr[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			double E = Double.parseDouble(bf.readLine());
			
			for (int i = 0 ; i < n ; i ++) {
				for(int j = i+1 ; j < n ; j++) {
					double dis = E * ( Math.pow(Math.abs(arr[i][0] - arr[j][0]), 2) + Math.pow(Math.abs(arr[i][1] - arr[j][1]), 2));
					ocean.add(new double [] {i, j, dis});
				}
			}
			
			Collections.sort(ocean,((o1, o2) -> Double.compare(o1[2], o2[2])));

			make(n);
			double cnt = 0, cost = 0;
			
			for (int i = 0 ; i < ocean.size() ; i++) {
				double [] oc = ocean.get(i);
				if(union((int)oc[0], (int)oc[1])) {
					cost += oc[2];
					cnt ++;
					if (cnt == (n - 1)) {
						break;
					}
				}
			}
			
			System.out.printf("#%d %.0f \n",test_case, cost);
			
			
		}
	}

}
