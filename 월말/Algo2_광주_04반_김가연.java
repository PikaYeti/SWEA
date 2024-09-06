import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo2_����_04��_�谡�� {
	
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
		
		// ���� ����, ���� �޾ƿ���
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		// ���� �迭 ����
		int [][] map = new int [m][n];
		// ������ Ž���ϱ� ���ؼ� �湮 �迭 ����
		int [][] visit = new int [m][n];
		
		// �и��� ������ ����
		int k = Integer.parseInt(st.nextToken());
		
		// ������ ������ map�迭���� 1�� ä���ֱ�
		// �־��� �迭�� ���Ʒ��� �����´ٰ� �����ϰ� ���ʾƷ� -> ���� �� / ������ �� -> ������ �Ʒ� ��ǥ�� �����Ѵ�.
		for (int i = 0 ; i < k ; i ++) {
			// x, y ��ǥ�� ���������� ���� ��ǥ�� ����� �����ϱ�
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			// ���� ������ ��ǥ
			int fy = Integer.parseInt(st1.nextToken());
			int fx = Integer.parseInt(st1.nextToken());
			// ������ ������ ��ǥ
			int ey = Integer.parseInt(st1.nextToken());
			int ex = Integer.parseInt(st1.nextToken());
			
			// map�迭 ������ ���� ä���ֱ� ���� ������ ���� ��ǥ�� for�� ������
			for (int x = fx ; x < ex ; x++) {
				for (int y = fy ; y < ey ; y++) {
					map[x][y] = 1;
					visit[x][y] = 1;
				}
			}
		}
		
		// ���� ���� ������ �ٸ� ���� ���� ���� ã�� �� ��ǥ�� ������ ť ����
		Queue<int[]> ground = new LinkedList<>();
		
		// ���� ���� �� ���� ũ�⸦ ������ ����Ʈ ����
		ArrayList<Integer> size = new ArrayList<>();
		
		// ���� ���� ���� ũ�⸦ ������ ���� ����
		int cnt = 0;
		// ��ǥ���� Ž���ϱ� ���� ���� �迭 ����
		int [][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		
		for (int i = 0 ; i < m ; i ++) {
			for (int j = 0 ; j < n ; j++) {
				
				// ���� ũ�� 0���� �ʱ�ȭ
				cnt = 0;
				
				// ���� ���� ���� ���̰� �湮���� �ʾҴٸ�
				if((map[i][j] == 0) && (visit[i][j] != 1)) {
					// ���� ũ�� + 1
					cnt += 1;
					// �湮 ó��
					visit[i][j] = 1;
					// ���� ��ǥ�� ť�� ����
					ground.add(new int[] {i, j});
					
					// ���� ��ǥ���� �� �� �ִ� ��ǥ�� ���������� �ݺ��ϱ�
					while(!ground.isEmpty()) {
						
						// �־��� ��ǥ ������
						int [] g = ground.poll();
						
						// �� ��ǥ���� ���Ž�� �����ֱ�
						for (int [] d : dir) {
							int dx = g[0] + d[0];
							int dy = g[1] + d[1];
							// ���� ���� ��ǥ�� ���� �����̰�
							if (ifmap(dx, dy, m, n)) {
								
								// ���� �ʰ� �湮���� ���� ���̶��
								if ((map[dx][dy] == 0) && (visit[dx][dy] != 1)) {
									// ���� ũ�� + 1
									cnt += 1;
									// �湮ó�� ���ֱ�
									visit[dx][dy] = 1;
									// �ٽ� ť�� �־� ��ǥ���� �� �� �ִ� �ٸ��� Ž��
									ground.add(new int[] {dx, dy});
								}
							}
						}
					}
					// ���� ũ�� �����ϴ� ����Ʈ�� ���� ���� ũ�� ����
					size.add(cnt);
				}
			}
		}
		
		// ���� ũ�⸦ ������ ����Ʈ�� �������� �������ش�
		Collections.sort(size, ((o1, o2) -> Integer.compare(o1, o2)));
		
		// �� ������ ���� ���
		System.out.println(size.size());
		
		// ���ĵ� ����Ʈ ���ʷ� Ž���ϸ� �� ������ ���� ������ֱ�
		for (int i = 0 ; i < size.size() ; i++) {
			System.out.printf("%d ", size.get(i));
		}
		
		

	}

}
