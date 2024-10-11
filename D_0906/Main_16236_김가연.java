package D1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_김가연 {
	
	// 구한 좌표가 배열 내부인지 확인하는 함수
	static boolean ifmap(int x, int y, int n) {
		if (((0 <= x) && (x < n)) && ((0 <= y) && (y < n))) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		// 먹이가 담겨있는 배열 크기
		int n = Integer.parseInt(bf.readLine());
		
		// 먹이가 담겨있는 배열 선언
		int [][] arr = new int [n][n];
		
		// 주변 탐색 위한 방향 배열 선언
		int [][] dir = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1 , 0}};
		
		// 상어의 처음 위치 저장할 변수 선언
		int sx = 0, sy = 0;
		
		// 물고기의 수 저장할 변수 선언
		int fish = 0;
		
		// 먹이 정보 저장
		for (int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if ((arr[i][j] != 0) && (arr[i][j] != 9)) {
					fish += 1;
				}
				
				if (arr[i][j] == 9) {
					sx = i;
					sy = j;
				}
			}
		}
		
		// 초기 상어의 크기 저장
		int shark = 2;
		// 상어가 먹은 먹이 수 저장
		int eat = 0;
		// 상어 초기 위치 비우기
		arr[sx][sy] = 0;
		
		// 정답 저장할 변수 선언
		int answer = 0;
		
		// 먹을 수 있는 먹이들의 좌표를 넣을 큐 생성
		Queue<int []> fline = new LinkedList<int[]>();
		
		
		while(fish > 0) {
			
			// 배열 돌면서 현재 상어의 크기보다 작으면 먹이 큐에 넣기
			for (int i = 0 ; i < n ; i++) {
				for (int j = 0 ; j < n ; j++) {
					if ((arr[i][j] > 0) && (arr[i][j] < shark)) {
						fline.add(new int[] {i, j});
					}
				}
			}
			
			if (fline.size() == 0) {
				break;
			}
			
			// 먹이 큐 좌표들 중 조건에 맞는 최단거리 좌표를 구하기 위한 우선순위 큐 설정
			PriorityQueue<int []> sfeed = new PriorityQueue<int[]>(new Comparator<int []>() {
				
				// o[0] : x좌표 , o[1] : y좌표, o[2] : 최단거리
				public int compare(int[] o1, int[] o2) {
					// 만약 최단거리가 같다면
					if (o1[2] == o2[2]) {
						// x좌표 비교하여 가장 위에있는 값 리턴 -> x도 같다면
						if (o1[0] == o2[0]) {
							// y좌표 비교하여 가장 오른쪽에 있는 값 리턴하기
							return o1[1] - o2[1];
						} else {
							return o1[0] - o2[0];
						}
					// 최단거리 다를 시 오름차순 정렬
					} else {
						return o1[2] - o2[2];
					}
				}
				
			});
			
			// 먹이 큐 좌표들의 최단거리를 구해 우선순위 큐에 넣기
			while(!fline.isEmpty()) {
				
				// 좌표를 하나씩 꺼내기
				int [] f = fline.poll();
				
				// 현재 상어의 위치에서 꺼낸 좌표의 최단거리를 구하기 위한 큐 선언
				Queue<int []> q = new LinkedList<int[]>();
				// 현재 상어의 위치 큐에 삽입 -> x좌표, y좌표, 현재 이동 거리
				q.add(new int[] {sx, sy, 0});
				
				// BFS 돌리기 위한 방문 배열 선언
				boolean [][] visit = new boolean [n][n];
				// 처음 상어 위치 방문체크
				visit[sx][sy] = true;
				
				while(!q.isEmpty()) {
					
					int [] qp = q.poll();
					
					for (int [] d : dir) {
						
						int dx = d[0] + qp[0];
						int dy = d[1] + qp[1];
						
						if (ifmap(dx, dy, n)) {
							if (!visit[dx][dy]) {
								// 처음 위치에서 먹이 좌표에 도달 가능하면 x좌표, y좌표, 최단거리를 우선순위큐에 넣어준다
								if ((dx == f[0]) && (dy == f[1])) {
									visit[dx][dy] = true;
									sfeed.add(new int [] {dx, dy, qp[2] + 1});
								} else if (arr[dx][dy] <= shark) {
									visit[dx][dy] = true;
									q.add(new int[] {dx, dy, qp[2] + 1});
								}
							}
						}
						
					}
				}
			}
			
			// 만약 최단거리 좌표가 존재한다면 가서 먹어주기
			if (sfeed.size() > 0) {
				
				int [] s = sfeed.poll();
				// 먹은 좌표로 상어의 현재 위치 옮겨주기
				sx = s[0];
				sy = s[1];
				
				// 정답에 걸린 시간 더해주기
				answer += s[2];
			
				// 먹이를 먹었으니 현재 좌표값을 0으로 바꿔줌
				arr[sx][sy] = 0;
				
				// 먹은 먹이 수 +1
				eat += 1;
				
				// 만약 먹은 먹이 수가 현재 상어의 크기와 같다면 
				if (eat == shark) {
					// 상어크기 +1
					shark ++;
					// 먹이 수 초기화
					eat = 0;
				}
				fish -= 1;
			} else {
				// 만약 먹을 수 있는 좌표가 존재하지 않다면 종료
				break;
			}
			
		}
		
		System.out.println(answer);
		
	}

}
