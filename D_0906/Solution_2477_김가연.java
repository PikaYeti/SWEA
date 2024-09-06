package D_0906;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2477_김가연 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int [] rcarr = new int [N];
			boolean [] rcfull = new boolean[N];
			int M = Integer.parseInt(st.nextToken());
			int [] rparr = new int [M];
			boolean [] cpfull = new boolean[N];
			int K = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(bf.readLine());
			for (int i = 0 ; i < N ; i++) {
				rcarr[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(bf.readLine());
			for (int i = 0 ; i < M ; i++) {
				rparr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 손님 대기열
			Queue<int []> cq = new LinkedList<>();
			st = new StringTokenizer(bf.readLine());
			for (int i = 0 ; i < K ; i++) {
				cq.add(new int[] {Integer.parseInt(st.nextToken()), i + 1});
			}
			
			// 접수 대기열
			Queue<int []> rcq = new LinkedList<>();
			
			while(!cq.isEmpty()) {
				
				int [] c = cq.poll();
				
				
				
			}
			
			// 정비 대기열
			Queue<int []> rpq = new LinkedList<>();
			
		}

	}

}
