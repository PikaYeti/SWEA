package SWEA.월말;

public class 조합정리 {
	
	static int [] numbers = new int[] {1, 2, 3, 4, 5};
//	static int [] selected = new int[2];
	static List<Integer> selected = new LinkedList<>();
	
	static void comb(int idx, int count) {
		
		// 다 뽑았다면
		if (count == 2) {
			return;
		}
		
		for (int i = idx ; i < numbers.length ; i++) {
			
			selected[count] = numbers[i];
			// 조합은 내가 뽑은 것 다음 숫자부터 넘겨줘야 하기 때문에 i + 1
			comb(i + 1, count + 1);
			
			// 중복조합은 첫 파라미터를 현재 값으로 넘겨주기
			comb(i, count + 1);
			
			// 중복 순열은 i값 넘기지 않고 몇개를 뽑았는지만 넘긴다
			comb(count + 1);
			
			// 순열은 방문처리 필요
			
			// 부분집합은 각 숫자를 넣을지 말지 체크해서 넣어준다
			visit[i] = true;
			comb(i + 1, count + 1);
			
			visit[i] = false;
			comb(i + 1, count + 1);
			
			// 다음 재귀로 넘어갔을 때 값이 덮어써지기 때문에 원복 필요 X
			// 하지만 동적(List)으로 정답 배열을 관리할 때는 원복(삭제) 필요 -> 특정 인덱스가 아니라 끄트머리에 '추가' 하는 것 이기 때문
			
		}
	}
	
	//  신기한 부분집합 코드
	static void comb2(int idx, int count) {
		// depth가 덜 들어가는 코드
		// 하지만 조건이 복잡해지면 (ex. 2와 3이 같이 뽑히면 역순으로 처리하라) 액션 불가
		System.out.println(selected);
		
		for (int i = idx ; i < numbers.length ; i++) {
			selected.add(numbers[i]);
			comb2(i + 1, count + 1);
			selected.remove(selected.size() - 1);
		}
	}

	public static void main(String[] args) {
		// 몇번째 인덱스부터 뽑을것인지, 몇개를 뽑을것인지
		comb(0,0);

	}
	
	

}
