package programmers;

import java.util.HashMap;
import java.util.Map;
//완주하지 못한 선수
public class NotFinishedRunner {
	public static void main(String[] args) {
		String[][] participant = {
				{"marina", "josipa", "nikola", "vinko", "filipa"},
				{"mislav", "stanko", "mislav", "ana"}};
		String[][] completion = {
				{"josipa", "filipa", "marina", "nikola"},
				{"mislav", "stanko", "ana"}};
		for(int i = 0; i < participant.length; i++) {
			System.out.println(solution(participant[i], completion[i]));
		}
	}
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < completion.length; i++) {
        	if(map.containsKey(completion[i])) {
        		map.replace(completion[i], map.get(completion[i]) + 1);
        	}else {
        		map.put(completion[i], 1);
        	}
        }
        
        for(int i = 0; i < participant.length; i++) {
        	if(map.get(participant[i]) == null || map.get(participant[i]) == 0) {
            	answer = participant[i];
            	break;
            }
    		map.replace(participant[i], map.get(participant[i]) - 1);
        }
        return answer;
    }
}
