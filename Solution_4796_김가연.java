package SWEA;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_4796_김가연 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int test_case = 1 ; test_case <= tc ; test_case++) {
			
			int n = sc.nextInt();
			int [] arr = new int[n];
			Queue<Integer> mm = new LinkedList<>();
			
			for (int i = 0 ; i < n ; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 우뚝 선 산의 인덱스 찾아 큐에 넣기
			// 우뚝 선 산의 왼쪽 작은 갯수, 오른쪽 작은 갯수 곱하면 답
			for (int i = 1 ; i < n - 1; i++) {
				if ((arr[i - 1] < arr[i]) && (arr[i] > arr[i + 1])) {
					mm.add(i);
				}
			}
			
			int sum = 0;
			// 큐에 넣었던 인덱스 빼서
			while(!mm.isEmpty()) {
				int tmp = mm.poll();
				// 바로 왼쪽, 오른쪽 인덱스 설정
				int lidx = tmp - 1;
				int ridx = tmp + 1;
				int left = 0;
				int right = 0;
				
				// 왼쪽 인덱스 계속 낮춰가며 현재보다 전 인덱스 값이 더 작으면 left ++
				while ((lidx >= 0) && (arr[lidx] < arr[lidx + 1])) {
					left += 1;
					lidx--;
				}
				
				// 오른쪽 인덱스 계속 올려가며 현재 인덱스가 전 인덱스 값이 더 작으면 right ++
				while ((ridx < n) && (arr[ridx - 1] > arr[ridx])) {
					right += 1;
					ridx++;
				}
				// 두개 곱해서 답에 더해주기
				sum += left * right;
				
			}
			

			System.out.printf("#%d %d \n",test_case, sum);
			
		}
	}

}
