package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//잃어버린 괄호
public class BJ1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		solve(s);
		br.close();
	}
	static void solve(String s) {	//-이 나오면 그 뒤로 모든 숫자를 음수로 생각하면 된다.
		int result = 0, index = 0, re = 1;
		String[] ss = s.split("[+|-]");	// +, - 기준으로 문자열 분해
		result += Integer.parseInt(ss[index++]);	//첫 숫자는 더해놓고(첫 숫자는 부호가 안붙으므로)
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '-') {	//-문자가 나오면 그 뒤로 모든 숫자는 음수
				re = -1;
			}
			if(s.charAt(i) == '-' || s.charAt(i) == '+') {	//+나 -가 나오면 더해준다.
				result += re * Integer.parseInt(ss[index++]);
			}
		}
		System.out.println(result);
	}
}
