package baekjoon.bj12000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//A와 B
public class BJ12904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String S = br.readLine();
		String T = br.readLine();
		
		//T에서 S로 만들 수 있는지 검사.
		//끝이 A라면 이전 문자열은 현재 문자열에서 마지막 A를 제거한 것.
		//끝이 B라면 이전 문자열은 현재 문자열에서 마지막 B를 제거하고 문자열을 뒤집은 것.
		while(S.length() != T.length()) {
			if(T.endsWith("A")) {
				T = T.substring(0, T.length() - 1);
			}else {
				T = new StringBuilder(T.substring(0, T.length() - 1)).reverse().toString();
			}
		}
		
		//S의 길이로 복구한 T가 S와 같다면 S로 T를 만들 수 있다.
		bw.write((S.equals(T) ? 1 : 0) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
