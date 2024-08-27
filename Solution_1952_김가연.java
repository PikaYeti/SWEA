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
	
	// 몇달인지 달과 회원권 총 금액값이 얼마인지를 인수로 받아준다
	static void ht(int month, int money) {
		
		// 만약 달이 12를 넘어간다면
		if (month >= 12) {
			if (min == -1) {
				min = money;
			}
			// 현재 설정된 최솟값과 비교하고 값 저장
			if (min > money) {
				min = money;
			}
			return;
		}
		
		// 각 달이 1일권, 1달권, 3달권, 1년권인 경우별로 계산하기
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
			
			// 0달, 0원 시작으로 함수를 호출한다
			ht(0, 0);
			System.out.printf("#%d %d \n", test_case, min);
		}

	}

}
