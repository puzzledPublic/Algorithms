package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//귀여운 수
public class BJ17294 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String number = br.readLine();
		
		boolean can = true;
		for(int i = 2; i < number.length(); i++) {
			if(number.charAt(i) - number.charAt(i - 1) != number.charAt(1) - number.charAt(0)) {
				can = false;
				break;
			}
		}
		
		bw.write((can ? "◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!" : "흥칫뿡!! <(￣ ﹌ ￣)>"));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
