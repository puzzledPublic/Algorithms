package programmers;
//조이스틱	(이해필요)
public class JoyStick {
	public static void main(String[] args) {
		String[] name = { "JEROEN", "JAN", "AAAA", "AAAAAB", "AABAA", "BBAAAB", "BBAAABAB", "BABAAABAAAB"};	//56, 23, 0, 2, 3, 6, 9, 12
		for(int i = 0; i < name.length; i++) {
			System.out.println(solution(name[i]));
		}
	}
	
	static int solution(String name) {
        int answer = 0;
        for(int i = 0; i < name.length(); i++) {	//모든 글자에 대해 상, 하 조작시 최소 움직임 계산.
        	int current = name.charAt(i) - 'A';
        	if(current > 12) {
        		answer += current - (2 * (current % 13));
        	}else {
        		answer += current;
        	}
        }
        //좌, 우 조작시 최소 움직임 계산.
        int base = name.length() - 1;
        int mio = 0;
        for(int i = 1; i < name.length(); i++) {
        	int initiate = -1;
        	int fine = -1;
        	if(name.charAt(i) == 'A') {
        		initiate = i;
	        	for(int j = i + 1; j < name.length(); j++) {
	        		i++;
	        		if(name.charAt(j) != 'A') {
	        			fine = j - 1;
	        			break;
	        		}
	        	}
	        	if(fine == -1) {
	        		fine = name.length() - 1;
	        	}
	        	int curr_risparmio = (fine + 1 - initiate) - Math.min(initiate - 1, name.length() - (fine + 1));
	        	if(curr_risparmio > mio) {
	        		mio = curr_risparmio;
	        	}
        	}
        }
        answer += base - mio;
        return answer;
    }
}
