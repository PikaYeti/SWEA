package D_0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1267_김가연 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			// 그래프 노드 생성
			ArrayList[] node = new ArrayList[V];
			for (int i = 0 ; i < V ; i++) {
				node[i] = new ArrayList<Integer>();
			}
			// 진입 간선 수 세는 배열
			int [] varr = new int[V];
			
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			for (int i = 0 ; i < E ; i++) {

				int front = Integer.parseInt(st1.nextToken()) - 1;
				int back = Integer.parseInt(st1.nextToken()) - 1;
				
				node[front].add(back);
				varr[back] += 1;
			}
			
			Queue<Integer> tsort = new LinkedList<>();
			int cnt = 0;
			
			System.out.printf("#%d ", test_case);
			while(cnt < V) {
				for (int i = 0 ; i < varr.length ; i++) {
					if (varr[i] == 0) {
						tsort.add(i);
						varr[i] = -1;
						cnt += 1;
					}
				}
				
				while(!tsort.isEmpty()) {
					int n = tsort.poll();
					for (int i = 0 ; i < node[n].size() ; i++) {
						varr[(int) node[n].get(i)] -= 1;
					}
					System.out.print(n+1 + " ");
				}
			}
			System.out.println();
			
		}

	}

}
