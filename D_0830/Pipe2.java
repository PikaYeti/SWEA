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
public class Pipe2 {
	
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
		long [][] arr = new long [n][n];
		arr[0][1] = 1;
		
		
		
		// 어차피 y = 0 값은 [0][0]에서 수직으로 내려갔을때만 갈 수 있는데 [0][0]에선 아무곳도 갈 수 없으므로 애초에 반복문 안돌리기
		for (int i = 0 ; i < n ; i++) {
			for (int j = 1 ; j < n ; j++) {
				// 만약 첫번째줄일 경우 [0][1]칸이 가로파이프라 가로 파이프로밖에 옮길 수 없고
				// 가로파이프는 가로, 대각선 아래로만 옮길 수 있으므로 가로, 대각선 아래로만 더해주기
				if (i == 0) {
					for (int k = 0 ; k < 2 ; k ++) {
						int dx = i + dir[k][0];
						int dy = j + dir[k][1];
						// 만약 대각선 아래 방향으로 가려면 오른쪽, 좌, 대각선 아래 자리가 비어있어야 하므로 조건 하나 더 추가
						if (k != 1) {
							if (ifmap(dx, dy)) {
								if (ifwall(dx, dy)) {
									arr[dx][dy] += arr[i][j];
								}
							}
						} else {
							if (ifmap(dx, dy)) {
								if (ifwall(dx, dy)) {
									if (ifswall(dx, dy)) {
										arr[dx][dy] += arr[i][j];
									}
								}
							}
						}
					}
				}
				else {
					if (j > 3) {
						for (int [] d : dir) {
							int dx = i + d[0];
							int dy = j + d[1];
							if ((d[0] != 1) && (d[1] != 1)) {
								if (ifmap(dx, dy)) {
									if (ifwall(dx, dy)) {
										arr[dx][dy] += arr[i][j];
									}
								}
							// 만약 대각선 아래 방향으로 가려면 오른쪽, 좌, 대각선 아래 자리가 비어있어야 하므로 조건 하나 더 추가
							} else {
								if (ifmap(dx, dy)) {
									if (ifwall(dx, dy)) {
										if (ifswall(dx, dy)) {
											arr[dx][dy] += arr[i][j];
										}
									}
								}
							}
						}
					} else {
						for (int k = 1 ; k < 3 ; k ++) {
							int dx = i + dir[k][0];
							int dy = j + dir[k][1];
							// 만약 대각선 아래 방향으로 가려면 오른쪽, 좌, 대각선 아래 자리가 비어있어야 하므로 조건 하나 더 추가
							if (k != 1) {
								if (ifmap(dx, dy)) {
									if (ifwall(dx, dy)) {
										arr[dx][dy] += arr[i][j];
									}
								}
							} else {
								if (ifmap(dx, dy)) {
									if (ifwall(dx, dy)) {
										if (ifswall(dx, dy)) {
											arr[dx][dy] += arr[i][j];
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println();

		for(int i = 0 ; i < n ; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		System.out.println(arr[n-1][n-1]);
		
	}

}
