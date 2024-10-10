package D1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4014_김가연 {
	
	static boolean ifmap(int x, int n) {
		if ((0 <= x) && (x < n)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			int [][] arr = new int [n][n];
			
			for (int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < n ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int [] row = new int [n];
			int [] col = new int [n];
			
			for (int j = 0 ; j < n ; j++) {
				int pcnt = 1;
				boolean [] visit = new boolean [n];
				for (int i = 0 ; i < n - 1 ; i++) {
					
					if (col[j] < 0) {
						break;
					}
					
					if (!visit[i]) {
						
						if (Math.abs(arr[i][j] - arr[i + 1][j]) == 1) {
							if (arr[i][j] > arr[i + 1][j]) {
								
								int rcnt = 1;
								
								for (int k = i + 1 ; k < (i + 1 + x) ; k++) {
									if(ifmap(k, n) && ifmap(k + 1, n)) {
										if (arr[k][j] == arr[k + 1][j]) {
											visit[k] = true;
											rcnt += 1;
										} else {
											break;
										}
									}
								}
								
								if (rcnt < x) {
									col[j] = -1;
								} else {
									pcnt = 1;
								}
								
							} else {
								if (pcnt < x) {
									col[j] = -1;
								} else {
									visit[i] = true;
									pcnt = 1;
								}
							}
						} else if (arr[i][j] == arr[i + 1][j]) {
							visit[i] = true;
							pcnt += 1;
						} else {
							col[j] = -1;
						}
					}

				}
			}
			
//			System.out.println(Arrays.toString(col));
			
			for (int i = 0 ; i < n ; i++) {
				int pcnt = 1;
				boolean [] visit = new boolean [n];
				for (int j = 0 ; j < n - 1 ; j++) {
					
					if (row[i] < 0) {
						break;
					}
					
					if (!visit[j]) {
						
						if (Math.abs(arr[i][j] - arr[i][j + 1]) == 1) {
							if (arr[i][j] > arr[i][j + 1]) {
								
								int rcnt = 1;
								
								for (int k = j + 1 ; k < (j + 1 + x) ; k++) {
									if((ifmap(k, n)) && (ifmap(k+1, n))) {
										if (arr[i][k] == arr[i][k + 1]) {
											visit[k] = true;
											rcnt += 1;
										} else {
											break;
										}
									}
								}
								
								if (rcnt < x) {
									row[i] = -1;
								} else {
									pcnt = 1;
								}
								
							} else {
								if (pcnt < x) {
									row[i] = -1;
								} else {
									pcnt = 1;
								}
							}
						} else if (arr[i][j] == arr[i][j + 1]) {
							pcnt += 1;
						} else {
							row[i] = -1;
						}
						
					}
				}
			}
			
//			System.out.println(Arrays.toString(row));
			
			int answer = 0;
			for (int i = 0 ; i < n ; i ++) {
				if (col[i] != -1) {
					answer += 1;
				}
				
				if (row[i] != -1) {
					answer += 1;
				}
			}
			
			System.out.printf("#%d %d \n", test_case, answer);

		}
	}

}
