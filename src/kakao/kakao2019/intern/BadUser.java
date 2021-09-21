package kakao.kakao2019.intern;

import java.util.HashSet;
import java.util.Set;

//불량 사용자
public class BadUser {
	public static void main(String[] args) {
		String[][] user_id = {
				{"frodo", "fradi", "crodo", "abc123", "frodoc"},
				{"frodo", "fradi", "crodo", "abc123", "frodoc"},
				{"frodo", "fradi", "crodo", "abc123", "frodoc"},
		};
		
		String[][] banned_id = {
				{"fr*d*", "abc1**"},
				{"*rodo", "*rodo", "******"},
				{"fr*d*", "*rodo", "******", "******"},
		};
		
		for(int i = 0; i < user_id.length; i++) {
			System.out.println(solution(user_id[i], banned_id[i]));
		}
	}
	static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        String[] chk = new String[user_id.length];
        
        answer = solve(0, chk, user_id, banned_id, set);
        
        return answer;
    }
	//user_id가 8개 이하므로 완전탐색.
	static int solve(int b, String[] chk, String[] user_id, String[] banned_id, Set<String> set) {
		if(b == banned_id.length) {	//banned_id 모두 매칭했으면.
			//집합이 같은 경우가 있으므로 중복 제거를 위해 문자열로 만들어 캐싱.
			StringBuilder sb = new StringBuilder();
			for(String s : chk) {
				sb.append(s);
			}
			if(set.contains(sb.toString())) {
				return 0;
			}
			set.add(sb.toString());
			return 1;
		}
		
		int result = 0;
		for(int i = 0; i < user_id.length; i++) {
			if(chk[i] == null && match(user_id[i], banned_id[b])) {
				chk[i] = user_id[i];
				result += solve(b + 1, chk, user_id, banned_id, set);
				chk[i] = null;
			}
		}
		return result;
	}
	
	static boolean match(String a, String b) {	//참석 유저 아이디, 제외 유저 아이디가 맞는지 검사.
		if(a.length() != b.length()) {
			return false;
		}
		for(int i = 0; i < a.length(); i++) {
			if(b.charAt(i) != '*' && a.charAt(i) != b.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
