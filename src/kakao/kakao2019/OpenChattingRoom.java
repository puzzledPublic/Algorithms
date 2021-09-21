package kakao.kakao2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//1번 오픈채팅방
public class OpenChattingRoom {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(Arrays.toString(solution(record)));
	}
	
	static String[] solution(String[] record) {
        String[] answer = {};
        String[][] parsed = new String[record.length][];
        for(int i = 0; i < record.length; i++) {
        	parsed[i] = record[i].split(" ");	//각 문자열 파싱.
        }
        
        Map<String, String> userIdMap = new HashMap<>();	//Map<유저아이디(고유값), 닉네임>
        
        for(int i = 0; i < parsed.length; i++) {
        	if(!parsed[i][0].equals("Leave")) {		//Leave를 제외하고는 나머지는 유저아이디와 닉네임이 있으므로 갱신한다.
        		userIdMap.put(parsed[i][1], parsed[i][2]);
        	}
        }
        List<String> printList = new ArrayList<>();
        for(int i = 0; i < parsed.length; i++) {	//최종 출력할 문자열 생성 (최종 닉네임은 Map에 담겨있다)
        	if(parsed[i][0].equals("Enter")) {
        		printList.add(userIdMap.get(parsed[i][1]) + "님이 들어왔습니다.");
        	}else if(parsed[i][0].equals("Leave")) {
        		printList.add(userIdMap.get(parsed[i][1]) + "님이 나갔습니다.");
        	}
        }
        answer = printList.stream().toArray(String[]::new);
        return answer;
    }
}
