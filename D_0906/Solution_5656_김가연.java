package D_0906;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_김가연 {
	
	// 구슬을 몇번 날릴지 저장할 변수
	static int N;
	
	// 벽돌 배열의 높이, 너비를 저장할 변수
	static int H, W;
	
	// 초기에 벽돌이 몇개있었는지를 저장할 변수
	static int sumb;
	
	// 남은 벽돌의 최소값을 저장할 변수
	static int min;
	
	
	// 만약 좌표가 배열 내부인지를 확인하는 함수
	static boolean ifmap(int x, int y) {
		if (((0 <= x) && (x < H)) && ((0 <= y) && (y < W))) {
			return true;
		} else {
			return false;
		}
	}
	
	// 벽돌배열, x좌표, y좌표, 지금까지 몇개의 구슬을 던졌는지, 현재까지 깨진 벽돌은 몇개인지
	static void bbreak(int [][] brick, int x, int y, int depth, int cnt) {
		
		// 만약 준비된 구슬을 다 던졌다면
		if (depth == N) {
			// 전체 벽돌 수에서 깬 벽돌 수를 빼주며 남은 벽돌 갯수를 세어본다
			cnt = sumb - cnt;
			
			// 남은 벽돌 개수가 현재까지 저장된 최소값보다 작으면 최소값 갱신
			if (cnt < min) {
				min = cnt;
			}
			
			return;
		}
		
		// 원본배열이 상하지 않게 배열 복사해주기
		int [][] cbrick = new int [H][W];
		
		for (int i = 0 ; i < H ; i++) {
			for (int j = 0 ; j < W ; j++) {
				cbrick[i][j] = brick[i][j];
			}
		}
		
		// 한번 들렀던 좌표는 다시 갈 수 없게 방문배열을 선언
		int [][] visit = new int[H][W];
		
		// 현재 구슬을 던질 좌표를 미리 깨 0으로 만들어주고
		cbrick[x][y] = 0;
		// 벽돌을 하나 깼으므로 깬벽돌 +1 해준다.
		cnt += 1;
		
		// 현재 벽돌을 깨 동시에 제거되는 다른 벽돌을 찾기 위한 큐를 선언해주고
		Queue<int []> bq = new LinkedList<>();
		
		// 현재 구슬을 맞은 벽돌 좌표와 그 좌표에 들어있던 벽돌 숫자를 함께 큐에 넣어준다
		bq.add(new int[] {x, y, brick[x][y]});
		
		// 현재 구슬로 인한 벽돌이 다 깨질때까지
		while(!bq.isEmpty()) {
			
			int [] b = bq.poll();
			// 현재 벽돌 좌표 방문처리 해주기
			visit[b[0]][b[1]] = 1;
			
			// 벽돌의 깨질 범위는 벽돌 숫자 - 1 만큼 상하좌우로 깨지므로 값을 설정해준다.
			int pop = b[2] - 1;
			
			// 먼저 현재 좌표 좌우로 벽돌을 깨트리기 위해 x좌표는 고정시키고 y좌표만 범위를 지정하여 반복문 돌리기
			for (int i = b[0] - pop ; i <= b[0] + pop ; i++ ) {
				
				// 만약 볌위가 배열 내부이고, 구슬 범위가 벽돌이 존재하는 위치라면
				if ((ifmap(i, b[1])) && (brick[i][b[1]] != 0)) {
					
					// 그리고 그 벽돌 위치를 다른 벽돌이 깨지며 치고가지 않았다면
					if (visit[i][b[1]] != 1) {
						// 방문처리 해주고
						visit[i][b[1]] = 1;
						// 그 벽돌 좌표와 벽돌의 값을 다시 큐에 넣어준다.
						bq.add(new int[] {i, b[1], brick[i][b[1]]});
						// 벽돌이 하나 더 깨졌으니 깨진벽돌 +1해주고
						cnt += 1;
						// 벽돌이 깨졌으니 좌표값을 0으로 바꿔준다.
						cbrick[i][b[1]] = 0;
					}
				}
			}
			
			// 현재 좌표 상하로 벽돌을 깨트리기 위해 y좌표는 고정시키고 x좌표만 범위를 바꿔주며 반복문 돌리기
			for (int i = b[1] - pop ; i <= b[1] + pop ; i++ ) {
				
				// 범위가 배열 내부이고, 구슬 범위에 벽돌이 존재한다면
				if ((ifmap(b[0], i)) && (brick[b[0]][i] != 0)) {
					// 다른 벽돌이 깨지며 건드리지 않았다면
					if (visit[b[0]][i] != 1) {
						// 방문처리
						visit[b[0]][i] = 1;
						// 현재 벽돌 좌표, 벽돌값을 다시 큐에 넣기
						bq.add(new int[] {b[0], i, brick[b[0]][i]});
						// 깨진 벽돌 +1
						cnt += 1;
						// 벽돌의 좌표값 0으로 바꿔주기
						cbrick[b[0]][i] = 0;
					}
				}
			}
		}
		
		// 벽돌 사이에 빈칸(0)을 없애기 위해 벽돌 아래로 내려주기
		// 열을 하나하나 돌면서
		for (int j = 0 ; j < W ; j++) {
			// 맨 아래로 벽돌을 눌러야 하므로 맨 아랫줄에서 한칸 위 (N-1)부터 그 아랫줄을 비교하며 0번째 좌표까지 올라오기
			for (int i = H-2 ; i >= 0 ; i--) {
				
				// 만약 현재 좌표는 벽돌이 존재하는데 바로 아래 좌표에 벽돌이 존재하지 않는 빈칸이라면,
				if((cbrick[i][j] != 0) && (cbrick[i + 1][j] == 0)) {
					int dx = i;
					
					// 빈칸이 없어지는 칸 까지 현재 벽돌 옮겨주기
					while(ifmap(dx + 1, j) && (cbrick[dx + 1][j] == 0)) {
						
						// 빈칸과 현재 벽돌 위치 위아래로 계속 바꿔주기
						int temp = cbrick[dx + 1][j];
						cbrick[dx + 1][j] = cbrick[dx][j];
						cbrick[dx][j] = temp;
						
						dx++;
					}
				}
			}
		}
		
		// 현재 구슬로 다 깼으니 다음 구슬을 던질 좌표를 찾기 위해 각 열마다 가장 위에 있는 벽돌 위치 찾아주기
		for (int j = 0 ; j < W ; j++) {
			int i = 0;
			
			while(ifmap(i, j) && (cbrick[i][j] == 0)) {
				i += 1;
			}
			
			if ((i <= H-1) && (cbrick[i][j] != 0)) {
				// 현재 벽돌배열, x좌표, y좌표, 던진 구슬개수 +1, 현재까지 깨진 벽돌은 몇개인지
				bbreak(cbrick, i, j, depth + 1, cnt);
			}
		}
		
		// 만약 이번 구슬로 모든 벽돌이 다 깨졌다면
		if (cnt == sumb) {
			// 최소값을 0으로 만들고 바로 리턴하기
			min = 0;
			return;
		}
		
		return;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			// 구슬의 개수
			N = Integer.parseInt(st.nextToken());
			// 배열의 너비
			W = Integer.parseInt(st.nextToken());
			// 배열의 높이
			H = Integer.parseInt(st.nextToken());
			
			// 초기 배열의 벽돌 개수를 셀 변수 초기화
			sumb = 0;
			
			// 벽돌 정보를 담을 배열 초기화
			int [][] brick = new int [H][W];
			for (int i = 0 ; i < H ; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < W ; j++) {
					// 벽돌에 적힌 숫자를 배열에 저장하고
					brick[i][j] = Integer.parseInt(st.nextToken());
					// 만약 0이 아니라면 벽돌이 들어있는 것이므로 벽돌 개수 +1하기
					if (brick[i][j] != 0) {
						sumb += 1;
					}
				}
			}
			
			// 최소값을 저장할 변수 max값으로 초기화
			min = Integer.MAX_VALUE;
			
			// 각 열마다 제일 높이 있는 벽돌의 좌표를 구하기
			for (int y = 0 ; y < W ; y++) {
				// x좌표 0부터
				int x = 0;
				
				// 배열 내부이고 0이 아닌 값을 찾아 x좌표 한칸씩 계속 내려가기
				while(ifmap(x, y) && (brick[x][y] == 0)) {
					x += 1;
				}
				
				// 만약 반복문이 끝났고 x좌표가 배열 내부이고 그 좌표값이 0이 아니라면 맨 위의 벽돌을 찾은것이므로
				if ((x <= H-1) && (brick[x][y] != 0)) {
					// 현재 벽돌배열, x좌표, y좌표, 지금까지 몇개의 구슬을 던졌는지, 현재까지 깨진 벽돌은 몇개인지
					// 파라미터로 함수 호출
					bbreak(brick, x, y, 0, 0);
				}
			}
			
			// 테스트케이스와 현재 최소값 출력
			System.out.printf("#%d %d \n", test_case, min);
			
		}

	}

}
