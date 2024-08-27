package D_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1861_김가연 {
	
	static int [][] room;
	static int [][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int n;
	
	// 사방 탐색이 배열을 벗어나는지 확인
	static boolean ifroom(int x, int y) {
		if (((0 <= x) && (x < n)) && ((0 <= y) && (y < n))) {
			return true;
		} else {
			return false;
		}
	}
	
	// 만약 사방탐색 중 +1 조건을 만족하는 좌표를 만나면 그 즉시 사방탐색 중 몇번째인지 리턴 존재하지 않으면 -1 리턴
	static int wdir(int [] loc) {
		for (int i = 0 ; i < dir.length ; i++) {
			int dx = loc[0] + dir[i][0];
			int dy = loc[1] + dir[i][1];
			if (ifroom(dx, dy)) {
				if ((room[loc[0]][loc[1]] + 1) == room[dx][dy]) {
					return i;
				}
			}
		}
		return -1;
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case++) {
			
			n = Integer.parseInt(bf.readLine());
			room = new int[n][n];

			
			// 이어지는 다음 좌표 찾기위한 큐 선언
			Queue<int[]> vque = new LinkedList<>();
			
			for (int i = 0 ; i < n ; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < n ; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int [] a;
			int next;
			// 최댓값 시작 좌표 저장하기 위한 변수 선언
			int num = -1;
			// 이동할 수 있는 최댓값 저장하기 위한 변수 선언
			int maxcnt = -1;
			

			for (int i = 0 ; i < n ; i ++) {
				for (int j = 0 ; j < n ; j ++) {
					// 이동가능한 방 저장하기 위한 변수 선언
					int cnt = 0;
					vque.add(new int[] {i, j});
					while(!vque.isEmpty()) {
						cnt += 1; // 이동할 수 있는 방에 현재 좌표도 포함해야 하므로 큐에서 빼주며 cnt + 1
						a = vque.poll();
						// 사방탐색 중 만족하는 좌표가 있는지 확인하는 함수 호출
						next = wdir(a);
						// 만약 widr 리턴값이 -1이 아니면 조건을 만족하는 좌표가 있는것이므로 그 좌표 다시 큐에 넣기
						if (next != -1) {
							vque.add(new int[] {a[0] + dir[next][0], a[1] + dir[next][1]});
						}
					}

					// 만약 num과 maxcnt에 값이 저장되어 있지 않은 상태라면 값 넣어 초기화
					if (num == - 1 && maxcnt == -1) {
						num = room[i][j];
						maxcnt = cnt;
					}
					
					// 만약 현재 좌표 이동값이 저장된 최댓값보다 크다면
					if (cnt > maxcnt) {
						// 이동값과 시작 좌표 저장
						num = room[i][j];
						maxcnt = cnt;
					// 만약 현재 좌표 이동값이 최댓값과 같고
					} else if (maxcnt == cnt) {
						// 시작좌표가 저장된 최댓값 시작 좌표보다 작다면
						if (room[i][j] < num) {
							// 현재 시작 좌표 최댓값 시작 좌표에 저장
							num = room[i][j];
						}
					}
				}
			}
			// 출력
			System.out.printf("#%d %d %d \n", test_case, num, maxcnt);
			
		}

	}

}
