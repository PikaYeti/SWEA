package D_0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5658_김가연 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			Queue<String> pwline = new LinkedList<>();
			
			String pw = new String(bf.readLine());
			for (int i = 0 ; i < N ; i++) {
				pwline.add(String.valueOf(pw.charAt(i))); 
			}
			
			HashSet<String> pwSet = new HashSet<>();
			
			for (int turn = 0 ; turn < N ; turn ++) {
				for (int i = 0 ; i < 4 ; i ++) {
					String str = null;
					for (int j = 0 ; j < N/4 ; j++) {
						String temp = pwline.poll();
						if (str == null) {
							str = temp;
						} else {
							str += temp;
						}
						pwline.add(temp);
					}
					pwSet.add(str);
				}
				String back = pwline.poll();
				pwline.add(back);
			}
			
			Integer [] arr = new Integer [pwSet.size()];
			int idx = 0;
			
			for (String pwStr : pwSet) {
				int vp = N/4 - 1;
				int sum = 0;
				int value = 0;
				for (int i = 0 ; i < N/4 ; i++) {
					if ((65 <= pwStr.charAt(i)) && (pwStr.charAt(i) <= 70)) {
						value = pwStr.charAt(i) - 55;
					} else {
						value = pwStr.charAt(i) - '0';
					}
					sum += Math.pow(16, vp) * value;
					vp--;
				}
				
				arr[idx] = sum;
				idx ++;
			}
			
			Arrays.sort(arr, Collections.reverseOrder());
			
			System.out.printf("#%d %d \n", test_case, arr[K-1]);
		}
		
	}

}
