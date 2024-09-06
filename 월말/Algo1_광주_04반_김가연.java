import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import sun.util.locale.StringTokenIterator;

public class Algo1_����_04��_�谡�� {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// ���� ��Ʈ�� �ݺ��Ǵ� Ƚ��
		int n = Integer.parseInt(st.nextToken());
		
		// ���� ��Ʈ�� ����Ǵ� �ð�
		int l = Integer.parseInt(st.nextToken());
		
		// �Ｚ�̰� ���� ��û�� ������ �ð�
		int d = Integer.parseInt(st.nextToken());
		
		// �Ｚ�̰� ���� ��û�� ������ �ð� ����
		int sam = d;
		// ó�� �ð��� 0���� ����
		int time = 0;
		
		// ���� ��Ʈ�� �ݺ��Ǵ� Ƚ����ŭ for��
		for (int i = 0 ; i < n ; i ++) {
			
			// ���� ���� �ȳ� ��Ʈ�� ����Ǵ� �ð��� �Ｚ�̰� ���� ��û�� �θ���
			if (sam < (time + l)) {
				// ���� �ȳ���Ʈ�� ���������� �Ｚ���� ��û �ð�
				while (sam < (time + l)) {
					sam += d;
				}
			}
			
			// ���� �Ｚ�̰� ��û�� �ð��� �ȳ���Ʈ�� ���� ������ �ȳ���Ʈ ����� ���̶�� �ݺ��� ����
			if (((time + l) <= sam) && (sam < (time + l + 5))) {
				break;
			} else {
				// �ƴ϶�� ���� �ݺ��� �����ֱ� ���� �ð��� ����� �ð����� �����ֱ�
				time = time + l + 5;
			}
		}
		
		// �Ｚ�̰� ���� ��û�� ������ �ð� ���
		System.out.println(sam);
	}

}
