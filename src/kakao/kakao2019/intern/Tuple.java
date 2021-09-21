package kakao.kakao2019.intern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//튜플
public class Tuple {
	public static void main(String[] args) {
		String[] s = {
				"{{2},{2,1},{2,1,3},{2,1,3,4}}",
				"{{1,2,3},{2,1},{1,2,4,3},{2}}",
				"{{20,111},{111}}",
				"{{123}}",
				"{{4,2,3},{3},{2,3,4,1},{2,3}}",
		};
		
		for(int i = 0; i < s.length; i++) {
			System.out.println(Arrays.toString(solution(s[i])));
		}
	}
	
	static int[] solution(String s) {
        int[] answer = {};
        
        Set<String> set = new HashSet<>();
        
        String[] t = s.substring(1, s.length() - 1).split("\\{|,\\{");	//각 집합별로 분리.
        Arrays.sort(t, (a, b) -> a.length() - b.length());	//길이대로 오름차순 정렬.
        
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < t.length; i++) {	//각 집합별로.
        	String[] subSet = t[i].substring(0 , t[i].length() - 1).split(",");	//원소들 분리.
        	for(int j = 0; j < subSet.length; j++) {	//각 원소별로.
        		if(!set.contains(subSet[j])) {	//튜플에 존재하지 않는 원소라면
        			set.add(subSet[j]);	//캐싱을 위해 set에 추가.
        			list.add(Integer.parseInt(subSet[j]));	//튜플 원소 추가.
        		}
        	}
        }
        
        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
