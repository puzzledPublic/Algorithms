package kakao.kakao2018;

import java.util.Stack;

//N진수 게임
//result = 0111, 02468ACE11111111, 13579BDF01234567
public class NNumeralSystemGame {
	static int[] n = {2, 16, 16, 8}; //진법
	static int[] t = {4, 16, 16, 100}; //미리 구할 숫자의 갯수
	static int[] m = {2, 2, 2, 4};	  //게임에 참가하는 인원
	static int[] p = {1, 1, 2, 3};	  //튜브의 순서

	static char[] numeralSystem = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	static char[][] sequences;
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) {
		
		sequences = new char[n.length][];
		for(int i = 0; i < n.length; i++) {
			sequences[i] = new char[t[i] * m[i]];
		}
		
		for(int i = 0; i < n.length; i++) {
			stack.clear();
			solve(sequences[i], n[i], t[i], m[i], p[i]);
		}
		
	}
	
	static void solve(char[] sequence, int n, int t, int m, int p) {
		int count = 0;
		int number = 0, temp = number;
		int limit = m * t;
		
		while(count < limit) {
			if(temp < n) {
				sequence[count++] = numeralSystem[temp];
				while(!stack.isEmpty() && count < limit) {
					sequence[count++] = stack.pop();
				}
				temp = ++number;
			}else {
				stack.push(numeralSystem[temp % n]);
				temp /= n;
			}
		}
		for(int i = p - 1; i < sequence.length; i+=m) {
			System.out.print(sequence[i]);
		}
		System.out.println();
	}
	
}
