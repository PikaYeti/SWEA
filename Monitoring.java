package D_0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Monitoring {
	
	static int end;
	static ArrayList<int []> cctv;
	static int row, col;
	static int [][] dir = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	static int [][] monit;
	static int min;
	
	static boolean ifctv(int x, int y) {
		if (((0 <= x) && (x < row)) && ((0 <= y) && (y < col))) {
			return true;
		} else {
			return false;
		}
	}
	
	static void room(int [][] visit, int depth, int hide) {
		if (depth == end) {
			if (min == -1) {
				min = hide;
			}
			
			if (hide < min) {
				min = hide;
			}
			return;
		}
	
		int [] cc = cctv.get(depth);
		
		int cnt = 0;
				
		if (cc[2] == 1) {	
			for (int i = 0 ; i < 4 ; i++) {
				cnt = 0;
				int [][] vclone = new int[row][col];
				for (int j = 0 ; j < row ; j++) {
					for (int k = 0 ; k < col ; k++) {
						vclone[j][k] = visit[j][k];
					}
				}
				
				int dx = cc[0] + dir[i][0];
				int dy = cc[1] + dir[i][1];
				
				while(ifctv(dx, dy)) {
					if (vclone[dx][dy] == -2) {
						break;
					}
					if ((vclone[dx][dy] == -1) || (vclone[dx][dy] == 1)) {
						dx += dir[i][0];
						dy += dir[i][1];
					} else {
						vclone[dx][dy] = 1;
						cnt += 1;
						dx += dir[i][0];
						dy += dir[i][1];
					}
				}
				
				room(vclone, depth + 1, hide - cnt);
			}
			
		} else if (cc[2] == 2) {
			int [][] dir2 = {{0, 1}, {2, 3}};
			for (int [] d : dir2) {
				
				cnt = 0;
				int [][] vclone = new int[row][col];
				for (int j = 0 ; j < row ; j++) {
					for (int k = 0 ; k < col ; k++) {
						vclone[j][k] = visit[j][k];
					}
				}
				
				for (int d2 : d) {
					int dx = cc[0] + dir[d2][0];
					int dy = cc[1] + dir[d2][1];
					
					while(ifctv(dx, dy)) {
						if (vclone[dx][dy] == -2) {
							break;
						}
						if ((vclone[dx][dy] == -1) || (vclone[dx][dy] == 1)) {
							dx += dir[d2][0];
							dy += dir[d2][1];
						} else {
							vclone[dx][dy] = 1;
							cnt += 1;
							dx += dir[d2][0];
							dy += dir[d2][1];
						}
					}
				}
				room(vclone, depth + 1, hide - cnt);
			}
			
			for (int i = 0 ; i < 3 ; i+=2) {
				int dx = cc[0] + dir[i][0];
				int dy = cc[1] + dir[i][1];
				
				cnt = 0;
				int [][] vclone = new int[row][col];
				for (int j = 0 ; j < row ; j++) {
					for (int k = 0 ; k < col ; k++) {
						vclone[j][k] = visit[j][k];
					}
				}
				
				while(ifctv(dx, dy)) {
					if (vclone[dx][dy] == -2) {
						break;
					}
					if ((vclone[dx][dy] == -1) || (vclone[dx][dy] == 1)) {
						dx += dir[i][0];
						dy += dir[i][1];
					} else {
						vclone[dx][dy] = 1;
						cnt += 1;
						dx += dir[i][0];
						dy += dir[i][1];
					}
				}
				
				dx = cc[0] + dir[i+1][0];
				dy = cc[0] + dir[i+1][1];
				
				while(ifctv(dx, dy)) {
					if (vclone[dx][dy] == -2) {
						break;
					}
					if ((vclone[dx][dy] == -1) || (vclone[dx][dy] == 1)) {
						dx += dir[i + 1][0];
						dy += dir[i + 1][1];
					} else {
						vclone[dx][dy] = 1;
						cnt += 1;
						dx += dir[i + 1][0];
						dy += dir[i + 1][1];
					}
				}
				
				room(vclone, depth + 1, hide - cnt);
			}
			
		} else if (cc[2] == 3)  {
			int [][] dir3 = {{3, 0}, {0, 2}, {2, 1}, {1, 3}};
			
			for (int [] d : dir3) {
				
				cnt = 0;
				int [][] vclone = new int[row][col];
				for (int j = 0 ; j < row ; j++) {
					for (int k = 0 ; k < col ; k++) {
						vclone[j][k] = visit[j][k];
					}
				}
				
				for (int d3 : d) {
					
					int dx = cc[0] + dir[d3][0];
					int dy = cc[1] + dir[d3][1];
					
					while(ifctv(dx, dy)) {
						if (vclone[dx][dy] == -2) {
							break;
						}
						if ((vclone[dx][dy] == -1) || (vclone[dx][dy] == 1)) {
							dx += dir[d3][0];
							dy += dir[d3][1];
						} else {
							vclone[dx][dy] = 1;
							cnt += 1;
							dx += dir[d3][0];
							dy += dir[d3][1];
						}
					}
				}
				room(vclone, depth + 1, hide - cnt);
			}
		} else if (cc[2] == 4) {
			int [][] dir4 = new int[][] {{0, 1, 3}, {0, 2, 3}, {0, 2, 1}, {2, 1, 3}};
			for (int [] d : dir4) {
				
				cnt = 0;
				int [][] vclone = new int[row][col];
				for (int j = 0 ; j < row ; j++) {
					for (int k = 0 ; k < col ; k++) {
						vclone[j][k] = visit[j][k];
					}
				}
				
				for (int d4 : d) {
					int dx = cc[0] + dir[d4][0];
					int dy = cc[1] + dir[d4][1];
					
					while(ifctv(dx, dy)) {
						if (vclone[dx][dy] == -2) {
							break;
						}
						if ((vclone[dx][dy] == -1) || (vclone[dx][dy] == 1)) {
							dx += dir[d4][0];
							dy += dir[d4][1];
						} else {
							vclone[dx][dy] = 1;
							cnt += 1;
							dx += dir[d4][0];
							dy += dir[d4][1];
						}
					}
				}
				
				room(vclone, depth + 1, hide - cnt);
			}
		} else {
			
			cnt = 0;
			int [][] vclone = new int[row][col];
			for (int j = 0 ; j < row ; j++) {
				for (int k = 0 ; k < col ; k++) {
					vclone[j][k] = visit[j][k];
				}
			}
			
			for (int i = 0 ; i < 4 ; i++) {
				int dx = cc[0] + dir[i][0];
				int dy = cc[1] + dir[i][1];
				
				while(ifctv(dx, dy)) {
					if (vclone[dx][dy] == -2) {
						break;
					}
					if ((vclone[dx][dy] == -1) || (vclone[dx][dy] == 1)) {
						dx += dir[i][0];
						dy += dir[i][1];
					} else {
						vclone[dx][dy] = 1;
						cnt += 1;
						dx += dir[i][0];
						dy += dir[i][1];
					}
				}
			}
			
			room(vclone, depth + 1, hide - cnt);
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		monit = new int [row][col];
		int [][] visit = new int [row][col];
		int hide = row * col;
		
		cctv = new ArrayList<>();
		
		for (int i = 0 ; i < row ; i++) {
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			for (int j = 0 ; j < col ; j ++) {
				monit[i][j] = Integer.parseInt(st1.nextToken());
				if ((monit[i][j] != 0) && (monit[i][j] != 6)) {
					cctv.add(new int[] {i, j , monit[i][j]});
					visit[i][j] = -1;
					hide -= 1;
				} else if (monit[i][j] == 6) {
					visit[i][j] = -2;
					hide -= 1;
				}
			}
		}
		
		min = -1;
		end = cctv.size();
		room(visit, 0, hide);
		
		System.out.println(min);

	}

}
