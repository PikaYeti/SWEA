package D_0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_3124_김가연 {
	
	static int [] parent;
	
	static void make(int n) {
		parent = new int [n];
		for (int i = 0 ; i < n ; i++) {
			parent[i] = -1;
		}
	}
	
	static int findSet(int a) {
		if (parent[a] < 0) {
			return a;
		}
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
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			ArrayList<int []> Elist = new ArrayList<>();
			
			for (int i = 0 ; i < E ; i ++) {
				StringTokenizer st1 = new StringTokenizer(bf.readLine());
				
				int start = Integer.parseInt(st1.nextToken()) - 1;
				int end = Integer.parseInt(st1.nextToken()) - 1;
				int weight = Integer.parseInt(st1.nextToken());
				
				Elist.add(new int[] {start, end, weight});
			}
			
			Collections.sort(Elist,((o1, o2) -> Integer.compare(o1[2], o2[2])));
			make(V);
			
			int cnt = 0;
			long sum = 0;
			
			for(int i = 0 ; i < Elist.size() ; i++) {
				int [] N = Elist.get(i);
				if (union(N[0], N[1])) {
					sum += N[2];
					cnt ++;
					if (cnt == V - 1) {
						break;
					}
				}
			}
			
			System.out.printf("#%d %d \n", test_case, sum);
		}

	}

}
