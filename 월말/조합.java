package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 조합 {
	
	static int n;
	static BufferedWriter bw;
	
	static void permu(boolean [] visit, int [] arr, int depth, int r) throws IOException {
		
		if (depth == r) {
			for (int i = 0 ; i < arr.length ; i++) {
				System.out.println(arr[i]);
			}
			System.out.println();
			return;
		}
		
		for (int i = depth ; i < n ; i ++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				permu(visit, arr, depth + 1, r);
				visit[i] = false;
			}
		}
		return;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		boolean [] visit = new boolean[n];
		
		int s = Integer.parseInt(st.nextToken());
		int [] arr = new int [s];
		
		permu(visit, arr, 0, s);

	}

}

