package D_0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6109_김가연 {
	
	// 2048 게임판을 넘어갔는지 확인
	static boolean ifgame(int x, int y, int n) {
		if (((0 <= x) && (x < n)) && ((0 <= y) && (y < n))) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 0 ; test_case < tc ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			// 가로 세로 길이와 어느방향으로 밀것인지 저장할 변수 선언 후 저장
			int n = Integer.parseInt(st.nextToken());
			String dir = new String(st.nextToken());
			
			int [][] game = new int [n][n];
			for (int i = 0 ; i < n ; i ++) {
				StringTokenizer st1 = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < n ; j ++) {
					game[i][j] = Integer.parseInt(st1.nextToken());
				}
			}
			// 새로운 타일은 합쳐져서는 안되므로 새로운 타일이라는 표시 해주는 배열 생성
			int [][] visit = new int [n][n];
			
			// 왼쪽으로 밀기 -> 벽부터 가까운 쪽부터 블록을 합치기 위해 y좌표가 낮은 곳부터 돌리기
			if (dir.equals("left")) {
				for (int j  = 1 ; j < n ; j ++) {
					for (int i = 0 ; i < n ; i++) {
						int a = j;
						// 만약 앞 블럭이 0이라면 0이 아닌 블럭 뒤까지 현재 블럭 보내기
						if (game[i][a - 1] == 0) {
							while(ifgame(i, a-1, n) && (game[i][a - 1] == 0)) {
								game[i][a - 1] = game[i][a];
								game[i][a] = 0;
								a--;
							}
						}
						
						// 만약 앞 블럭이 존재하고 앞블럭이 현재 타일과 같은 숫자이면서 새롭게 생성된 타일이 아닐 때
						// 앞블럭에 현재 블럭의 수를 더해주고 현재블럭은 0으로 만들기
						// 앞블럭이 새로 생성되었으므로 새로 생성되었다고 표시
						if (ifgame(i, a - 1, n)) {
							if ((game[i][a - 1] == game[i][a]) && (visit[i][a - 1] != 1)) {
								visit[i][a - 1] = 1;
								game[i][a - 1] += game[i][a];
								game[i][a] = 0;
							}
						}
					}
				}
					
			} 
			// 오른쪽으로 밀기 -> y좌표가 가장 큰곳부터 블럭을 합치기
			else if (dir.equals("right")) {
				for (int j = n - 2 ; j >= 0 ; j --) {
					for (int i = 0 ; i < n ; i++) {
						int a = j;
						
						if (game[i][a + 1] == 0) {
							while(ifgame(i, a+1, n) && (game[i][a + 1] == 0)) {
								game[i][a + 1] = game[i][a];
								game[i][a] = 0;
								a++;
							}
						}
						
						if (ifgame(i, a + 1, n)) {
							if ((game[i][a + 1] == game[i][a]) && (visit[i][a + 1] != 1)) {
								visit[i][a + 1] = 1;
								game[i][a + 1] += game[i][a];
								game[i][a] = 0;
							}
						}
					}
				}
			// 위쪽으로 밀기 -> x좌표가 가장 작은곳부터 블럭을 합치기
			} else if (dir.equals("up")) {
				for (int i = 1 ; i < n ; i++) {
					for (int j = 0 ; j < n ; j ++) {
						int a = i;
						
						if (game[a - 1][j] == 0) {
							while(ifgame(a - 1, j, n) && (game[a - 1][j] == 0)) {
								game[a - 1][j] = game[a][j];
								game[a][j] = 0;
								a--;
							}
						}
						
						if (ifgame(a - 1, j, n)) {
							if ((game[a - 1][j] == game[a][j]) && (visit[a - 1][j] != 1)) {
								visit[a - 1][j] = 1;
								game[a - 1][j] += game[a][j];
								game[a][j] = 0;
							}
						}
					}
				}
			// 아래쪽으로 밀기 -> x좌표가 가장 먼곳부터 블럭을 합치기
			} else {
				for (int i = n - 2 ; i >= 0 ; i--) {
					for (int j = 0 ; j < n ; j ++) {
						int a = i;
						
						if (game[a + 1][j] == 0) {
							while(ifgame(a + 1, j, n) && (game[a + 1][j] == 0)) {
								game[a + 1][j] = game[a][j];
								game[a][j] = 0;
								a++;
							}
						}
						
						if (ifgame(a + 1, j, n)) {
							if ((game[a + 1][j] == game[a][j]) && (visit[a + 1][j] != 1)) {
								visit[a + 1][j] = 1;
								game[a + 1][j] += game[a][j];
								game[a][j] = 0;
							}
						}
					}
				}
			}
			
			// 최종 2048 게임판 출력
			System.out.println("#" + test_case);
			for (int i = 0 ; i < n ; i ++) {
				for (int j = 0 ; j < n ; j ++) {
					System.out.print(game[i][j] + " ");
				}
				System.out.println();
			}
			
		}

	}

}
