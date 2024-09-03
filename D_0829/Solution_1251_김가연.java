package D_0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_1251_김가연 {
	
	static int [] parent;
	
	static void make(int n) {
		parent = new int[n];
		for (int i = 0 ; i < n ; i++) {
			parent[i] = -1;
		}
	}
	
	static int findSet(int a) {
		// 0보다 작은 -1이 저장되어 있다면 현재 집합의 대표자가 자신 -> 자기 자신 리턴
		if (parent[a] < 0) {
			return a;
		}
		// -1이 아니라면 집합에 속해있는 것 이므로
		// 패스압축 해주면서 내 집합의 대표자 찾으러가기
		return parent[a] = findSet(parent[a]);
	}
	
	// 합집합 해주는 함수
	static boolean union(int a, int b) {
		// 만약 파라미터 두 개의 대표자가 같으면 이미 같은 집합에 있는 것이므로 false 리턴
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) {
			return false;
		}
		
		// 다르다면 대표자 값을 합집합 할 대표자로 바꿔주기 -> 합집합
		parent[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1 ; test_case <= tc ; test_case ++) {
			
			int n = Integer.parseInt(bf.readLine());
			
			// 그래프의 노드 정보들 저장할 배열 설정
			int [][] arr = new int[n][2];
			
			// START, END, 가중치 정보 넣어주기 위한 어레이리스트 설정
			// 가중치가 큰 소수점으로 들어가기 때문에 double로 배열 설정해주기
			ArrayList<double []> ocean = new ArrayList<>();
			
			// 그래프 노드 정보 저장
			for (int i = 0 ; i < 2 ; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0 ; j < n ; j++) {
					arr[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 가중치에 곱해줄 부담 세율
			double E = Double.parseDouble(bf.readLine());
			
			// i 반복문은 start 노드
			// j 반복문은 end 노드
			for (int i = 0 ; i < n ; i ++) {
				for(int j = i+1 ; j < n ; j++) {
					// 환경 부담금 계산하기
					double dis = E * ( Math.pow(Math.abs(arr[i][0] - arr[j][0]), 2) + Math.pow(Math.abs(arr[i][1] - arr[j][1]), 2));
					// 좌표값과 환경 부담금 리스트에 넣어주기
					ocean.add(new double [] {i, j, dis});
				}
			}
			
			// 가중치를 기준으로 리스트 오름차순 정렬하기
			Collections.sort(ocean,((o1, o2) -> Double.compare(o1[2], o2[2])));
			
			// 그래프의 각 노드들을 각자 집합으로 만들어주기
			make(n);
			
			// 몇개의 간선을 돌았는지 셀 변수와 환경 부담금을 더해줄 변수 선언
			double cnt = 0, cost = 0;
			
			
			for (int i = 0 ; i < ocean.size() ; i++) {
				double [] oc = ocean.get(i);
				// 각 노드를 돌며 같은 집합이 아닐시 합집합을 만들어주고 간선의 환경 부담금을 더해주기
				if(union((int)oc[0], (int)oc[1])) {
					cost += oc[2];
					cnt ++;
					if (cnt == (n - 1)) {
						break;
					}
				}
			}
			
			// 구한 환경 부담금 출력
			System.out.printf("#%d %.0f \n",test_case, cost);
			
			
		}
	}

}
