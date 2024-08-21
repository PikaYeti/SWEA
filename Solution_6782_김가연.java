package D_0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_6782_김가연 {
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			long n = Long.parseLong(bf.readLine());
			int cnt = 0;
			//어떤 정수가 어떤 수의 제곱일때까지 +1해주고
			// 제곱수에 도착하면 루트로 제곱근을 구해준다
			// 이 두 가지 과정 반복하다보면 2에 도착
			while ((n != 2)) {
				// sqrt에 
				long sqrt = (long)Math.sqrt(n);
				
				// n의 제곱근을 제곱한것이 n과 같다면 -> 어떤 수의 제곱이라면
				if (sqrt * sqrt == n) {
					// n을 n의 제곱근으로 설정
					n = sqrt;
					// 시행횟수 1회 늘려주기
					cnt += 1;
				} else {
					// 다음 정수 제곱근에서 현재 숫자를 빼주면 +1을 해야할 cnt 구할 수 있음
					sqrt += 1;
					cnt += sqrt * sqrt - n;
					
					// 제곱근 서로 곱하여 현재 n 설정
					n = sqrt * sqrt;

					
				}
			}
			
			// 시행 횟수 출력
			System.out.printf("#%d %d \n", test_case, cnt);
		}
		
	}

}
