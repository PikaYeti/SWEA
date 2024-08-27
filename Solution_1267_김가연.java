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
				
				// 배열 인덱스에 맞춰주기 위해 -1 시켜주기
				int front = Integer.parseInt(st1.nextToken()) - 1;
				int back = Integer.parseInt(st1.nextToken()) - 1;
				
				// 노드에 나가는 간선으로 향하는 노드를 넣어주기
				node[front].add(back);
				
				// 진입 간선 세는 베열에 +1 해주기
				varr[back] += 1;
			}
			
			Queue<Integer> tsort = new LinkedList<>();
			int cnt = 0;
			
			System.out.printf("#%d ", test_case);
			
			// 간선 수 만큼 while문 돌리기
			while(cnt < V) {
				
				// 진입 간선이 0인 곳 찾아 큐에 더해주기
				for (int i = 0 ; i < varr.length ; i++) {
					if (varr[i] == 0) {
						tsort.add(i);
						
						// 다음 탐색에서 탐색되지 않기위해 -1로 바꿔주기
						varr[i] = -1;
						
						// 현재까지 큐에 삽입한 간선 수 +1
						cnt += 1;
					}
				}
				
				// 큐가 빌때까지 실행
				while(!tsort.isEmpty()) {
					int n = tsort.poll();
					
					// 진입노드가 0인 노드에 연결된 노드 찾아 진입간선 제거
					for (int i = 0 ; i < node[n].size() ; i++) {
						varr[(int) node[n].get(i)] -= 1;
					}
					
					// 인덱스에 맞게 -1로 넣어줬으니 +1해서 진입노드 0인 노드 출력
					System.out.print(n+1 + " ");
				}
			}
			System.out.println();
			
		}

	}

}
