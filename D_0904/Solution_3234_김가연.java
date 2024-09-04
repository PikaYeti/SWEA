package D_0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3234_김가연 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for(int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			int n = Integer.parseInt(bf.readLine());
			
			int [] arr = new int [n];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			for (int i = 0 ; i < n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int answer = 1;
			
			for (int i = n ; i > 0 ; i--) {
				
			}
			
		}

	}

}
