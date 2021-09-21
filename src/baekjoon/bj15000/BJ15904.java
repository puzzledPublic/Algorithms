package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//UCPC는 무엇의 약자일까?
public class BJ15904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] UCPC = {'U', 'C', 'P', 'C'};
		int count = 0;
		boolean isUCPC = false;
		String str = br.readLine();
		for(int i = 0; i < str.length(); i++) {
			if(UCPC[count] == str.charAt(i)) {
				count++;
			}
			if(count == 4) {
				isUCPC = true;
				break;
			}
		}
		
		bw.write((isUCPC ? "I love UCPC" : "I hate UCPC"));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
