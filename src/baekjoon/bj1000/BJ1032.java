package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//명령 프롬프트
public class BJ1032 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] strs = new String[N];
		for(int i = 0; i < N; i++) {
			strs[i] = br.readLine();
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < strs[0].length(); i++) {	//각 문자에대해
			char ch = strs[0].charAt(i);
			for(int j = 1; j < N; j++) {
				if(strs[j].charAt(i) != ch) {	//문자가 다르다면 ?로 치환
					ch = '?';
					break;
				}
			}
			sb.append(ch);
		}
		bw.write(sb.toString() + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
