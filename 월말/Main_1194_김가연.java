package D1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 현재 위치에서 갈 수 있는 곳을 모두 탐색 하면서 열쇠를 미리 먹기
 * https://www.acmicpc.net/problem/1194
 */

public class Main_1194_김가연 {
	
	static boolean ifmap(int x, int y, int n, int m) {
		if (((0 <= x) && (x < n)) && ((0 <= y) && (y < m))) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int [][] dir = new int [][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		
		int sx = 0, sy = 0;
		ArrayList<char []> key = new ArrayList<char []>();
		ArrayList<char []> door = new ArrayList<char []>();
		
		char [][] arr = new char [n][m];
		for (int i = 0 ; i < n ; i++) {
			String line = bf.readLine();
			for (int j = 0 ; j < m ; j++) {
				arr[i][j] = line.charAt(j);
				
				if (arr[i][j] == '0') {
					sx = i;
					sy = j;
				} else if (Character.isUpperCase(arr[i][j])) {
					door.add(new char[] {(char) (i + '0'), (char)(j + '0'), arr[i][j]});
				} else if (Character.isLowerCase(arr[i][j])) {
					key.add(new char[] {(char) (i + '0'), (char)(j + '0'), arr[i][j]});
				}
			}
		}
		
//		for (int i = 0 ; i < door.size() ; i++) {
//			System.out.println(Arrays.toString(door.get(i)));
//		}
//		
//		System.out.println("-------------------");
//		
//		for (int i = 0 ; i < key.size() ; i ++) {
//			System.out.println(Arrays.toString(key.get(i)));
//		}
		
		boolean [][] visit = new boolean [n][m];
		visit[sx][sy] = true;
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {sx, sy, 0});
		
		int answer = 0;
		ArrayList<Character> klist = new ArrayList<Character>();
		
		// 키 모으기
		while(!q.isEmpty()) {
			
			int [] qp = q.poll();
			boolean flag = false;
			
			for (int [] d : dir) {
				
				int dx = d[0] + qp[0];
				int dy = d[1] + qp[1];
				
				if (ifmap(dx, dy, n, m)) {
					if (!visit[dx][dy]) {
						if (arr[dx][dy] == '1') {
							flag = true;
							visit[dx][dy] = true;
							answer += qp[2] + 1;
						} else if (Character.isLowerCase(arr[dx][dy])) {
							visit[dx][dy] = true;
							System.out.println("key : " + arr[dx][dy] + " dis : " + (qp[2] + 1));
							klist.add(arr[dx][dy]);
							arr[dx][dy] = '.';
							sx = dx;
							sy = dy;
							answer += (qp[2] + 1);
							q.add(new int[] {dx, dy, 0});
						} else if (Character.isUpperCase(arr[dx][dy])) {
							visit[dx][dy] = true;
							if (klist.contains(Character.toLowerCase(arr[dx][dy]))) {
								arr[dx][dy] = '.';
								q.add(new int[] {dx, dy, qp[2] + 1});
							}
							System.out.println("door : " + arr[dx][dy] + " dis : " + (qp[2] + 1));
						} else if (arr[dx][dy] == '.') {
							visit[dx][dy] = true;
							q.add(new int[] {dx, dy, qp[2] + 1});
						}
						
						
					}
				}
				
			}
			
			if (flag) {
				break;
			}
			
		}
		
		q = new LinkedList<int[]>();
		q.add(new int[] {sx, sy, 0});
		
		while(!q.isEmpty()) {
			
			int [] qp = q.poll();
			
			for (int [] d : dir) {
				
				int dx = d[0] + qp[0];
				int dy = d[1] + qp[1];
				
				if (ifmap(dx, dy, n, m)) {
					if (!visit[dx][dy]) {
						if (arr[dx][dy] == '1') {
							visit[dx][dy] = true;
							answer += qp[2] + 1;
						} else if (Character.isUpperCase(arr[dx][dy])) {
							visit[dx][dy] = true;
							if (klist.contains(Character.toLowerCase(arr[dx][dy]))) {
								arr[dx][dy] = '.';
								q.add(new int[] {dx, dy, qp[2] + 1});
							}
							System.out.println("door : " + arr[dx][dy] + " dis : " + (qp[2] + 1));
						} else if (arr[dx][dy] == '.') {
							visit[dx][dy] = true;
							q.add(new int[] {dx, dy, qp[2] + 1});
						}
					}
				}
				
			}
			
			
		}
		
		
		
		System.out.println("sx : " + sx + " sy : " + sy + " answer : " + answer);

	}

}
