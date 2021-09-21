package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//행운의 문자열
public class BJ1342 {
	static char[] S;
	static int count;
	static boolean[] chk;
	static int[] amount;
	static int prev = -1;	//문자열을 만들때 이전 문자.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		S = br.readLine().toCharArray();
		chk = new boolean[S.length];
		int[] temp = new int[26];
		//알파벳 개수를 센다.
		for(int i = 0; i < S.length; i++) {
			temp[S[i] -  97]++;
		}
		
		int c = 0;
		for(int i = 0; i < 26; i++) {
			if(temp[i] > 0) c++;
		}
		
		amount = new int[c];
		//1개 이상인 알파벳 개수만 추린다.
		c = 0;
		for(int i = 0; i < 26; i++) {
			if(temp[i] > 0) amount[c++] = temp[i];
		}
		
		solve(0);
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int n) {
		if(n == S.length) {
			count++;
			return;
		}
		int t = prev;
		for(int i = 0; i < amount.length; i++) {
			if(amount[i] > 0 && prev != i) {
				amount[i]--;
				int g = prev;
				prev = i;
				solve(n + 1);
				prev = g;
				amount[i]++;
			}
		}
		prev = t;
	}
}
