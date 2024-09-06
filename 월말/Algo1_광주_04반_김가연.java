import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import sun.util.locale.StringTokenIterator;

public class Algo1_광주_04반_김가연 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// 상담원 멘트가 반복되는 횟수
		int n = Integer.parseInt(st.nextToken());
		
		// 상담원 멘트가 진행되는 시간
		int l = Integer.parseInt(st.nextToken());
		
		// 삼성이가 상담원 요청을 누르는 시간
		int d = Integer.parseInt(st.nextToken());
		
		// 삼성이가 상담원 요청을 누르는 시간 저장
		int sam = d;
		// 처음 시간을 0으로 저장
		int time = 0;
		
		// 상담원 멘트가 반복되는 횟수만큼 for문
		for (int i = 0 ; i < n ; i ++) {
			
			// 만약 상담원 안내 멘트가 진행되는 시간에 삼성이가 상담원 요청을 부르면
			if (sam < (time + l)) {
				// 상담원 안내멘트가 끝날때까지 삼성이의 요청 시간
				while (sam < (time + l)) {
					sam += d;
				}
			}
			
			// 만약 삼성이가 요청한 시간이 안내멘트가 끝난 시점과 안내멘트 재시작 사이라면 반복문 종료
			if (((time + l) <= sam) && (sam < (time + l + 5))) {
				break;
			} else {
				// 아니라면 다음 반복문 돌려주기 위해 시간을 재시작 시간으로 맞춰주기
				time = time + l + 5;
			}
		}
		
		// 삼성이가 상담원 요청을 누르는 시간 출력
		System.out.println(sam);
	}

}
