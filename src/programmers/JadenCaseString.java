package programmers;

import java.util.Arrays;

//Jaden Case 문자열 만들기
public class JadenCaseString {
	public static void main(String[] args) {
		String[] s = { 
				"3people unFollowed me", 
				"for the last week"
				};
		for (int i = 0; i < s.length; i++) {
			System.out.println(solution(s[i]));
		}
	}

	static String solution(String s) {
		String answer = "";
		s = s.toLowerCase();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if ((i == 0) || (i - 1 >= 0 && s.charAt(i - 1) == ' ')) {
				if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
					sb.append((char) (s.charAt(i) - 32));
				} else {
					sb.append(s.charAt(i));
				}
			} else {
				sb.append(s.charAt(i));
			}
		}
		return answer = sb.toString();
	}
	static String solution2(String s) {
		String answer = "";
		answer = Arrays.stream(s.toLowerCase().split(" ")).map((a) -> {
			if(a.length() == 0) {
				return "";
			}
			if('a' <= a.charAt(0) && a.charAt(0) <= 'z') {
				return (char)(a.charAt(0) - 32) + a.substring(1);
			}
			return a;
		}).reduce((a, b) -> String.join(" ", a, b)).get();
		int index = s.length() - 1;
		while(s.charAt(index--) == ' ') {
			answer += ' ';
		}
		return answer;
	}
}
