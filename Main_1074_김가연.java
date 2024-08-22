package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1074_김가연 {
	
	static int cnt = 0;
	static int r, c;
	


	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		// 구해야할 좌표 x, y값 저장할 변수 선언
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		//분할정복 하기 위해 half 변수에 한 변의 길이 저장
		int half = (int)Math.pow(2, n);
		int row = 0;
		int col = 0;
		// 좌표값에 들어갈 값 -> 탐색 순번 저장할 변수 선언
		cnt = 0;
		
		

		// 좌표는 2 -> 1-> 3 -> 4 사분면 순서대로 채워짐
		while (half >= 2) {
			// 분할정복 half 계속 나눠주기
			half = half / 2;
			// 만약 좌표가 1, 2 사분면에 속해있다면
			if ((row <= r) && (r < (row + half))) { 
				// 2사분면
				if ((col <= c) && (c < (col + half))) { 
					row = row;
					col = col;
				// 1사분면 -> 2사분면이 채워지고 왔기 때문에 2사분면 좌표 수 만큼 cnt에 더해줌
				} else { 
					cnt += half * half;
					row = row;
					col = col + half;
				}
			// 만약 좌표가 3, 4분면에 속해있다면
			} else { 
				// 3사분면 -> 1, 2 사분면이 채워지고 왔기 때문에 1, 2사분면 좌표수만큼 더해줌
				if ((col <= c) && (c < (col + half))) { 
					cnt += (half * half) * 2;
					row = row + half;
					col = col;
				// 4사분면 -> 1, 2, 3 채워지고 왔기 때문에 1, 2,3 좌표수 +
				} else { 
					cnt += (half * half) * 3;
					row = row + half;
					col = col + half;
				}
			}
		}
		
		// 더한 이동 수 찍어주기
		System.out.println(cnt);
	}

}
