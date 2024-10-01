package SWEA.D_0906;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2644_김가연 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		ArrayList[] node = new ArrayList[n];
		ArrayList[] rnode = new ArrayList[n];
		
		for (int i = 0 ; i < n ; i++) {
			node[i] = new ArrayList<Integer>();
			rnode[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int r = Integer.parseInt(bf.readLine());
		
		for (int i = 0 ; i < r ; i++) {
			
			st = new StringTokenizer(bf.readLine());
			
			int front = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			
			node[front].add(end);
			rnode[end].add(front);
			
		}
		
		ArrayList<int[]> nodel = new ArrayList<>();
		ArrayList<int[]> rnodel = new ArrayList<>();
		
		Queue<Integer> q = new LinkedList<>();
		
		int answer = 0;
		
		if (rnode[a].size() != 0) {
			
			q.add(a);
			
			while(!q.isEmpty()) {
				
				int qp = q.poll();
				int depth = 1;
				
				if (qp == b) {
					answer = nodel.get(nodel.size()- 1)[1];
					break;
				}
				
				if (rnode[qp].size() > 0) {
					for (int i = 0 ; i < rnode[qp].size(); i++) {
						int head = (int) rnode[qp].get(i);
						nodel.add(new int [] {head, depth});
						depth += 1;
						q.add(head);
					}
				}
			}
		}
		
		q = new LinkedList<>();
		
		if (rnode[b].size() != 0) {
			
			q.add(a);
			
			while(!q.isEmpty()) {
				
				int qp = q.poll();
				int depth = 1;
				
				if (qp == a) {
					answer = rnodel.get(rnodel.size()- 1)[1];
					break;
				}
				
				if (rnode[qp].size() != 0) {
					for (int i = 0 ; i < rnode[qp].size(); i++) {
						int head = (int) rnode[qp].get(i);
						rnodel.add(new int [] {head, depth});
						depth += 1;
						q.add(head);
					}
				}
			}
			
		}
		
		if (answer != 0) {
			System.out.println(answer);
		} else if (answer == 0) {
			
			if ((nodel.size() > 0) && (rnodel.size() > 0)) {
				
				if (nodel.get(nodel.size() - 1)[0] == rnodel.get(rnodel.size() - 1)[0]) {
					for (int i = 0 ; i < nodel.size() ; i++) {
						for (int j = 0 ; j < rnodel.size() ; j++) {
							if (nodel.get(i)[0] == rnodel.get(j)[0]) {
								answer = nodel.get(i)[1] + rnodel.get(j)[1];
							}
						}
					}
				} else {
					System.out.println(-1);
				}
				
			}
			else {
				System.out.println(-1);
			}
		}
		
	}
	
}
