package D0925;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_4013_김가연 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			int k = Integer.parseInt(bf.readLine());
			int [][] magnet = new int [4][8];
			int [][] dir = new int [][] {{2, 0}, {2, 5}, {2, 5}, {0, 5}};
			int [][] ifr = new int [4][2];
			
			for (int i = 0 ; i < 4 ; i ++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < 8 ; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for (int rp = 0; rp < k ; rp ++) {
				
				for (int i = 0 ; i < 3 ; i ++) {
					if (magnet[i][dir[i][0]] != magnet[i + 1][dir[i + 1][1]]) {
						ifr[i + 1][0] = 1;
					} else {
						ifr[i + 1][0] = 0;
					}
				}
				
				StringTokenizer st = new StringTokenizer(bf.readLine());
				int m = Integer.parseInt(st.nextToken()) - 1;
				int t = Integer.parseInt(st.nextToken());
				
				if (m == 0) {
					if (t == 1) {
						ifr[m][1] = t;
						dir[m][0] = dir[m][0] - 1;
						if (dir[m][0] < 0) {
							dir[m][0] = 7;
						}
					} else {
						ifr[m][1] = t;
						dir[m][0] = dir[m][0] + 1;
						if (dir[m][0] > 7) {
							dir[m][0] = 0;
						}
					}
					

					for (int i = 1 ; i < 4 ; i++) {
						
						if (ifr[i][0] == 0) {
							break;
						}
						
						ifr[i][1] = ifr[i - 1][1] * (-1);
						
						if (ifr[i][1] == 1) {
							
							dir[i][0] = dir[i][0] - 1;
							dir[i][1] = dir[i][1] - 1;
							if (dir[i][0] < 0) {
								dir[i][0] = 7;
							}
							if (dir[i][1] < 0) {
								dir[i][1] = 7;
							}
							
						} else {

							dir[i][0] = dir[i][0] + 1;
							dir[i][1] = dir[i][1] + 1;
							if (dir[i][0] > 7) {
								dir[i][0] = 0;
							}
							if (dir[i][1] > 7) {
								dir[i][1] = 0;
							}
							
						}
					}
					
				} else if (m == 3) {
					
					if (t == 1) {
						ifr[m][1] = t;
						dir[m][1] = dir[m][1] - 1;
						if (dir[m][1] < 0) {
							dir[m][1] = 7;
						}
					} else {
						ifr[m][1] = t;
						dir[m][1] = dir[m][1] + 1;
						if (dir[m][1] > 7) {
							dir[m][1] = 0;
						}
					}
					
					for (int i = 2 ; i >= 0 ; i--) {
						
						if (ifr[i + 1][0] == 0) {
							break;
						}
						
						ifr[i][1] = ifr[i + 1][1] * (-1);
						
						if (ifr[i][1] == 1) {
							
							dir[i][0] = dir[i][0] - 1;
							dir[i][1] = dir[i][1] - 1;
							if (dir[i][0] < 0) {
								dir[i][0] = 7;
							}
							if (dir[i][1] < 0) {
								dir[i][1] = 7;
							}
							
						} else {

							dir[i][0] = dir[i][0] + 1;
							dir[i][1] = dir[i][1] + 1;
							if (dir[i][0] > 7) {
								dir[i][0] = 0;
							}
							if (dir[i][1] > 7) {
								dir[i][1] = 0;
							}
							
						}
					}
				// 1 or 2
				} 
				else {
					
					if (t == 1) {
						ifr[m][1] = t;
						dir[m][1] = dir[m][1] - 1;
						if (dir[m][1] < 0) {
							dir[m][1] = 7;
						}
					} else {
						ifr[m][1] = t;
						dir[m][1] = dir[m][1] + 1;
						if (dir[m][1] > 7) {
							dir[m][1] = 0;
						}
					}
					
					for (int i = m - 1 ; i >= 0 ; i--) {
						
						if (ifr[i + 1][0] == 0) {
							break;
						}
						
						ifr[i][1] = ifr[i + 1][1] * (-1);
						
						if (ifr[i][1] == 1) {
							
							dir[i][0] = dir[i][0] - 1;
							dir[i][1] = dir[i][1] - 1;
							if (dir[i][0] < 0) {
								dir[i][0] = 7;
							}
							if (dir[i][1] < 0) {
								dir[i][1] = 7;
							}
							
						} else {

							dir[i][0] = dir[i][0] + 1;
							dir[i][1] = dir[i][1] + 1;
							if (dir[i][0] > 7) {
								dir[i][0] = 0;
							}
							if (dir[i][1] > 7) {
								dir[i][1] = 0;
							}
							
						}
					}
					
					for (int i = m + 1 ; i < 4 ; i++) {
						
						if (ifr[i][0] == 0) {
							break;
						}
						
						ifr[i][1] = ifr[i - 1][1] * (-1);
						
						if (ifr[i][1] == 1) {
							
							dir[i][0] = dir[i][0] - 1;
							dir[i][1] = dir[i][1] - 1;
							if (dir[i][0] < 0) {
								dir[i][0] = 7;
							}
							if (dir[i][1] < 0) {
								dir[i][1] = 7;
							}
							
						} else {

							dir[i][0] = dir[i][0] + 1;
							dir[i][1] = dir[i][1] + 1;
							if (dir[i][0] > 7) {
								dir[i][0] = 0;
							}
							if (dir[i][1] > 7) {
								dir[i][1] = 0;
							}
							
						}
					}
					
				}
			}
			
			for (int i = 0 ; i < 4 ; i++) {
				System.out.println(Arrays.toString(dir[i]));
			}
		}

	}

}
