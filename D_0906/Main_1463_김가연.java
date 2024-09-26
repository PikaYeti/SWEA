package SWEA.D_0906;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_김가연 {
	
	static int min;
	
	static void one (int n, int cnt) {
		
		if (cnt > min) {
			return;
		}
		
		if (n < 1) {
			return;
		}
		
		if (n == 1) {
			
			if (cnt < min) {
				min = cnt;
			}
			
			return;
		}
		
		if (n % 3 == 0) {
			one(n/3, cnt + 1);
		}
		
		if (n % 2 == 0) {
			one(n /2, cnt + 1);
		}
		
		one(n - 1, cnt + 1);
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int cnt = 0;
		
		min = Integer.MAX_VALUE;
		
		one(n, cnt);
		
		System.out.println(min);

	}

}
