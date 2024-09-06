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
			
			// 문자열의 길이 받아주는 변수 설정
			int N = Integer.parseInt(st.nextToken());
			
			// 내림차순 배열에서 몇번째 원소를 선택할 지 저장할 변수 설정
			int K = Integer.parseInt(st.nextToken());
			
			// 문자열을 넣어 회전시켜 줄 큐 선언
			Queue<String> pwline = new LinkedList<>();
			
			// 문자열을 받아 한글자씩 잘라 큐에 넣어주기
			String pw = new String(bf.readLine());
			for (int i = 0 ; i < N ; i++) {
				pwline.add(String.valueOf(pw.charAt(i))); 
			}
			
			// 중복 비밀번호 제거하기 위해 해시셋 선언
			HashSet<String> pwSet = new HashSet<>();
			
			// 문자열을 한바퀴 돌려줄 동안
			for (int turn = 0 ; turn < N ; turn ++) {
				
				// 한 문자열에 비밀번호가 4개 나올 때 까지
				for (int i = 0 ; i < 4 ; i ++) {
					String str = null;
					
					// 큐에서 한글자씩 뽑아 비밀번호 문자열 만들어주고 해시셋에 넣어주기
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
				
				// 4개의 비밀번호를 만들었으면 앞 한글자를 뒤로 다시 넣어주기
				String back = pwline.poll();
				pwline.add(back);
			}
			
			// 비밀번호 값 계산해주기 위해 해시셋 크기 만큼 배열 선언
			Integer [] arr = new Integer [pwSet.size()];
			int idx = 0;
			
			// 해시셋 원소들을 돌려주기
			for (String pwStr : pwSet) {
				
				// 16진수 값을 구하기 위해 맨 앞자리가 16의 몇제곱인지 구해주기
				int vp = N/4 - 1;
				
				// 각 자릿수의 합 구하기 위한 변수 선언
				int sum = 0;
				
				// 각 자릿수를 숫자로 바꿔 저장하기 위한 변수 선언
				int value = 0;
				
				// 각 자리를 숫자로 바꿔 해당 자리의 16의 n제곱을 곱해주기
				for (int i = 0 ; i < N/4 ; i++) {
					if ((65 <= pwStr.charAt(i)) && (pwStr.charAt(i) <= 70)) {
						value = pwStr.charAt(i) - 55;
					} else {
						value = pwStr.charAt(i) - '0';
					}
					sum += Math.pow(16, vp) * value;
					vp--;
				}
				
				// 구한 값 배열에 저장
				arr[idx] = sum;
				idx ++;
			}
			
			// 배열을 내림차순 해주기
			Arrays.sort(arr, Collections.reverseOrder());
			
			// k-1번째 자리 출력하기
			System.out.printf("#%d %d \n", test_case, arr[K-1]);
		}
		
	}

}
