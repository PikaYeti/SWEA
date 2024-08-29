package D_0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1922_김가연 {
	
	static int [] parent;
	
	static void make(int n) {
		parent = new int[n];
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
		
		int V = Integer.parseInt(bf.readLine());
		int E = Integer.parseInt(bf.readLine());
		ArrayList<int[]> computer = new ArrayList<>();
		
		for (int i = 0 ; i < E ; i++) {
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			
			int start = Integer.parseInt(st1.nextToken())-1;
			int end = Integer.parseInt(st1.nextToken())-1;
			int weight = Integer.parseInt(st1.nextToken());
			
			computer.add(new int[] {start, end, weight});
		}
		
		Collections.sort(computer,((o1, o2) -> Integer.compare(o1[2], o2[2])));
		
		make(V);
		int cnt = 0, sum = 0;
		for (int i = 0 ; i < computer.size() ; i++) {
			int [] c = computer.get(i);
			if (union(c[0], c[1])) {
				cnt += 1;
				sum += c[2];
				if (cnt == V - 1) {
					break;
				}
			}
		}
		
		System.out.println(sum);
	}

}
