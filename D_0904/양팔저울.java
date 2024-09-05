package SWEA.D_0904;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class 양팔저울 {
	
	static int N, visit, answer;
	static int [] weight = new int [9];
	// 뽑은 값과 현재 depth
	static int [][] dp;

	public static void main(String[] args) {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case =  1 ; test_case <= tc ; test_case ++) {
			
			N = Integer.parseInt(bf.readLine());
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int sum = 0;
			for (int i = 0 ; i < N ; i ++) {
				weight[i] = Integer.parseInt(st.nextToken());
				sum += weight[i];
			}
			
		}

	}

}
