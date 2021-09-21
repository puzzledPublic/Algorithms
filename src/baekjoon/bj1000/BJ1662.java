package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//압축
public class BJ1662 {
	static String s;
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		s = br.readLine();
		bw.write(solve(0) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int index) {
		int result = 0;
		if(index + 1 < s.length() && s.charAt(index + 1) == '(') {	//현재 문자가 숫자고 다음 문자가 '('인 경우
			result += (s.charAt(index) - '0') * solve(index + 2);	//숫자 * (괄호 내 문자 갯수)
			int i = stack.pop();	//하나의 괄호가 끝났지만 상위 괄호내에 여러개가 포함 될 수 있으므로 다음 위치를 가져온다.
			if(i + 1 < s.length()) {	//아직 다음 문자가 존재하면
				result += solve(i + 1);	//재귀
			}
			return result;
		}
		if(s.charAt(index) == ')') {	//현재 문자가 ')'인 경우
			stack.add(index);	//재귀가 끝나는 지점이고 다음에 이어지는 숫자가 있을 수 있으므로 현재 위치를 저장
			return result;
		}
		result += (index + 1 < s.length() ? solve(index + 1) + 1 : 1);	//현재 문자가 숫자인 경우
		return result;
	}
}
