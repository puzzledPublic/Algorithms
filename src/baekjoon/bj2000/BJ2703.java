package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Cryptoquote
public class BJ2703 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		char[] subArr = new char[26];	//치환문자
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			String sub = br.readLine();
			
			for(int j = 0; j < sub.length(); j++) {
				subArr[j] = sub.charAt(j);
			}
			
			for(int j = 0; j < line.length(); j++) {
				if(line.charAt(j) != ' ') {	//공백이 아니면 치환
					bw.write(subArr[line.charAt(j) - 65]);
				}else {	//공백은 그대로 출력
					bw.write(" ");
				}
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
