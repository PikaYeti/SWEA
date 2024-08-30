package D_0830;

import java.util.Arrays;
import java.util.Scanner;

public class PrimTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점 수 입력
		int [][] adjMatrix = new int[V][V];
		boolean [] visit = new boolean[V]; // 방문여부 배열 (방문O -> 트리에 포함된 노드)
		int [] minEdge = new int[V]; // 자신과 타정점들 간 간선 비용 중 최소 간선 비용

		for (int i = 0 ; i < V ; i++) {
			for (int j = 0 ; j < V ; j++) {
				adjMatrix[i][j] = sc.nextInt();
			}
		}
		
		//최소 값으로 계속 갱신으르 해야하기 때문에 MAX값으로 초기화
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[0] = 0; // 트리의 시작 정점 설정 -> 임의로 0을 줬음
		
		int cost = 0; //비용 저장할 변수 선언
		// 전체 노드를 순회해야 하므로 V번 반복 실행
		int i = 0;
		for (i = 0 ; i < V ; i++) {
			// V번을 다 돌지 못하면 최소 신장트리 불가
			
			// step 1 : 트리 구성에 포함된 가장 유리한 정점 선택 (비트리 정점 중 최소비용 간선의 정점 선택)
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			
			for (int j = 0 ; j < V ; j++) {
				if (visit[j]) continue; // 이미 트리의 정점이라면 건너 뛰기
				if (min > minEdge[j]) { // 트리에 속하지 않은 정점들 중 그 노드 간선의 비용이 현재 저장된 최소 간선비용보다 작다면
					minVertex = j; // 현재 노드 번호 저장하고
					min = minEdge[j]; // 최솟값 저장
				}
			}
			
			// 만약 조건을 만족하는 노드가 없었다면 않았다면 종료
			if (minVertex == -1) break;
			visit[minVertex] = true; // 트리에 추가했다고 추가하기
			cost += min;
			// step2 : 선택된 점정과 다른 정점들 간선 비용 비교하기 (간보기)
			
			// 비트리정점이면서 && 그 비트리정점의 최소 간선 비용 && 현재 
			for (int j = 0 ; j < V ; j ++) {
				
			}
			
		}
		System.out.println( i == V ? cost : -1);
	}

}
