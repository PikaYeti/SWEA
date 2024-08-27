package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1486_김가연 {
	
	static int [] arr;
	// 정답 출력할 변수 설정
	static int min;
	// 장훈이의 키 저장할 변수 설정
	static int b;
	
	static void set(boolean [] visit, int n, int r) {
		// 만약 숫자 끝까지 도달했다면
		if (r == n) {
			int a = 0;
			// 방문한곳이 true인 곳의 직원 키 더해주기
			for (int i = 0 ; i < visit.length ; i++) {
				if (visit[i]) {
					a += arr[i];
				}
			}
			
			// 쌓아진 직원 탑이 장훈이 키보다 크고 최솟값이 저장되어 있지 않을 때 저장
			if ((min == -1) && ((a - b) >= 0)) {
				min = a - b;
			}
			// 쌓아진 직원 탑이 장훈이 키보다 크고 현재 저장되어있는 값보다 작을때 저장
			if (((a - b) >= 0) && (min > (a - b))) {
				min = (a - b);
			}
			
			return;
		}
		
		visit[r] = true;
		set(visit, n, r+1);
		
		visit[r] = false;
		set(visit, n, r+1);
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			min = -1;
			// 직원들의 키를 저장할 배열 생성
			arr = new int[n];
			// 조합 방문했는지 체크할 배열 설정
			boolean [] visit = new boolean[n];
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			for (int i = 0 ; i < n ; i ++) {
				arr[i] = Integer.parseInt(st1.nextToken());
			}
			// 조합 함수 호출
			set(visit, n, 0);
			System.out.printf("#%d %d \n", test_case, min);
		}
	}

}
