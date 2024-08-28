package D_0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_김가연 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1 ; test_case <= 10 ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			// 입력 데이터를 2개씩 끊어받기 위해 입력 데이터 길이를 /2 해주기
			int fromto = Integer.parseInt(st.nextToken()) / 2;
			
			// 데이터 1 - 100으로 들어오지만 배열 0번부터 채우기 위해 -1해서 시작점 받아주기
			int start = Integer.parseInt(st.nextToken()) - 1;
			
			// 비상연락망 어레이리스트 생성
			ArrayList[] call = new ArrayList[100];
			for (int i = 0 ; i < 100 ; i++) {
				call[i] = new ArrayList<Integer>();
			}
			// 전화가 왔는지 체크할 boolean배열 생성
			boolean [] ifcall = new boolean[100];
			
			
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			for (int i = 0 ; i < fromto ; i++) {
				
				// 2개씩 끊어 시작노드, 도착노드에 저장하기
				int from = Integer.parseInt(st1.nextToken()) - 1;
				int to = Integer.parseInt(st1.nextToken()) - 1;
				
				call[from].add(to);
			}
			
			// 마지막 연락 받을 번호 저장할 변수 생성
			int cnt = -1;
			
			// 다음 연락받을 번호 삽입할 큐 생성
			Queue<Integer> scall = new LinkedList<>();
			// 큐 사이즈 저장할 변수 선언
			int qsize;
			
			// 시작점 큐에 넣어주고 전화 받았다고 ifcall 배열에 true 체크
			scall.add(start);
			ifcall[start] = true;
			
			// 한바퀴 돌아 큐가 빌 때 까지 계속하기
			while(!scall.isEmpty()) {
				
				// 큐 사이즈와 마지막 번호 변수 초기화
				qsize = scall.size();
				cnt = -1;
				
				// 큐 사이즈 -> 동시에 연락 받는 사람들 수 / 
				for (int j = 0 ; j < qsize ; j++) {
					
					// 다른 사람에게 전화 걸 번호를 큐에서 꺼내기
					int n = scall.poll();
					
					// 현재 전화받는 사람들 중 마지막 번호 찾기
					if (cnt < n) {
						cnt = n;
					}
					
					for (int i = 0; i < call[n].size() ; i++) {
						// 만약 전화를 받지 않았다면
						if (!ifcall[(int)call[n].get(i)]) {
							// 큐에 넣어주기
							scall.add((int)call[n].get(i));
							// 다시 연락을 하지 않도록 받았다고 true체크
							ifcall[(int)call[n].get(i)] = true;
						}
					}
				}
			}
			
			// 테스트 케이스와 마지막 번호 출력
			// 배열에 맞추기 위해 -1 해줬으므로 출력할때는 +1 해주기
			System.out.printf("#%d %d \n", test_case, cnt + 1);
			
		}

	}

}
