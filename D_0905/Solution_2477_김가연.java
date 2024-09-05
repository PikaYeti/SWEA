package D_0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2477_김가연 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			// 접수 창구의 개수
			int N = Integer.parseInt(st.nextToken());
			// 정비 창구의 개수
			int M = Integer.parseInt(st.nextToken());
			// 정비소 방문 고객 수
			int K = Integer.parseInt(st.nextToken());
			// 지갑 고객이 이용한 접수 창고
			int A = Integer.parseInt(st.nextToken());
			// 지갑 고객이 이용한 정비 창고
			int B = Integer.parseInt(st.nextToken());
			
			// i번째 접수창고 접수 시 걸리는 시간 저장할 배열 설정
			int [] Ntime = new int [N];
			// 접수 창고 시간 저장
			st = new StringTokenizer(bf.readLine());
			for (int i = 0 ; i < N ; i++) {
				Ntime[i] = Integer.parseInt(st.nextToken());
			}
			
			// i번째 정비 창고 접수 시 걸리는 시간 저장할 배열 설정
			int [] Mtime = new int [M];
			// 정비 창고 시간 저장
			st = new StringTokenizer(bf.readLine());
			for (int i = 0 ; i < M ; i++) {
				Mtime[i] = Integer.parseInt(st.nextToken());
			}
			
			
		}

	}

}
