package D_0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5644_김가연 {
	
	static int ax, ay;
	static int bx, by;
	static int amax, bmax;

	
//	static int if
	
	static boolean ifmap(int x, int y) {
		if (((0 <= x) && (x < 10)) && ((0 <= y) && (y < 10))) {
			return true;
		} else {
			return false;
		}
	}
	
	static boolean ifsq(int x, int y, int dx, int dy, int c) {
		int dt = Math.abs(x - dx) + Math.abs(y - dy);
		if (c >= dt) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int move = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int [][] map = new int[10][10];
			Queue<int[]> over2 = new LinkedList<>();
			ArrayList[][] map2 = new ArrayList[10][10];
			
			ArrayList[] charge = new ArrayList[k];
			for (int i = 0 ; i < k ; i++) {
				charge[i] = new ArrayList<Integer>();
			}
			
			StringTokenizer m1 = new StringTokenizer(bf.readLine());
			int [] Amove = new int[move];
			for (int i = 0 ; i < move ; i ++) {
				Amove[i] = Integer.parseInt(m1.nextToken());
			}
			
			m1 = new StringTokenizer(bf.readLine());
			int [] Bmove = new int[move];
			for (int i = 0 ; i < move ; i ++) {
				Bmove[i] = Integer.parseInt(m1.nextToken());
			}
			
			for (int i = 0 ; i < k ; i++) {
				StringTokenizer st1 = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < 4 ; j++) {
					charge[i].add(Integer.parseInt(st1.nextToken()));
				}
			}
			
			
			
			for (int i = 0 ; i < k ; i++) {
				int y = (int)charge[i].get(0) - 1;
				int x = (int)charge[i].get(1) - 1;
				int c = (int)charge[i].get(2);
				for (int j = x-c ; j <= x+c ; j++) {
					for (int l = y-c ; l <= y+c ; l++) {
						if (ifmap(j, l)){
							if (ifsq(x, y, j, l, c)) {
								map2[j][l] = new ArrayList<Integer>();
								if (map[j][l] != 0) {
									map2[j][l].add(i+1);
									map[j][l] = -1;
								} else {
									map2[j][l].add(i+1);
									map[j][l] = i+1;
								}
							}
						}
					}
				}
			}
			
			for (int i = 0 ; i < map.length ; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			System.out.println("--------------------------");
			
			ax = 0;
			ay = 0;
			bx = 9;
			by = 9;
			amax = map[ax][ay];
			bmax = map[bx][by];
			
			for (int i = 0 ; i < move ; i++) {
				if (Amove[i] == 4) {
					ay -= ay;
				} else if (Amove[i] == 1) {
					ax -= 1;
				} else if (Amove[i] == 2) {
					ay += 1;
				} else if (Amove[i] == 3) {
					ax += 1;
				}
				
				if (Bmove[i] == 4) {
					by -= by;
				} else if (Bmove[i] == 1) {
					bx -= 1;
				} else if (Bmove[i] == 2) {
					by += 1;
				} else if (Bmove[i] == 3) {
					bx += 1;
				}
				
				if (map[ax][ay] == map[bx][by]) {
					if (map[ax][ay] == -1) {
						
					} else {
						if (map[ax][ay] != 0) {
							amax += (int)charge[map[ax][ay] - 1].get(3) / 2;
							bmax += (int)charge[map[ax][ay] - 1].get(3) / 2;
						}
					}
				} else if ((map[ax][ay] == -1) || (map[bx][by] == -1)) {
					
				}
			}
			
		}

	}
}