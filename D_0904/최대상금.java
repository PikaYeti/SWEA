package SWEA.D_0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대상금 {
	
	static int swapCount, answer;
	
	static void goSwap(int depth) {

		if(swapCount == depth) {
			return;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		/*
		 * 조합 이용 -> 각 자리마다 nCr의 경우의 수를 가짐 -> 어마무시한 경우의 수 등장 -> 완탐시 시간 초과
		 * 백트래킹 사용하여 가지치기하기 or 이미 계산한 건에 대해서는 다시 계산하지 X -> DP의 메모리제이션
		 * DP사용하여 푸는 풀이
		 */
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			// 초기화
			char [] numbers = st.nextToken().toCharArray();
			swapCount = Integer.parseInt(st.nextToken());
			answer = Integer.MIN_VALUE;
			
			goSwap(0);
		}

	}

	

}
