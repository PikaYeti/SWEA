package D_0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1922_김가연 {
	
	// 노드 집합의 대표자를 저장할 배열 설정
	static int [] parent;
	
	// 노드의 갯수만큼 배열을 만들어 각 노드의 값을 -1로 설정
	static void make(int n) {
		// 노드 갯수만큼의 배열을 선언
		parent = new int[n];
		
		// 돌면서 -1값을 저장 -> -1 : 대표자가 자기 자신
		for (int i = 0 ; i < n ; i++) {
			parent[i] = -1;
		}
	}
	
	// 집합의 대표자를 찾는 함수
	static int findSet(int a) {
		
		// 만약 0보다 작다면 대표자가 자기 자신이므로 파라미터 그대로 리턴해주기
		if (parent[a] < 0) {
			return a;
		}
		
		// 만약 0보다 크다면 대표자를 찾기 위해 패스를 압축해가며 대표자를 찾아준다
		return parent[a] = findSet(parent[a]);
	}
	
	
	// 합집합을 만들어주는 함수
	static boolean union(int a, int b) {
		// 각 파라미터의 대표자를 찾기
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		// 만약 둘의 대표자가 같다면 같은 집합이므로 합집합 되지 않는다고 false 리턴해주기
		if (aRoot == bRoot) {
			return false;
		}
		
		// 대표자가 같지 않다면 한 파라미터의 배열값을 다른 파라미터의 대표값으로 설정해 합집합 만들어주고 true 리턴
		parent[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		// 노드 수, 간선 수 받아주기
		int V = Integer.parseInt(bf.readLine());
		int E = Integer.parseInt(bf.readLine());
		
		// 노드의 start, end, 가중치 값을 저장해줄 리스트 선언
		ArrayList<int[]> computer = new ArrayList<>();
		
		for (int i = 0 ; i < E ; i++) {
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			
			// start, end, 가중치를 구해 리스트에 한 배열로 만들어 추가해준다.
			// start와 end는 노드를 배열의 index와 맞추기 위해 -1한 값을 넣어준다
			int start = Integer.parseInt(st1.nextToken())-1;
			int end = Integer.parseInt(st1.nextToken())-1;
			int weight = Integer.parseInt(st1.nextToken());
			
			computer.add(new int[] {start, end, weight});
		}
		
		// 가중치를 기준으로 오름차순 정렬 해주기
		Collections.sort(computer,((o1, o2) -> Integer.compare(o1[2], o2[2])));
		
		// 각 노드를 각자 하나의 집합으로 만들어주기
		make(V);
		
		// 몇개의 간선을 지났는지 세어 저장할 변수, 지금까지의 가중치 합을 저장할 변수를 선언해준다
		int cnt = 0, sum = 0;
		
		
		for (int i = 0 ; i < computer.size() ; i++) {
			int [] c = computer.get(i);
			
			// 만약 start와 end가 하나의 집합이 아니라면
			if (union(c[0], c[1])) {
				
				// 간선을 지났으니 cnt를 +1해주기
				cnt += 1;
				
				// 가중치 값을 더해주기
				sum += c[2];
				
				// 만약 cnt가 노드 갯수 - 1이라면 모든 노드를 다 탐색한것이므로 반복문 종료
				if (cnt == V - 1) {
					break;
				}
			}
		}
		
		// 가중치 값 출력해주기
		System.out.println(sum);
	}

}
