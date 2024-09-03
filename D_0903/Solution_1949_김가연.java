package SWEA.D_0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_1949_김가연 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1; test_case <= tc ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			String str = new String(st.nextToken());
			Integer [] num = new Integer [str.length()];
			for (int i = 0 ; i < str.length() ; i++) {
				num[i] = str.charAt(i) - '0';
			}
			
			Integer [] copyn = num.clone();
			Arrays.sort(copyn, Collections.reverseOrder());
			
			int change = Integer.parseInt(st.nextToken());
			
			int [][] snum = new int [num.length][2];
			int [] cnum = new int [10];
			
			for (int i = 0 ; i < num.length ; i++) {
				snum[i][0] = num[i];
				cnum[snum[i][0]] += 1;
				snum[i][1] = i;
			}
			
			Integer [] cn = num.clone();
			Arrays.sort(cn, Collections.reverseOrder());
			
//			Arrays.sort(snum, ((o1, o2) -> Integer.compare(o2[0], o1[0])));
			
			Arrays.sort(snum, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					
					if (o1[0] == o2[0]) {
						return o2[1] - o1[1];
					} else {
						return o2[0] - o1[0];
					}
				};
			});
			
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
			
			
			int i = 0;
			for (i = 0 ; i < change ; i++) {
				
				// snum[sfir][0] -> 최대값 / num[first] -> 현재 처음 값
				
				// 만약 가장 큰 값하고 첫번째 값의 인덱스가 다를 때 -> 가장 큰 값이 첫 인덱스가 아닐때
				if (snum[sfir][0] != num[first]) {
					// 만약 가장 큰 값이 1개밖에 없고 첫번째 인덱스에 존재하지 않을 때
					if (cnum[snum[sfir][0]] == 1) {
						temp = num[first];
						num[first] = snum[sfir][0];
						num[snum[sfir][1]] = temp;
						
						for (int j = 0 ; j < snum.length ; j++) {
							if (snum[j][1] == first) {
								temp = snum[j][1];
								snum[j][1] = snum[sfir][1];
								snum[sfir][1] = temp;
							}
						}
						cnum[snum[sfir][0]] -= 1;
					// 만약 가장 큰 값이 2개 이상이고 첫번째 인덱스에 존재하지 않을 때
					} else {
						for (int j = 0 ; j < snum.length ; j++) {
							if (snum[j][1] == sfir) {
								// snum[j][0] == 3 <- 3번째 위치
								// 만약 첫번째 인덱스의 정렬된 위치에 가장 큰 값이 존재할 때
								// 정렬된 위치와 큰 값 위치를 바꿔주기
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
									cnum[snum[sfir][0]] -= 1;
									
								// 첫번째 인덱스 정렬된 위치에 가장 큰 값이 존재하지 않을 때
								// 그냥 첫번째 값과 가장 큰 값 바꾸기
								} else {
									temp = num[first];
									num[first] = snum[sfir][0];
									num[snum[sfir][1]] = temp;
									
									for (int k = 0 ; k < snum.length ; k++) {
										if (snum[k][1] == first) {
											temp = snum[k][1];
											snum[k][1] = snum[sfir][1];
											snum[sfir][1] = temp;
										}
									}
									
									cnum[snum[sfir][0]] -= 1;
								}
							}
						}
					}
				}
				
				System.out.println(Arrays.toString(cnum));
			}
			int end = num.length - 1;
			int fend = num.length -2;
			
			for (int j = i + 1 ; j < change ; j++) {
				temp = num[end];
				num[end] = num[fend];
				num[fend] = temp;
			}
			
			System.out.printf("#%d ", test_case);
			for (int j = 0 ; j < num.length ; j++) {
				System.out.print(num[j]);
			}
			

			
//			for (int i = 0 ; i < snum.length ; i++) {
//				System.out.println(Arrays.toString(snum[i]));
//			}
			
		}

	}

}
