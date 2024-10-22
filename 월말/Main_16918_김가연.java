package W_10_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 4 4 20
 * O..O
 * ....
 * O..O
 * .OO.
 */

public class Main_16918_±è°¡¿¬ {
	
	static boolean ifmap(int x, int y, int n, int m) {
		if ((0 <= x) && (x < n) && (0 <= y) && (y < m)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());
		
		Queue<int []> box = new LinkedList<>();
		
		char [][] bomb = new char [n][m];
		int [][] intb = new int [n][m];
		
		for (int i = 0 ; i < n ; i++) {
			String str = bf.readLine();
			for (int j = 0 ; j < m ; j++) {
				bomb[i][j] = str.charAt(j);
				
				if (bomb[i][j] == 'O') {
					box.add(new int[] {i, j});
				} else if (bomb[i][j] == '.') {
					intb[i][j] = 1;
				}
			}
		}
		
		int [][] dir = new int [][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		
		for (int i = 1 ; i <= time ; i++) {
			
			if (i % 2 == 0) {
				// ÆøÅº ÀÖ´Â °÷ : 0 / ÅÍÁø°÷ : 1
				intb = new int [n][m];
			} else {
				if (i != 1) {
					
					int cnt = box.size();
					for (int j = 0 ; j < cnt ; j++) {
						
						int [] b = box.poll();
						
						if (intb[b[0]][b[1]] != 1) {
							intb[b[0]][b[1]] = 1;
						}
						
						for (int [] d : dir) {
							
							int dx = d[0] + b[0];
							int dy = d[1] + b[1];
							
							if (ifmap(dx, dy, n, m) && (intb[dx][dy] == 0)) {
								intb[dx][dy] = 1;
							}
							
						}
					}
					
					for (int j = 0 ; j < n ; j++) {
						for (int k = 0 ; k < m ; k++) {
							if (intb[j][k] == 0) {
								box.add(new int[] {j, k});
							}
						}
					}
					
				}
			}
			
			for (int j = 0 ; j < n ; j++) {
				for (int k = 0 ; k < m ; k++) {
					System.out.print(intb[j][k]);
				}
				System.out.println();
			}
			
		}
		
//		for (int i = 0 ; i < n ; i++) {
//			for (int j = 0 ; j < m ; j++) {
//				if (intb[i][j] == 0) {
//					System.out.print("O");
//				} else {
//					System.out.print('.');
//				}
//			}
//			System.out.println();
//		}

	}

}
