package SWEA.D_0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pipe3 {
	
	static int n;
	static int [][] save;
	static int [][] sdir = new int [][] {{0, -1}, {-1, -1}, {-1, 0}};
	static long [][] pipe;
	
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
	
	// 가로
	static void w(int x, int y) {
		if  (ifwall(x, y)) {
			pipe[x][y] += 1;
			if ((x == n - 1) && (y == n - 1)) {
				return;
			}
			if (y == n - 1) {
				return;
			}
			w(x, y + 1);
			s(x + 1, y + 1);
		}
		return;
	}
	
	// 세로
	static void h(int x, int y) {
		if (ifwall(x, y)) {
			pipe[x][y] += 1;
			if (ifmap(x + 1, y)) {
				h(x + 1, y);
			}
			if (y == n - 1) {
				return;
			}
			s(x + 1, y + 1);
		}
		return;
	}
	
	//대각선
	static void s(int x, int y) {
		if (ifmap(x, y)) {
			if (ifwall(x, y) && ifswall(x, y)) {
				pipe[x][y] += 1;
				if ((x == n - 1) && (y == n - 1)) {
					return;
				}
				if (ifmap(x + 1, y)) {
					h(x + 1, y);
				}
				if (y == n - 1) {
					return;
				}
				w(x, y + 1);
				s(x +1, y +1);
			}
		}
		return;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		
		// 받아올 배열 값 저장할 배열
		save = new int [n][n];
		pipe = new long[n][n];
		
		for (int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0 ; j < n ; j++ ) {
				save[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		w(0, 1);

		for (int i = 0 ; i < n ; i++) {
			System.out.println(Arrays.toString(pipe[i]));
		}
		
		System.out.println(pipe[n-1][n-1]);
	}

}
