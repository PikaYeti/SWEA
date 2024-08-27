package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_김가연 {
	
	static int row;
	static int col;
	// 다음 파이프가 지나갈 수 있게 자리 내주기 위해 오른쪽 위 -> 오른쪽 -> 오른쪽 아래 순으로 탐색 방향 설정
	static int [][] dir = new int[][] {{-1, 1}, {0, 1}, {1, 1}};
	// 이미 파이프가 지나간 자리인지 확인하는 배열 설정
	static int [][] vpipe;
	static char [][] pipe;
	// 도착했을때 시작 파이프 체크해주기 위한 배열
	static boolean [] spipe;
	// 정답 저장하기 위한 변수 설정
	static int cnt;
	
	// 파이프 탐색 위치가 배열 안쪽인지 확인
	static boolean ifmap(int x, int y) {
		if (((0 <= x) && (x < row)) && ((0 <= y) && (y < col))) {
			return true;
		} else {
			return false;
		}
	}
	
	static void endcol(int [] next, int x) {
		// 시작파이프의 다른 탐색 방향에서 이미 탐색이 완료되었다면 리턴
		if (spipe[x]) {
			return;
		}
		
		// 탐색위치가 이미 다른 파이프가 지나간 자리라면 리턴
		if (vpipe[next[0]][next[1]] == 1) {
			return;
		}
		
		// 맨 마지막 열에 도착했다면 방문처리, 시작 파이프 도착했다고 true, 정답 하나 올려줌
		if (next[1] == (col - 1)) {
			vpipe[next[0]][next[1]] = 1;
			spipe[x] = true;
			cnt++;
			return;
		}
		
		// 조건들 다 뚫고 왔다면 방문처리
		vpipe[next[0]][next[1]] = 1;
		
		// 오른쪽 위 -> 오른쪽 -> 오른쪽 아래 순으로 탐색
		for (int [] d : dir) {
			int dx = next[0] + d[0];
			int dy = next[1] + d[1];
			if (ifmap(dx, dy)) {
				// 만약 그 방향을 방문하지 않았고 건물이 있는 위치가 아니라면 재귀
				if ((vpipe[dx][dy] != 1) && (pipe[dx][dy] != 'x')) {
					endcol(new int[] {dx, dy}, x);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		pipe = new char[row][col];
		vpipe = new int[row][col];
		spipe = new boolean[row];
		
		for (int i = 0 ; i < row ; i ++) {
			String st1 = new String(bf.readLine());
			for (int j = 0 ; j < col ; j++) {
				pipe[i][j] = st1.charAt(j);
			}
		}
		
		// 첫번째 열에서 출발해야 정답으로 인정되므로 x좌표만 바꾸고 y좌표는 0으로 고정해서 반복문
		for (int i = 0 ; i < row ; i ++) {
			if ((vpipe[i][0] != 1) && (pipe[i][0] != 'x')) {
				// 출발 위치 체크하기 위해서 출발 x좌표도 함께 넘겨주기
				endcol(new int[] {i, 0}, i);
			}
		}
		
		// 정답 출력
		System.out.println(cnt);

	}

}
