package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//괄호 추가하기
public class BJ16637 {
	static int N;
	static String str;
	static int MAX = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		str = br.readLine();
		
		solve(0, '+', 0);
		
		bw.write(MAX + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	//해당 숫자에 대해 괄호를 두거나 안두거나.
	static void solve(int next, char prevOp, int prevCal) {
		int result = Integer.MIN_VALUE;
		if(next == N - 1) {	//마지막 숫자라면 괄호를 둘 수 없으므로 그냥 계산.
			result = Math.max(result, calculate(prevCal, prevOp, str.charAt(next) - '0'));
		}
		else if(next + 2 == N - 1) {	//괄호를 칠 수 있는 마지막 숫자라면
			solve(next + 2, str.charAt(next + 1), calculate(prevCal, prevOp, str.charAt(next) - '0'));	//괄호를 안치거나
			result = Math.max(result, calculate(prevCal, prevOp, calculate(str.charAt(next) - '0', str.charAt(next + 1), str.charAt(next + 2) - '0')));	//괄호를 치는 경우 계산
		}else {	//그 외의 경우
			solve(next + 2, str.charAt(next + 1), calculate(prevCal, prevOp, str.charAt(next) - '0'));	//괄호를 안치거나
			
			solve(next + 4, str.charAt(next + 3), calculate(prevCal, prevOp, calculate(str.charAt(next) - '0', str.charAt(next + 1), str.charAt(next + 2) - '0')));	//괄호를 치거나
		}
		if(MAX < result) {
			MAX = result;
		}
	}
	
	static int calculate(int left, char op, int right) {
		switch(op) {
			case '+':
				return left + right;
			case '-':
				return left - right;
			default :
				return left * right;
		}
	}
}
