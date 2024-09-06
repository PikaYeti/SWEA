import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import sun.util.locale.StringTokenIterator;

public class Algo3_광주_04반_김가연 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		// 종이를 접는 횟수
		int k = Integer.parseInt(bf.readLine());
		// 구멍의 위치 저장할 배열 설정 -> 한변의 길이가 2^k가 되도록 배열 선언
		int [][] hole = new int[(int) Math.pow(2, k)][(int) Math.pow(2, k)];
		
		// 종이를 접는 방법을 받을 배열 선언
		char [] paper = new char[2 * k];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0 ; i < 2*k ; i++) {
			
		}

	}

}
