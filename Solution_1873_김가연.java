package D_0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_김가연 {
	
	static int row;
	static int col;
	static int tx, ty;
	static char [][] game;
	static int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
 	
	static boolean ifgame(int x, int y) {
		if (((0 <= x) && (x < row)) && ((0 <= y) && (y < col))) {
			return true;
		} else {
			return false;
		}
	}
	
	static void active(char in, int d) {
		int tntx = 0;
		int tnty = 0;
		// 포탄을 발사하는 입력이라면
		if (in == 'S') { 
			tntx = tx + dir[d][0]; // 쳐다보는 방향으로 조준하기
			tnty = ty + dir[d][1];
			while(ifgame(tntx, tnty)) {
				if (game[tntx][tnty] == '*') { // 만약 바로 앞이 벽돌벽이면
					game[tntx][tnty] = '.'; // 깨서 평지로 만들고
					break; // 포탄 소멸
				} else if (game[tntx][tnty] == '#') { // 강철벽이라면
					break; // 아무일도 일어나지 않고 폭탄 소멸
				} else { // 물이나 평지라면 계속 쳐다보는 방향으로 날아간다
					tntx += dir[d][0];
					tnty += dir[d][1];
				}
			}
		// 위를 쳐다보는 입력
		} else if (in == 'U') {
			tntx = tx + dir[0][0]; // 위 칸 이동하기 위해 임시로 좌표 설정
			tnty = ty + dir[0][1];
			game[tx][ty] = '^'; // 전차 바라보는 방향 돌려주기
			// 임시 좌표가 필드 안쪽이고 평지라면
			if ((ifgame(tntx, tnty)) && (game[tntx][tnty] == '.')) { 
				// 한칸 앞쪽으로 이동하기
				game[tntx][tnty] = game[tx][ty];
				// 원래 자리를 평지로 만들어주기
				game[tx][ty] = '.';
				// 좌표를 이동 좌표로 만들어주기
				tx = tntx;
				ty = tnty;
			}
		// 아래를 쳐다보는 입력
		} else if (in == 'D') {
			tntx = tx + dir[1][0];
			tnty = ty + dir[1][1];
			game[tx][ty] = 'v';
			if ((ifgame(tntx, tnty)) && (game[tntx][tnty] == '.')) {
				game[tntx][tnty] = game[tx][ty];
				game[tx][ty] = '.';
				tx = tntx;
				ty = tnty;
			}
		// 왼쪽을 쳐다보는 입력
		} else if (in == 'L') {
			tntx = tx + dir[2][0];
			tnty = ty + dir[2][1];
			game[tx][ty] = '<';
			if ((ifgame(tntx, tnty)) && (game[tntx][tnty] == '.')) {
				game[tntx][tnty] = game[tx][ty];
				game[tx][ty] = '.';
				tx = tntx;
				ty = tnty;
			}
		// 오른쪽을 쳐다보는 입력
		} else {
			tntx = tx + dir[3][0];
			tnty = ty + dir[3][1];
			game[tx][ty] = '>';
			if ((ifgame(tntx, tnty)) && (game[tntx][tnty] == '.')) {
				game[tntx][tnty] = game[tx][ty];
				game[tx][ty] = '.';
				tx = tntx;
				ty = tnty;
			}
		}
		
		return;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= 1 ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			
			tx = 0;
			ty = 0;
			char [] dir = new char[] {'^', 'v', '<', '>'};
			game = new char[row][col];
			
			
			for (int i = 0 ; i < row ; i ++) {
				String st1 = new String(bf.readLine());
				for (int j = 0 ; j < col ; j++) {
					game[i][j] = st1.charAt(j);
					// 현재 좌표에 화살표가 존재하면 시작좌표이므로 그 좌표 저장
					for (char d : dir) {
						if (st1.charAt(j) == d) {
							tx = i;
							ty = j;
						}
					}
				}
			}
			
			int n = Integer.parseInt(bf.readLine());
			char [] input = new char[n];
			String userin = new String(bf.readLine());
			
			for (int i = 0 ; i < n ; i++) {
				input[i] = userin.charAt(i);
			}
			
			// 현재 화살표가 쳐다보고 있는 방향과 함께 입력의 종류 넘겨주기
			for (int i = 0 ; i < n ; i++) {
				if (game[tx][ty] == '^') {
					active(input[i], 0);
				} else if (game[tx][ty] == 'v') {
					active(input[i], 1);
				} else if (game[tx][ty] == '<') {
					active(input[i], 2);
				} else {
					active(input[i], 3);
				}
				
			}
			
			// 테스트 케이스와 현재 필드 상황 출력하기
			System.out.print("#" + test_case + " ");
			for (int i = 0 ; i < row ; i++) {
				for(int j = 0 ; j < col ; j++) {
					System.out.print(game[i][j]);
				}
				System.out.println();
			}
			
		}

	}

}
