package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//좋은수열
public class BJ2661 {
	static int N;
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		solve(0, "");
		br.close();
	}
	
	static void solve(int n, String s) {
		if(flag) {	//이미 출력했다면 탐색 중지
			return;
		}
		if(n == N) {	//원하는 자리수까지 만들었으면 (제일 먼저 도착하는 수열이 최소)
			if(!flag) {	//출력하고 출력했음을 표시
				System.out.println(s);
				flag = true;
			}
			return;
		}
		for(int i = 1; i < 4; i++) {	//1, 2, 3을 순서대로 시도해본다.
			if(possible(s + i)) {	//다음 숫자를 붙였을때 가능한가?
				s += i;	//가능하면	붙인다.
				solve(n + 1, s);	//다음 자리수로
				s = s.substring(0, s.length() - 1);	//백트래킹
			}
		}
	}
	static boolean possible(String s) {	//오른쪽에 붙여나가므로 오른쪽에서 시작하여 절반까지만 비교하면된다.
		int half = s.length() % 2 == 0 ? s.length() / 2 : s.length() / 2 + 1;	//수열이 짝수개인가 홀수개인가에 따라 절반을 조정
		for(int i = half; i < s.length(); i++) {
			if(s.substring(i, s.length()).equals(s.substring(i - (s.length() - i), i))) {
				return false;
			}
		}
		return true;
	}
}
