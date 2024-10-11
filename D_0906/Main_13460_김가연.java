package D1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13460_김가연 {
	
	static boolean flag;
	
	static int[] ifarr(int rx, int ry, int bx, int by, int d) {
		if (d == 0) {
			if (rx < bx) {
				return new int[] {rx, ry, bx, by};
			} else {
				return new int[] {bx, by, rx, ry};
			}
		} else if (d == 1) {
			if (rx > bx) {
				return new int[] {rx, ry, bx, by};
			} else {
				return new int [] {bx, by, rx, ry};
			}
		} else if (d == 2) {
			if (ry < by) {
				return new int[] {rx, ry, bx, by};
			} else {
				return new int[] {bx, by, rx, ry};
			}
		} else {
			if (ry > by) {
				return new int[] {rx, ry, bx, by};
			} else {
				return new int[] {bx, by, rx, ry};
			}
		}
	}
	
	static void gogame(int rx, int ry, int bx, int by, int depth, char [][] game) {
		
		if (depth == 10) {
			return;
		}
		
		char [][] cgame = new char [game.length][game[0].length];
		for (int i = 0 ; i < game.length ; i++ ) {
			for (int j = 0 ; j < game[0].length ; j++) {
				cgame[i][j] = game[i][j];
			}
		}
		
		int lx = 0, ly = 0;
		int sx = 0, sy = 0;
		
		if (depth == 0) {
			
		}
		
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		char [][] game = new char [r][c];
		
		int rx = 0, ry = 0;
		int bx = 0, by = 0;
		
		for (int i = 0 ; i < r ; i++) {
			String line = bf.readLine();
			for (int j = 0 ; j < c ; j++) {
				game[i][j] = line.charAt(j);
				
				if (game[i][j] == 'R') {
					rx = i;
					ry = j;
				} else if (game[i][j] == 'B') {
					bx = i;
					by = j;
				}
			}
		}
		
		int [][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		for (int i = 0 ; i < 4 ; i++) {
			
			int dx = dir[i][0] + rx;
			int dy = dir[i][1] + ry;
			
			if (game[dx][dy] != '#') {
				
				int [] d = ifarr(rx, ry, bx, by, i);
				
			}
			
		}
		
	}

}
