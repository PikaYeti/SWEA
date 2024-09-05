package D_0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_김가연 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			int N = Integer.parseInt(bf.readLine());
			
			// 언급횟수(해당 노드를 지나갔는지) 기록할 배열 선언
			int [] call = new int [N];
			int [] enter = new int [N];
			
			ArrayList[] height = new ArrayList[N];
			for (int i = 0 ; i < N ; i++) {
				height[i] = new ArrayList<>();
			}
			
			ArrayList[] reverse = new ArrayList[N];
			for (int i = 0 ; i < N ; i++) {
				reverse[i] = new ArrayList<>();
			}
			
			int M = Integer.parseInt(bf.readLine());
			
			StringTokenizer st;
			for (int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(bf.readLine());
				
				// 배열 인덱스와 맞춰주기 위해서 -1해주기
				int start = Integer.parseInt(st.nextToken()) - 1;
				int end = Integer.parseInt(st.nextToken()) - 1;
				
				height[start].add(end);
				reverse[end].add(start);
				
			}

			boolean [] visit = new boolean [N];
			Queue<Integer> q = new LinkedList<>();
			
			for (int i = 0 ; i < N ; i++) {
				int answer = 0;
				visit = new boolean [N];
				for (int j = 0 ; j < reverse[i].size() ; j++) {
					int r = (int)reverse[i].get(j);
					q.add(r);
				}
				
				while(!q.isEmpty()) {
					int r = q.poll();
					if (!visit[r]) {
						visit[r] = true;
						answer += 1;
					}
					for (int j = 0 ; j < reverse[r].size() ; j++) {
						int rr = (int)reverse[r].get(j);
						if (!visit[rr]) {
							visit[rr] = true;
							answer += 1;
							q.add(rr);
						}
					}
				}
				call[i] = answer;
			}
			
			for (int i = 0 ; i < N ; i++) {
				int answer = 0;
				visit = new boolean [N];
				for (int j = 0 ; j < height[i].size() ; j++) {
					int r = (int)height[i].get(j);
					q.add(r);
				}
				
				while(!q.isEmpty()) {
					int r = q.poll();
					if (!visit[r]) {
						visit[r] = true;
						answer += 1;
					}
					for (int j = 0 ; j < height[r].size() ; j++) {
						int rr = (int)height[r].get(j);
						if (!visit[rr]) {
							visit[rr] = true;
							answer += 1;
							q.add(rr);
						}
					}
				}
				enter[i] = answer;
			}
			
			int cnt = 0;
			
			for (int i = 0 ; i < N ; i++) {
				if (call[i] + enter[i] == N - 1) {
					cnt ++;
				}
			}
			
			System.out.printf("#%d %d \n", test_case, cnt);
			
		
			
		}

	}

}
