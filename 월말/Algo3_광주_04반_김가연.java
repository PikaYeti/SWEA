import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import sun.util.locale.StringTokenIterator;

public class Algo3_����_04��_�谡�� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		// ���̸� ���� Ƚ��
		int k = Integer.parseInt(bf.readLine());
		// ������ ��ġ ������ �迭 ���� -> �Ѻ��� ���̰� 2^k�� �ǵ��� �迭 ����
		int [][] hole = new int[(int) Math.pow(2, k)][(int) Math.pow(2, k)];
		
		// ���̸� ���� ����� ���� �迭 ����
		char [] paper = new char[2 * k];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0 ; i < 2*k ; i++) {
			
		}

	}

}
