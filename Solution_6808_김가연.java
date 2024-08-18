package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6808_김가연 {
	
	static int gwin = 0; // 재귀함수 사용하기 위해 규영이 승리 / 패배 횟수 전역변수로 선언
	static int glose = 0;
	
	static void permutation(int[] iy, int[] in, boolean[] visit, Integer[] gyu, int cnt, int n, int r) {
		// 재귀로 순열 구하는 함수		
		if (cnt == r) {
			int gsum = 0, isum = 0; // 총점 계산할 변수 선언
			for (int j = 0 ; j < 9 ; j ++) { // 순열 배열 돌아가며 원래 규영이의 배열과 비교하여 점수 구하기
				if (gyu[j] > in[j]) {
					gsum = gsum + gyu[j] + in[j];
				} else {
					isum = isum + gyu[j] + in[j];
				}
			}
			if (gsum > isum) { // 규영이의 점수와 인영이의 점수 비교
				gwin++;
			} else {
				glose++;
			}
		}
		
		for (int i= 0 ; i < n; i++) {
			if (visit[i] != true) {
				visit[i] = true;
				in[cnt] = iy[i];
				permutation(iy, in, visit, gyu, cnt + 1, n, r);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(bf.readLine());
		
		for (int i = 0 ; i < TC ; i++) {
			
			
			gwin = 0; // 테스트케이스마다 규영이 승리 / 패배 횟수 초기화
			glose = 0;
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			Integer [] gyu = new Integer[9]; 
			int [] iy = new int[9];
			boolean [] visit = new boolean[9];
			int [] in = new int[9];
			
			for (int j = 0 ; j < 9 ; j ++) {
				gyu[j] = Integer.parseInt(st.nextToken());
			}
			
			int tmp = 0;
			
			for (int j = 1 ; j <= 18 ; j ++) {
				if (!Arrays.asList(gyu).contains(j)) { // 1- 18까지 돌며 규영이의 배열에 포함되어 있지 않으면 인영이의 배열에 추가
					iy[tmp] = j;
					tmp++;
				}
			}

			permutation(iy, in, visit, gyu, 0, 9, 9); // 재귀함수 호출하기
			System.out.printf("#%d %d %d \n", TC, gwin, glose);
		}

	}

}