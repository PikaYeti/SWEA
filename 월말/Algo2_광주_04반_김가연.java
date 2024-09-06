import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo2_광주_04반_김가연 {
	
	static boolean ifmap(int x, int y, int m, int n) {
		if (((0 <= x) && (x < m)) && ((0 <= y) && (y < n))) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// 지도 가로, 세로 받아오기
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		// 지도 배열 선언
		int [][] map = new int [m][n];
		// 지도를 탐색하기 위해서 방문 배열 선언
		int [][] visit = new int [m][n];
		
		// 분리된 영역의 개수
		int k = Integer.parseInt(st.nextToken());
		
		// 얼어붙은 영역을 map배열에서 1로 채워주기
		// 주어진 배열을 위아래로 뒤집는다고 생각하고 왼쪽아래 -> 왼쪽 위 / 오른쪽 위 -> 오른쪽 아래 좌표로 생각한다.
		for (int i = 0 ; i < k ; i ++) {
			// x, y 좌표가 뒤집혔으니 받은 좌표도 뒤집어서 저장하기
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			// 왼쪽 꼭짓점 좌표
			int fy = Integer.parseInt(st1.nextToken());
			int fx = Integer.parseInt(st1.nextToken());
			// 오른쪽 꼭짓점 좌표
			int ey = Integer.parseInt(st1.nextToken());
			int ex = Integer.parseInt(st1.nextToken());
			
			// map배열 얼어붙은 지역 채워주기 위해 위에서 받은 좌표로 for문 돌리기
			for (int x = fx ; x < ex ; x++) {
				for (int y = fy ; y < ey ; y++) {
					map[x][y] = 1;
					visit[x][y] = 1;
				}
			}
		}
		
		// 얼지 않은 땅에서 다른 얼지 않은 땅을 찾을 때 좌표를 저장할 큐 생성
		Queue<int[]> ground = new LinkedList<>();
		
		// 얼지 않은 땅 들의 크기를 저장할 리스트 선언
		ArrayList<Integer> size = new ArrayList<>();
		
		// 얼지 않은 땅의 크기를 저장할 변수 선언
		int cnt = 0;
		// 좌표에서 탐색하기 위한 방향 배열 선언
		int [][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		
		for (int i = 0 ; i < m ; i ++) {
			for (int j = 0 ; j < n ; j++) {
				
				// 땅의 크기 0으로 초기화
				cnt = 0;
				
				// 만약 얼지 않은 땅이고 방문하지 않았다면
				if((map[i][j] == 0) && (visit[i][j] != 1)) {
					// 땅의 크기 + 1
					cnt += 1;
					// 방문 처리
					visit[i][j] = 1;
					// 현재 좌표를 큐에 삽입
					ground.add(new int[] {i, j});
					
					// 현재 좌표에서 갈 수 있는 좌표가 끝날때까지 반복하기
					while(!ground.isEmpty()) {
						
						// 넣었던 좌표 꺼내기
						int [] g = ground.poll();
						
						// 그 좌표에서 사방탐색 돌려주기
						for (int [] d : dir) {
							int dx = g[0] + d[0];
							int dy = g[1] + d[1];
							// 만약 다음 좌표가 지도 내부이고
							if (ifmap(dx, dy, m, n)) {
								
								// 얼지 않고 방문하지 않은 땅이라면
								if ((map[dx][dy] == 0) && (visit[dx][dy] != 1)) {
									// 땅의 크기 + 1
									cnt += 1;
									// 방문처리 ㅎ주기
									visit[dx][dy] = 1;
									// 다시 큐에 넣어 좌표에서 갈 수 있는 다른곳 탐색
									ground.add(new int[] {dx, dy});
								}
							}
						}
					}
					// 땅의 크기 저장하는 리스트에 현재 땅의 크기 삽입
					size.add(cnt);
				}
			}
		}
		
		// 땅의 크기를 저장한 리스트를 오름차순 정렬해준다
		Collections.sort(size, ((o1, o2) -> Integer.compare(o1, o2)));
		
		// 땅 영역의 갯수 출력
		System.out.println(size.size());
		
		// 정렬된 리스트 차례로 탐색하며 각 영역의 넓이 출력해주기
		for (int i = 0 ; i < size.size() ; i++) {
			System.out.printf("%d ", size.get(i));
		}
		
		

	}

}
