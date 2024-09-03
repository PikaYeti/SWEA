package SWEA.D_0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * DP이용한 문제풀이법
 * 위 왼쪽 대각선위쪽 배열 더해주기
 */
public class Pipe4 {
	
	static int n;
	static int [][] save;
	// 왼쪽, 위쪽, 대각선 위쪽에서 값을 받아 더해주면 현재 좌표의 값이 됨
	static int [][] dir = new int [][] {{0, 1}, {1, 1}, {1, 0}};
	static int [][] sdir = new int [][] {{0, -1}, {-1, -1}, {-1, 0}};
	
	static boolean ifmap(int x, int y) {
		if (((0 <= x) && (x < n)) && ((0 <= y) && (y < n))) {
			return true;
		} else {
			return false;
		}
	}
	
	static boolean ifwall(int x, int y) {
		if (save[x][y] != 1) {
			return true;
		} else {
			return false;
		}
	}
	
	static boolean ifswall(int x, int y) {
		for (int i = 0 ; i < 3 ; i++) {
			int dx = x + sdir[i][0];
			int dy = y + sdir[i][1];
			if (ifmap(dx, dy)) {
				if (save[dx][dy] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		
		// 받아올 배열 값 저장할 배열
		save = new int [n][n];

		
		for (int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0 ; j < n ; j++ ) {
				save[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// DP값 저장할 배열
		long [][] w = new long [n][n];
		long [][] h = new long [n][n];
		long [][] s = new long [n][n];
		w[0][1] = 1;
		
		s[0][1] = 1;
		w[0][1] = 1;
		
		// 어차피 y = 0 값은 [0][0]에서 수직으로 내려갔을때만 갈 수 있는데 [0][0]에선 아무곳도 갈 수 없으므로 애초에 반복문 안돌리기
		for (int i = 0 ; i < n ; i++) {
			for (int j = 1 ; j < n ; j++) {
				for (int k = 0 ; k < 3 ; k++) {
					int dx = i + dir[k][0];
					int dy = j + dir[k][1];
					// 가로
					if(ifmap(dx, dy) && ifwall(dx, dy)) {
						if (k == 1) {
							// 가로일때 바로 오른쪽 원소에 나 자신 가로에서 받은것, 대각선 방향에서 받은것 보내주기
							w[dx][dy] = s[i][j] + w[i][j];
						} else if (k == 2) { // 대각선
							// 대각선일때는 받은거 다 보내주기
							s[dx][dy] = w[i][j] + s[i][j] + h[i][j];
						} else { // 세로
							// 세로일때는 바로 아래쪽 원소에 나 자신 세로에서 받은것, 대각선 방향에서 받은것 보내주기
							if (ifswall(dx, dy)) {
								h[dx][dy] = h[i][j] + s[i][j];
							}
						}
					}
				}
			}
		}
		

		for(int i = 0 ; i < n ; i++) {
			System.out.println(Arrays.toString(s[i]));
		}
		
		System.out.println(h[n-1][n-1] + w[n-1][n-1] + s[n-1][n-1]);
		
	}

}
