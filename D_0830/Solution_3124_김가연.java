package D_0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_3124_김가연 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			ArrayList<int[]>[] node = new ArrayList[V];
			for (int i = 0 ; i < V ; i++) {
				node[i] = new ArrayList<int[]>();
			}
			int E = Integer.parseInt(st.nextToken());
			
			for (int i = 0 ; i < E ; i++) {
				StringTokenizer st1 = new StringTokenizer(bf.readLine());
				
				int start = Integer.parseInt(st1.nextToken());
				int end = Integer.parseInt(st1.nextToken());
				int weight = Integer.parseInt(st1.nextToken());
				
				node[start].add(new int[] {end, weight});
				node[end].add(new int[] {start, weight});
			}
			
			for (int i = 0 ; i < V ; i++) {
				Collections.sort(node[i], ((o1, o2) -> Integer.compare(o1[1], o2[2])));
			}
			
			double cost = 0;
		}

	}

}
