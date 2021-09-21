package kakao.kakao2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//3번 후보키 
public class CandidateKey {
	public static void main(String[] args) {
		String[][] relation = {
				{"100","ryan","music","2"},
				{"200","apeach","math","2"},
				{"300","tube","computer","3"},
				{"400","con","computer","1"},
				{"500","muzi","music","3"},
				{"600","apeach","music","2"}
		};
//		System.out.println(solution(relation));
		System.out.println(solution2(relation));
	}
	//bit combination
	static int solution(String[][] relation) {
        int answer = 0;
        int n = relation[0].length, t = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < (1 << n); i++) {		//(1 ~ 2^n - 1) n개의 비트로 combination을 나타낼 수 있다.
        	Set<String> set = new HashSet<>();
        	for(int k = 0; k < relation.length; k++) {
        		StringBuilder key = new StringBuilder();
	        	for(int j = 0; j < n; j++) {	//n번동안 1을 한 비트씩 왼쪽으로 움직이며 해당 위치 비트가 켜져있으면 선택된것.
	        		if((i & (1 << j)) > 0) {
	        			key.append(relation[k][j]);
	        		}
	        	}
	        	set.add(key.toString());
        	}
        	if(set.size() == relation.length) {
        		if(list.isEmpty()) {
        			list.add(i);
        		}else {
        			boolean flag = false;
        			for(Integer m : list) {
        				if(m == (m & i)) {
        					flag = true; 
        					break;
        				}
        			}
        			if(!flag) {
        				list.add(i);
        			}
        		}
        	}
        }
        return answer = list.size();
    }
	//recursive combination
	static int solution2(String[][] relation) {
		boolean[] chk = new boolean[relation[0].length];	//선택한 컬럼을 나타낼 체크배열
		List<boolean[]> list = new ArrayList<>();			//후보키 리스트
		recur(relation, list, chk, 0);
		return list.size();
	}
	
	static void recur(String[][] relation, List<boolean[]> list, boolean[] chk, int n) {
		if(n == chk.length) {	//컬럼을 모두 선택했으면
			Set<String> set = new HashSet<>();
			for(int i = 0; i < relation.length; i++) {		//선택한 컬럼들로 키들을 만들어 set에 저장한다.
				StringBuilder sb = new StringBuilder();
				for(int j = chk.length - 1; j >= 0; j--) {	
					if(chk[j]) {
						sb.append(relation[i][j]);
					}
				}
				set.add(sb.toString());	
			}
			if(set.size() == relation.length) {		//set 크기가 릴레이션 행만큼이면 중복되는게 없고 이는 후보키 후보다.
				if(list.isEmpty()) {	//후보키 리스트에 아무것도 없으면 추가. (이떄 컬럼 탐색 순서가 중요, 최소성 검사를 위해 컬럼 선택을 1개부터 늘려가야한다.)
					list.add(chk.clone());
				}else {		//후보키 리스트에 후보키가 들어있으면
					boolean flag = false;
					for(boolean[] b : list) {	//후보키 리스트를 순회하며
						flag = false;
						boolean[] tmp = new boolean[chk.length];	//b == (b & chk)인지 확인하는 연산. (검사하려는 키(chk)가 후보키(b)에 완전 포함되면 최소성 만족이 되지 않는다)
						for(int i = 0; i < b.length; i++) {		//&연산
							if(!b[i] || !chk[i]) {	
								tmp[i] = false;
							}else if(b[i] && chk[i]) {
								tmp[i] = true;
							}
						}
						for(int i = 0; i < b.length; i++) {	// == 연산
							if(tmp[i] != b[i]) {
								flag = true;
							}
						}
						if(!flag) {		//b == (b & chk)가 true라면 그대로 종료하고 후보키 리스트에 추가하지 않는다.
							break;
						}
					}
					if(flag) {
						list.add(chk.clone());
					}
				}
			}
			return;
		}
		recur(relation, list, chk, n + 1);	//현재 후보키를 고르지 않거나
		chk[n] = true;
		recur(relation, list, chk, n + 1);	//현재 후보키를 고르거나
		chk[n] = false;
	}
}
