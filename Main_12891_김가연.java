package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12891_김가연 {
	
	static int [] req;
	static int cnt = 0;
	
	
	// 큐에 저장된 dna 갯수가 주어진 만족 조건과 일치하는지 확인하는 함수
	static boolean ifequal(int [] save) {
		for (int i = 0 ; i < 4 ; i ++) {
			if (save[i] < req[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		req = new int[4]; // 만족해야 하는 dna 갯수 저장할 배열
		int [] save = new int [4]; // 현재 조합의 dna 갯수 저장할 배열
		int [] dset = new int[s]; // dna 저장 배열
		
		// 조합 저장할 큐 선언
		Queue<Integer> dque = new LinkedList<>();

		// 주어진 dna문자열 배열에 넣기
		String dna = new String(bf.readLine());
		for (int i = 0 ; i < s ; i++) {
			if (dna.charAt(i) == 'A') {
				dset[i] = 0;
			}
			else if (dna.charAt(i) == 'C') {
				dset[i] = 1;
			}
			else if (dna.charAt(i) == 'G') {
				dset[i] = 2;
			}
			else {
				dset[i] = 3;
			}
		}
		
		// dna 갯수 조건 저장
		StringTokenizer st1 = new StringTokenizer(bf.readLine());
		for (int i = 0 ; i < req.length ; i++) {
			req[i] = Integer.parseInt(st1.nextToken());
		}
		
		// 몇번째 dna 배열 넣어야 하는지 체크하는 변수 선언
		int num = 0;
		
		// 일단 처음 - 주어진 부분 문자열 길이만큼 큐에 넣고 save 배열에 갯수 저장하기
		for (int i = 0 ; i < p ; i++) {
			dque.add(dset[i]);
			save[dset[i]] += 1;
			num++;
		}
		
		// 첫번째 조합이 조건을 만족하는지 확인
		if (ifequal(save)) {
			cnt++;
		}
		
		// 남은 조합만큼 돌며 조건 만족하는지 확인
		for (int i = 0 ; i < (s - p) ; i++) {
			int n = dque.poll();
			save[n] -= 1;
			dque.add(dset[num]);
			save[dset[num]] += 1;
			if (ifequal(save)) {
				cnt++;
			}
			num++;
		}
		
		// 조건 만족하는 조합 갯수 출력
		System.out.println(cnt);
	}

}
