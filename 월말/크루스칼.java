package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 크루스칼 {
	
	static int [] parent;
	
	// 노드를 갯수만큼 배열을 만들어 각 노드의 값을 -1로 설정
	static void make(int n) {
		parent = new int [n];
		for (int i = 0 ; i < n ; i++) {
			parent[i] = -1;
		}
	}
	
	// 대표자 찾는 함수
	static int findSet(int a) {
		// 만약 값이 0보다 작으면 그 배열의 대표자이므로 받은 값 그대로 리턴
		if (parent[a] < 0) {
			return a;
		}
		// 만약 0이 아닌 값이 있으면 집합에 속해있는 것
		// 패스 압축해주면서 대표자 찾으러가기
		return parent[a] = findSet(parent[a]);
	}
	
	// 합집합 만들어주는 함수
	static boolean union(int a, int b) {
		// 각 파라미터의 대표자를 찾으러 가기
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		// 만약 두개의 대표자가 같다면 같은 집합 내에 있는 것이므로 false 리턴
		if (aRoot == bRoot) {
			return false;
		}
		
		// 아니라면 한 원소를 다른 원소의 대표자로 설정하여 합집합 만들어주고 true 리턴
		parent[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			// 노드의 수, 간선의 수 받아주기
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			// 노드의 start, end, 가중치를 저장할 리스트 선언
			ArrayList<int []> Elist = new ArrayList<>();
			
			for (int i = 0 ; i < E ; i ++) {
				StringTokenizer st1 = new StringTokenizer(bf.readLine());
				
				// start, end, 가중치 값을 받아 리스트에 저장해주기
				int start = Integer.parseInt(st1.nextToken()) - 1;
				int end = Integer.parseInt(st1.nextToken()) - 1;
				int weight = Integer.parseInt(st1.nextToken());
				
				Elist.add(new int[] {start, end, weight});
			}
			
			// 가중치를 기준으로 리스트를 오름차순 정렬 해주기
			Collections.sort(Elist,((o1, o2) -> Integer.compare(o1[2], o2[2])));
			
			// 각 노드를 1개 집합으로 만들어주고
			make(V);
			
			// 현재 몇개의 간선을 지났는지를 저장할 변수 선언
			int cnt = 0;
			
			// 가중치를 더해 최소값을 저장해줄 변수 선언
			long sum = 0;
			
			for(int i = 0 ; i < Elist.size() ; i++) {
				int [] N = Elist.get(i);
				
				// start, end 노드가 같은 집합이 아니라면 같은 집합으로 만들어주고
				if (union(N[0], N[1])) {
					
					// 가중치 더해주기
					sum += N[2];
					
					// 간선을 하나 지났으므로 cnt를 하나 늘려주기
					cnt ++;
					
					// 만약 간선이 노드 갯수 -1개가 되었으면 모든 노드를 탐색한 것이므로 break문으로 반복문 빠져나오기
					if (cnt == V - 1) {
						break;
					}
				}
			}
			
			// 가중치의 최솟값 출력
			System.out.printf("#%d %d \n", test_case, sum);
		}

	}

}

