package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 서로소집합 {

	// 입력값 받아올 배열 선언
	static int [] arr;
	
	// 현재 집합의 대표자 찾는 함수
	static int findSet(int a) {
		// 만약 현재 수가 대표자라면 그냥 리턴
		if (a == arr[a]) {
			return a;
		}
		// 최적화 하기 위해 path Compression 적용
		return (arr[a] = findSet(arr[a]));
	}
	
	// 두개 합집합하는 함수
	static void union(int a, int b) {
		// 각자 수가 포함된 집합의 대표자를 찾아주고
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		// 만약 두개의 대표자가 같다면 이미 같은 집합이므로 그냥 리턴
		if (aRoot == bRoot) {
			return;
		}
		
		// 같지 않다면 둘 중 하나의 대표자를 다른 대표자로 교체해준다
		arr[bRoot] = aRoot;
		return;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			// 집합의 개수 입력받아 배열로 만들기
			int n = Integer.parseInt(st.nextToken());
			arr = new int [n];
			
			// 배열 인덱스와 맞추기 위해 0번부터 n-1까지 채워주기
			for (int i = 0 ; i < n ; i++) {
				arr[i] = i ;
			};
			
			// 테스트케이스 번호 출력
			System.out.printf("#%d ", test_case);
			
			// 연산 입력받기
			int m = Integer.parseInt(st.nextToken());
			for (int i = 0 ; i < m ; i++) {
				StringTokenizer st1 = new StringTokenizer(bf.readLine());
				
				// uf -> 0이면 합집합 연산 / 1이면 같은 집합인지 대표자 확인
				int uf = Integer.parseInt(st1.nextToken());
				
				// 비교할 두 수 입력받기 -> 배열 인덱스와 맞추기 위해 -1 해주기
				int a = Integer.parseInt(st1.nextToken()) - 1;
				int b = Integer.parseInt(st1.nextToken()) - 1;
				
				// 0이면 합집합 연산
				if (uf == 0) {
					union(a, b);
				// 1 이라면 같은 집합인지 대표자 비교해주기
				} else {
					// 같은 집합이라면 1 출력
					if (findSet(a) == findSet(b)) {
						System.out.print(1);
					// 같은 집합이 아니라면 0 출력
					} else {
						System.out.print(0);
					}
				}
			}
			// 다음 테스트케이스 출력을 위해 개행문자 출력
			System.out.println();
			
			
		}

	}

}

