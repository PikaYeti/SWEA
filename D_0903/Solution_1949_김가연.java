package D_0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1949_김가연 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1; test_case <= tc ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			String str = new String(st.nextToken());
			int [] num = new int[str.length()];
			for (int i = 0 ; i < str.length() ; i++) {
				num[i] = str.charAt(i) - '0';
			}
			
			int change = Integer.parseInt(st.nextToken());
			
			int [][] snum = new int [num.length][2];
			int [] cnum = new int [10];
			
			for (int i = 0 ; i < num.length ; i++) {
				snum[i][0] = num[i];
				cnum[snum[i][0]] += 1;
				snum[i][1] = i;
			}
			
			Arrays.sort(snum, ((o1, o2) -> Integer.compare(o2[1], o1[1])));
			
//			int max = 0;
//			
//			for (int i = 0 ; i < change ; i++) {
//				int temp = 0;
//				if (snum[max][1] != i) {
//					for (int j = 0 ; j < snum.length ; j++) {
//						if (snum[j][1] == i) {
//							temp = snum[j][i];
//							snum[j][i] = snum[max][1];
//							snum[max][1] = snum[j][1];
//						}
//					}
//				}
//			}
			
			int first = 0;
			int sfir = 0;
			int temp = 0;
			
			for (int i = 0 ; i < change ; i++) {
				// snum[sfir][0] -> 최대값 / num[first] -> 현재 처음 값
				if (snum[sfir][0] != num[first]) {
					if (cnum[snum[sfir][0]] == 1) {
						temp = num[first];
						num[first] = num[snum[sfir][0]];
						num[snum[sfir][0]] = num[first];
						
						for (int j = 0 ; j < snum.length ; j++) {
							if (snum[j][1] == first) {
								temp = snum[j][1];
								snum[j][1] = snum[sfir][1];
								snum[sfir][1] = temp;
							}
						}
					} else {
						for (int j = 0 ; j < snum.length ; j++) {
							if (snum[j][1] == first) {
								System.out.println(j);
								if (num[j] == snum[sfir][0]) {
									for (int k = 0 ; k < snum.length ; k++) {
										if (snum[k][1] == j) {
											temp = num[snum[j][1]];
											num[snum[j][1]] = num[snum[k][1]];
											num[snum[k][1]] = temp;
											
											temp = snum[j][1];
											snum[j][1] = snum[k][1];
											snum[k][1] = temp;
										}
									}
								} else {
									temp = num[first];
									num[first] = num[snum[sfir][0]];
									num[snum[sfir][0]] = num[first];
									
									for (int k = 0 ; k < snum.length ; k++) {
										if (snum[k][1] == first) {
											temp = snum[k][1];
											snum[k][1] = snum[sfir][1];
											snum[sfir][1] = temp;
										}
									}
								}
							}
						}
					}
				}
			}
			
			System.out.println(Arrays.toString(num));
			
			for (int i = 0 ; i < snum.length ; i++) {
				System.out.println(Arrays.toString(snum[i]));
			}
			
		}

	}

}
