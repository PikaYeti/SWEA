package D_0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Pipe {
	
	static boolean ifmap(int x, int y, int n) {
		if (((0 <= x) && (x < n)) && ((0 <= y) && (y < n))) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int [][] pipe = new int[n][n];
		int [][] visit = new int[n][n];
		
		for (int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0 ; j < n ; j++) {
				pipe[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int [][] dir = new int[][] {{0, 1}, {1, 0}, {1, 1}};
		Queue<int[]> inpipe = new LinkedList<>();
		
		visit[0][0] = 1;
		inpipe.add(new int[] {0, 1});
		
		int cnt = 0;
		
		while(!inpipe.isEmpty()) {
			int [] p = inpipe.poll();
			System.out.println(Arrays.toString(p));
			for (int j = 0 ; j < dir.length ; j++) {
				int dx = p[0] + dir[j][0];
				int dy = p[1] + dir[j][1];
				
			}
		}
		
		System.out.println(cnt);
		
		
		

	}

}
