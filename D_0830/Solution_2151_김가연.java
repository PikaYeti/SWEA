package D_0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_2151_김가연 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			int V = Integer.parseInt(bf.readLine());
			double [][] nodel = new double [V][2];
			
			// 그 노드에 방문했는지 체크할 방문 배열 선언
			boolean [] visit = new boolean[V];
			
			// 각 노드에서 갈 수 있는 최소값 가중치를 저장할 배열 선언
			double [] minEdge = new double [V];
			// 계속 최솟값을 저장하기 위해 int의 최대값으로 배열 초기화
			Arrays.fill(minEdge, Double.MAX_VALUE);
			// 0부터 시작해주기 위해 시작 노드 설정
			minEdge[0] = 0;
			
			for (int i = 0 ; i < 2 ; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < V ; j++) {
					nodel[j][i] = Double.parseDouble(st.nextToken());
				}
			}
			
			// 환경 부담금 받아줄 변수 선언
			double E = Double.parseDouble(bf.readLine());
	
			
//			ArrayList[] land = new ArrayList[V];
//			for (int i = 0 ; i < V ; i++) {
//				land[i] = new ArrayList<double[]>();
//			}
//			
//			Collections.sort(land[i], (a, b) -> Double.compare(((double[]) a)[2], ((double[]) b)[2])); 
			
			
			// 노드 갯수만큼 그래프 만들어주기
			ArrayList<double []>[] island = new ArrayList[V];
			for (int i = 0 ; i < V ; i++) {
				// 이어지는 노드, 더블값인 가중치 받아주기 위해 더블 배열로 설정하기
				island[i] = new ArrayList<double []>();
			}
			
			for (int i = 0 ; i < V ; i ++) {
				for (int j = i + 1 ; j < V ; j++) {
					// 두 노드 사이의 거리 구해 환경부담금 만들어주기
					double x = Math.pow(Math.abs(nodel[i][0] - nodel[j][0]), 2);
					double y = Math.pow(Math.abs(nodel[i][1] - nodel[j][1]), 2);
					double weight = E * (x + y);
					
					// 양방향으로 넣기 위해 앞노드 리스트에 [뒷노드, 환경부담금] 배열로 만들어 담아주기
					// 뒷노드 리스트에 [앞노드, 환경부담금] 배열로 만들어 담아주기
					island[i].add(new double[] {j, weight});
					island[j].add(new double[] {i, weight});
					
				}
				// 환경부담금을 기준으로 오름차순 정렬 해주기
				Collections.sort(island[i], (o1, o2) -> Double.compare(o1[1], o2[1])); 
			}
			
//			for (int i = 0 ; i < V ; i++) {
//				System.out.println(i);
//				for (int j = 0 ; j < island[i].size() ; j++) {
//					
//					System.out.println(Arrays.toString(island[i].get(j)));
//				}
//			}
			
			
			// 최소 가중치를 더해줘 최솟값을 저장할 변수 선언
			double cost = 0;
			
			int i = 0;
			// V번을 다 돌지 않으면 최소신장트리 불가능
			for (i = 0 ; i < V ; i++) {
				
				// 최소값 찾아주기 위해 처음에는 max값으로 초기화
				double min = Double.MAX_VALUE;
				
				// 현재 무슨 노드를 돌고있는지 확인할 변수 선언
				// 만약 반복문을 다 돌아도 -1이 저장되어 있다면 최소신장트리가 불가능한 그래프
				int node = -1; 
				
				for (int j = 0 ; j < V ; j++) {
					// 만약 방문하지 않은 노드이고
					if (!visit[j]) {
						// 최솟값보다 현재 노드의 최솟값이 더 작다면
						if (min > minEdge[j]) {
							// j를 노드에 저장해주고 최솟값에 현재 노드의 최솟값을 저장해준다
							node = j;
							min = minEdge[j];
						}
					}
				}
				
				
				// 만약 노드가 저장되지 않고 그대로라면 그대로 종료하기
				if (node == -1) {
					break;
				}
				
				// 조건을 만족하는 노드가 있었다면 방문처리 해주고 최솟값을 더해준다
				visit[node] = true;
				cost += min;
				
				// 해당 노드에서 이어진 노드들을 하나하나 탐색해주기
				for (int k = 0 ; k < island[node].size() ; k++) {
					double [] n = island[node].get(k);
					// 이어진 노드가 방문하지 않았고, 현재 배열에 저장된 최솟값이 현재 탐색된 값보다 크다면
					if((!visit[(int) n[0]]) && (minEdge[(int) n[0]] > n[1])) {
						// 현재 탐색된 값 최솟값으로 설정하기
						minEdge[(int) n[0]] = n[1];
					}
				}				
			}
			
			// 구해진 최솟값 출력해주기
			System.out.printf("#%d %.0f \n",test_case, cost);

		}

	}

}
