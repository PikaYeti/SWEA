<<<<<<< HEAD
package SWEA.D_0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1494_김가연3 {
	
	/*
	 * 풀이 방법 : 조합 사용
	 * n개를 2개씩 짝지어 이어야하므로 먼저 다가갈 지렁이를 n/2마리, 가만히 있을 지렁이를 n/2개 구하기
	 * 지렁이를 조합으로 정했으면 다가갈 지렁이에서 가만히 있을 지렁이 좌표 -해주기
	 * 정답은 다가갈 지렁이 좌표 합 - 가만히 있을 지렁이 합을 구하면 답을 구할 수 있음
	 * 
	 * 벡터값 구하는 방법 : 다가갈 지렁이 좌표값 - 가만히 있을 지렁이 좌표값
	 * -> 다가갈 지렁이가 아니라면 좌표값 빼버리기
	 */
	
	// 지렁이 좌표 값 저장해 줄 배열
	static int [][] zirung;
	// 전체 지렁이가 몇마리인지
	static int n;
	// 최소값 저장해 줄 배열
	static long min;
	// 다가갈 지렁이로 골랐는지 확인할 배열
	static boolean [] visit;
	
	// 다가갈 지렁이를 고른 수, 몇번째 배열부터 시작할것인지를 파라미터로 넣기
	static void com(int cnt, int start) {
		
		// 만약 다가갈 지렁이를 n/2마리만큼 구했으면 
		if (cnt == n/2) {
			
			// 좌표값 증감해줄 변수 선언
			// 나중에 벡터값 구할 때 int범위 초과하여 long으로 선언해야 하는데 형변환 귀찮으니까 이것도 long으로 때려버리기
			long x = 0;
			long y = 0;
			
			// 다가갈 지렁이 골랐으면 배열에서 어떤 지렁이인지 구분하기 위해 반복문 돌려주기
			for (int i = 0 ; i < n ; i++) {
				
				// 만약 다가갈 지렁이로 선정되었다면 좌표값 더해주기
				if (visit[i]) {
					x += zirung[i][0];
					y += zirung[i][1];
					
				// 가만히 있을 지렁이는 좌표값 총합에서 빼주기
				} else {
					x -= zirung[i][0];
					y -= zirung[i][1];
				}
			}
			
			// 정답에서 원하는 계산식으로 계산하기
			long sum = x*x + y*y;
			
			// 현재 저장된 최소값보다 작다면 최소값으로 설정
			min = Math.min(sum, min);
			
			return;
		}
		
		// 다가갈 지렁이 구하는 반복문
		for (int i = start ; i < n ; i++) {
			if(!visit[i]) {
				visit[i] = true;
				com(cnt + 1, i + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			// 지렁이가 몇마리인지
			n = Integer.parseInt(bf.readLine());
			
			// 지렁이 좌표 배열 초기화
			zirung = new int [n][2];
			
			// 주어진 지렁이 좌표 받아주기
			for (int i = 0 ; i < n ; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				zirung[i][0] = Integer.parseInt(st.nextToken());
				zirung[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// 최소값 초기화
			min = Long.MAX_VALUE;
			// 다가갈 지렁이 체크하는 배열 초기화
			visit = new boolean[n];
			
			// 처음에는 아무 지렁이도 선택되지 않았으니까 앞에는 0, 0번째 인덱스부터 선택하고 싶으므로 뒤에는 0 넣어주기
			com(0, 0);
			
			// 테스트케이스와 정답 출력
			System.out.printf("#%d %d \n", test_case, min);
		}

	}

}
=======
package SWEA.D_0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1494_김가연3 {
	
	/*
	 * 풀이 방법 : 조합 사용
	 * n개를 2개씩 짝지어 이어야하므로 먼저 다가갈 지렁이를 n/2마리, 가만히 있을 지렁이를 n/2개 구하기
	 * 지렁이를 조합으로 정했으면 다가갈 지렁이에서 가만히 있을 지렁이 좌표 -해주기
	 * 정답은 다가갈 지렁이 좌표 합 - 가만히 있을 지렁이 합을 구하면 답을 구할 수 있음
	 * 
	 * 벡터값 구하는 방법 : 다가갈 지렁이 좌표값 - 가만히 있을 지렁이 좌표값
	 * -> 다가갈 지렁이가 아니라면 좌표값 빼버리기
	 */
	
	// 지렁이 좌표 값 저장해 줄 배열
	static int [][] zirung;
	// 전체 지렁이가 몇마리인지
	static int n;
	// 최소값 저장해 줄 배열
	static long min;
	// 다가갈 지렁이로 골랐는지 확인할 배열
	static boolean [] visit;
	
	// 다가갈 지렁이를 고른 수, 몇번째 배열부터 시작할것인지를 파라미터로 넣기
	static void com(int cnt, int start) {
		
		// 만약 다가갈 지렁이를 n/2마리만큼 구했으면 
		if (cnt == n/2) {
			
			// 좌표값 증감해줄 변수 선언
			// 나중에 벡터값 구할 때 int범위 초과하여 long으로 선언해야 하는데 형변환 귀찮으니까 이것도 long으로 때려버리기
			long x = 0;
			long y = 0;
			
			// 다가갈 지렁이 골랐으면 배열에서 어떤 지렁이인지 구분하기 위해 반복문 돌려주기
			for (int i = 0 ; i < n ; i++) {
				
				// 만약 다가갈 지렁이로 선정되었다면 좌표값 더해주기
				if (visit[i]) {
					x += zirung[i][0];
					y += zirung[i][1];
					
				// 가만히 있을 지렁이는 좌표값 총합에서 빼주기
				} else {
					x -= zirung[i][0];
					y -= zirung[i][1];
				}
			}
			
			// 정답에서 원하는 계산식으로 계산하기
			long sum = x*x + y*y;
			
			// 현재 저장된 최소값보다 작다면 최소값으로 설정
			min = Math.min(sum, min);
			
			return;
		}
		
		// 다가갈 지렁이 구하는 반복문
		for (int i = start ; i < n ; i++) {
			if(!visit[i]) {
				visit[i] = true;
				com(cnt + 1, i + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			// 지렁이가 몇마리인지
			n = Integer.parseInt(bf.readLine());
			
			// 지렁이 좌표 배열 초기화
			zirung = new int [n][2];
			
			// 주어진 지렁이 좌표 받아주기
			for (int i = 0 ; i < n ; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				zirung[i][0] = Integer.parseInt(st.nextToken());
				zirung[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// 최소값 초기화
			min = Long.MAX_VALUE;
			// 다가갈 지렁이 체크하는 배열 초기화
			visit = new boolean[n];
			
			// 처음에는 아무 지렁이도 선택되지 않았으니까 앞에는 0, 0번째 인덱스부터 선택하고 싶으므로 뒤에는 0 넣어주기
			com(0, 0);
			
			// 테스트케이스와 정답 출력
			System.out.printf("#%d %d \n", test_case, min);
		}

	}

}
>>>>>>> 349b80edafcde2d9763119b4de7c3c0af117d032
