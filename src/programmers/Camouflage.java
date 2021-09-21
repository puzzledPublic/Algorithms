package programmers;

import java.util.HashMap;
import java.util.Map;

//위장
public class Camouflage {
	public static void main(String[] args) {
		String[][][] clothes = {
				{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}},
				{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}
		};
		for(int i = 0; i < clothes.length; i++) {
			System.out.println(solution(clothes[i]));
		}
	}
	static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
        	if(map.containsKey(clothes[i][1])) {
        		map.replace(clothes[i][1], map.get(clothes[i][1]) + 1);
        	}else {
        		map.put(clothes[i][1], 2);
        	}
        }
        for(String s : map.keySet()) {
        	answer *= map.get(s);
        }
        return answer - 1;
    }
}
