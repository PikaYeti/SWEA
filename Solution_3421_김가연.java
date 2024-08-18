package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3421_김가연 {
	
	static int [] barr;
	static int bgcnt;
	static ArrayList<int[]> alist = new ArrayList<>();
	
	static void combination(boolean[] visit, int d, int n) {
		// 만약 탐색을 끝까지 했다면 +1
		if (d == n) {				
			bgcnt += 1;
			return;
		}
		
		// 만약 조합이 되지않는 버거 목록들인지 체크하기 위한 변수 설정
		int inarr = 0;
		
		// 조합되지 않는 목록 중 이미 다른 번호가 true이라면 inarr++ 해서 안된다고 체크
		visit[d] = true;
		for (int [] a : alist) {
			int x = a[0] - 1;
			int y = a[1] - 1;
			if ((d == y) && (visit[x])) {
				inarr++;
			}
		}
		
		// inarr가 0일때만 다음 조합 호풀
		if (inarr == 0) {
			combination(visit, d + 1, n);
		}
		
		visit[d] = false;
		combination(visit, d + 1, n);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(bf.readLine());
		
		for (int tc = 0 ; tc < TC ; tc++) {
			
			// 조합 불가능 목록 저장하기 위한 어레이 리스트 선언
			alist = new ArrayList<>();
			// 가능한 조합 셀 변수 초기화
			bgcnt = 0;
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int bcnt = Integer.parseInt(st.nextToken());
			int hcnt = Integer.parseInt(st.nextToken());
			
			boolean [] visit = new boolean[bcnt];
			barr = new int[bcnt];
			for (int i = 0 ; i < barr.length ; i++) {
				barr[i] = i;
			}
			
			for (int i = 0 ; i < hcnt ; i++) {
				StringTokenizer st1 = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st1.nextToken());
				int y = Integer.parseInt(st1.nextToken());
				
				// [1, 3] [3, 1] 같이 중복된 안되는 조합 값 들어가는거 방지
				int cnt = 0;
				if (x <= y) {
					int [] b = new int[] {x, y};
					for (int [] a : alist) {
						if (!Arrays.equals(a, b)) {
							cnt++;
						}
					}
					if (cnt == alist.size()) {
						alist.add(b);
					}
				} else {
					int [] b = new int[] {y, x};
					for (int [] a : alist) {
						if (!Arrays.equals(a, b)) {
							cnt++;;
						}
					}
					if (cnt == alist.size()) {
						alist.add(b);
					}
				}
			}
			
			// 조합 함수 호출
			combination(visit, 0, bcnt);
			// 출력
			System.out.printf("#%d %d \n", tc, bgcnt);
			
		}

	}

}
