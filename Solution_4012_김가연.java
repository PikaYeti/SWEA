package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4012_김가연 {
	
	static boolean iffood(int [] sfood, int n) {
		
		int i = n - 1;
		
		while((i > 0) && (sfood[i - 1] >= sfood[i])) {
			--i;
		}
		
		if (i == 0) {
			return false;
		}
		
		int j = n - 1;
		while(sfood[i - 1] >= sfood[j]) {
			--j;
		}
		
		int temp = sfood[i - 1];
		sfood[i - 1] = sfood[j];
		sfood[j] = temp;
		
		int k = n - 1;
		while(i < k) {
			temp = sfood[i];
			sfood[i] = sfood[k];
			sfood[k] = sfood[i];
			i++;
			k--;
		}
		return true;
	}  

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case++) {
			
			int n = Integer.parseInt(bf.readLine());
			int [][] food = new int[n][n];
			int larr = (n * n - n) / 2;
			int [] arr = new int[larr];
			int [] sfood = new int[larr];
			
			for (int i = 0 ; i < n ; i ++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < n ; j ++) {
					food[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for (int i = 0 ; i < n - 1 ; i ++) {
				for (int j = i + 1 ; j < n ; j ++) {
					arr[cnt] = food[i][j] + food[j][i];
					cnt++;
				}
			}
			
			for (int i = larr - 1 ; i >= larr - 2 ; i--) {
				sfood[i] = 1;
			}
			
			do {
				int x = 0;
				int y = 0;
				for (int i = 0 ; i < sfood.length ; i++) {
					if (sfood[i] == 1) {
						
					}
				}
			} while(iffood(sfood, sfood.length));
			
		}

	}

}
