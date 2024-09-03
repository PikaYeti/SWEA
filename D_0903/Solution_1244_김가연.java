package SWEA.D_0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1244_김가연 {
	
	// 최대값 저장 변수
	static int max;
	// 산 지도 저장할 배열
	static int [][] mt;
	// 사방탐색 방향 설정할 배열
	static int [][] dir = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	// 최대로 깎을 수 있는 높이 저장할 변수
	static int k;
	// 배열의 가로, 세로 길이 저장할 변수
	static int n;
	// 방문처리 저장할 배열 선언
	static int [][] visit;
	
	// 배열 내부인지 확인하는 함수
	static boolean ifmap(int x, int y) {
		if (((0 <= x) && (x < n)) && ((0 <= y) && (y < n))) {
			return true;
		} else {
			return false;
		}
	} 
	
	// 다음 좌표 확인할 함수
	static void climb (int x, int y, int depth, int minus) {
		
		// 방문한 값이 최대 방문 저장값보다 크다면 최대값 갱신
		if (depth > max) {
			max = depth;
		}
		
		// 방문처리해주기
		visit[x][y] = 1;
		
		// 현재 좌표에서 사방탐색 돌려주기
		for (int [] d : dir) {
			int dx = x + d[0];
			int dy = y + d[1];
			
			// 만약 배열 내부이고 방문하지 않은 곳 이라면
			if(ifmap(dx, dy) && (visit[dx][dy] != 1)) {
				
				// 그리고 현재 값보다 다음 값이 더 작다면 등산로 만들기 가능
				if (mt[x][y] > mt[dx][dy]) {
					// 재귀 호출해주기
					climb(dx, dy, depth + 1, minus);
				
				// 현재 값 보다 다음값이 더 크지만
				// 만약 깎기 사용하지 않았고 k깎을시 현재 값보다 작아진다면 깎아보기
				} else {
					if ((minus == 1) && (mt[x][y] > mt[dx][dy] - k)) {
						
						// 원래 배열 값 저장해주기
						int temp = mt[dx][dy];
						
						// k는 1부터 시작
						// 그리고 현재 칸보다 1칸 작은 숫자로 깎아야 가장 많이 돌 수 있기 때문에 현재 칸에서 -1한 값 저장
						mt[dx][dy] = mt[x][y] - 1;
						// 깎음 사용했다는 의미로 minus 0으로 재귀 호출
						climb(dx, dy, depth + 1, 0);
						// 값 원복해주기
						mt[dx][dy] = temp;
					}
				}
			}
			
		}
		// 방문처리 해제 
		visit[x][y] = 0;
		return;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			// 배열 크기 초기화
			n = Integer.parseInt(st.nextToken());
			// 배열 초기화
			mt = new int [n][n];
			
			// 얼마나 깎을 수 있는지 저장 변수 초기화
			k = Integer.parseInt(st.nextToken());
			
			// 현재 가장 높은 봉우리가 몇인지 확인하기 위한 변수 선언
			int mmax = Integer.MIN_VALUE;
			
			// 배열 돌면서 저장 + 최대 봉우리 찾아 저장해주기
			for (int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < n ; j++) {
					mt[i][j] = Integer.parseInt(st.nextToken());
					if (mt[i][j] > mmax) {
						mmax = mt[i][j];
					}
				}
			}
			
			// 최대 길이 등산로 저장할 변수 초기화
			max = -1;
			
			// 방문 배열 초기화
			visit = new int [n][n];
			
			// 배열 돌면서 최대 봉우리 만날 시 함수 호출해주기
			for (int i = 0 ; i < n ; i++) {
				for (int j = 0 ; j < n ; j++) {
					if (mt[i][j] == mmax) {
						visit[i][j] = 1;
						climb(i, j, 1, 1);
						visit[i][j] = 0;
					}
				}
			}
			
			// 테스트케이스와 최대값 출력
			System.out.printf("#%d %d \n", test_case, max);
		}

	}

}
