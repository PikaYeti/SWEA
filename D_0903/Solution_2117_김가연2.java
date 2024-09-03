package SWEA.D_0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_2117_김가연2 {

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
			
			int change = Integer.parseInt(st.nextToken());
			
			int [][] snum = new int [num.length][2];
			int [] cnum = new int [10];
			
			ArrayList<int[]> numlist = new ArrayList<>();
			
			for (int i = 0 ; i < num.length ; i++) {
				snum[i][0] = num[i];
				cnum[snum[i][0]] += 1;
				snum[i][1] = i;
				numlist.add(new int[] {num[i], i});
			}
						
		}

	}

}
