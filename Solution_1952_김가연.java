package D_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1952_김가연 {
	
	static int [] price;
	static int [] plan;
	static int money;
	static int min;
	
	static void ht(int month, int money) {
		
		if (month >= 12) {
			if (min == -1) {
				min = money;
			}
			
			if (min > money) {
				min = money;
			}
			return;
		}
		
		ht(month + 1, money + price[0] * plan[month]);
		ht(month + 1, money + price[1]);
		ht(month + 3, money + price[2]);
		ht(month + 12, money + price[3]);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case++) {

			min = -1;
			money = 0;
			price = new int[4];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0 ; i < 4 ; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			plan = new int[12];
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			for (int i = 0 ; i < 12 ; i++) {
				plan[i] = Integer.parseInt(st1.nextToken());
			}
			
			ht(0, 0);
			System.out.printf("#%d %d \n", test_case, min);
		}

	}

}
