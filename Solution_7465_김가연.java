package D_0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7465_김가연 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			// 마을 사람 수를 받아 마을 사람 수 만큼 노드를 가진 그래프를 생성한다.
			int n = Integer.parseInt(st.nextToken());
			ArrayList[] frd = new ArrayList[n];
			for (int i = 0 ; i < n ; i++) {
				frd[i] = new ArrayList<Integer>();
			}
			// 각 노드를 방문했는지 확인할 방문 배열을 만들어준다.
			boolean [] visit = new boolean [n];
			
			// 마을 사람간의 관계를 그래프에 표시해 준다
			int m = Integer.parseInt(st.nextToken());
			for (int i = 0 ; i < m ; i++) {
				StringTokenizer st1 = new StringTokenizer(bf.readLine());
				
				// 배열 인덱스에 맞추기 위해 -1 해준다
				int front = Integer.parseInt(st1.nextToken()) - 1;
				int back = Integer.parseInt(st1.nextToken()) - 1;
				
				// 서로 알고 있는 양방향이기 때문에 front, back을 뒤집어서도 한번 넣어준다
				frd[front].add(back);
				frd[back].add(front);
			}
			
			// 노드와 이어진 관계들을 저장할 큐를 선언
			Queue<Integer> muri = new LinkedList<>();
			// 정답을 저장할 변수 선언
			int answer = 0;
			
			// 마을 사람 수 만큼 for문 돌려주기
			for (int i = 0 ; i < n ; i++) {
				// 만약 방문하지 않은 노드라면
				if (!visit[i]) {
					// 큐에 추가하고 방문 표시 해주기
					muri.add(i);
					visit[i] = true;
					
					// 큐가 빌 때까지 -> 현재 노드에서 갈 수 있는 노드를 모두 방문할때까지
					while(!muri.isEmpty()) {
						int citizen = muri.poll();
						
						for (int j = 0 ; j < frd[citizen].size() ; j++) {
							// 현재 노드에서 갈 수 있는 곳이 방문한 곳이 아니라면
							if(!visit[(int) frd[citizen].get(j)]) {
								// 큐에 추가하고 방문처리 해주기
								muri.add((int) frd[citizen].get(j));
								visit[(int) frd[citizen].get(j)] = true;
							}
						}
					}
					// 갈 수 있는 모든 노드를 방문했으므로 1무리로 셀 수 있음 +1
					answer += 1;
				}
			}
			// 테스트케이스와 정답 출력해주기
			System.out.printf("#%d %d \n", test_case, answer);
			
		}

	}

}
