package D_0820;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_4796_±è°¡¿¬ {

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
			
			for (int i = 1 ; i < n - 1; i++) {
				if ((arr[i - 1] < arr[i]) && (arr[i] > arr[i + 1])) {
					mm.add(i);
				}
			}
			
			int sum = 0;
			int fri = 0;
			while(!mm.isEmpty()) {
				int tmp = mm.poll();
				sum += 1;
				
				int a = 0;
				int j = tmp - 2;
				while ((j >= 0) && (arr[j] < arr[j + 1])) {
					j--;
					fri += 1;
				}
				int k = tmp + 2;
				while ((k < n) && (arr[k] < arr[k - 1])) {
					k++;
					fri += 1;
				}

			}
			
			if (fri > 0) {
				System.out.printf("#%d %d \n",test_case, fri * 2);
			} else {
				System.out.printf("#%d %d \n",test_case, sum);
			}
			
		}
	}

}
