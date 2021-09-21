package kakao.kakao2020.intern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//보석 쇼핑
public class JewelShopping {
	public static void main(String[] args) {
		String[][] gemss = {
				{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"},	//[3, 7]
				{"AA", "AB", "AC", "AA", "AC"},	//[1, 3]
				{"XYZ", "XYZ", "XYZ"},	//[1, 1]
				{"ZZZ", "YYY", "NNNN", "YYY", "BBB"},	//[1, 5]
				{"A", "B", "B", "C", "A", "B", "C"},	//[3, 5]
		};
		
		for(int i = 0; i < gemss.length; i++) {
			System.out.println(Arrays.toString(solution(gemss[i])));
		}
	}
	
	static int[] solution(String[] gems) {
        int[] answer = {};
        
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < gems.length; i++) {
        	if(!set.contains(gems[i])) {
        		set.add(gems[i]);
        	}
        }
        
        int start = 0, end = 0;
        Map<String, Integer> map = new HashMap<>();
        while(!set.isEmpty()) {
        	if(set.contains(gems[end])) {
        		set.remove(gems[end]);
        	}
        	if(map.containsKey(gems[end])) {
        		map.replace(gems[end], map.get(gems[end]) + 1);
        	}else {
        		map.put(gems[end], 1);
        	}
        	end++;
        }
        
        while(map.get(gems[start]) > 1) {
    		map.replace(gems[start], map.get(gems[start]) - 1);
    		start++;
    	}
        
        int max = end - start;
        int startP = start, endP = end;
        for(int i = end; i < gems.length; i++) {
        	map.replace(gems[i], map.get(gems[i]) + 1);
        	while(map.get(gems[start]) > 1) {
        		map.replace(gems[start], map.get(gems[start]) - 1);
        		start++;
        	}
        	if(max > i - start + 1) {
        		max = i - start + 1;
        		startP = start;
        		endP = i + 1;
        	}
        }
        
        return answer = new int[] {startP + 1, endP};
    }
}
