package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//2018년을 되돌아보며
public class BJ16674 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int[] chk = new int[10];
		
		boolean not = false;
		for(int i = 0; i < str.length(); i++) {
			chk[str.charAt(i) - '0']++;
			if(str.charAt(i) != '0' && str.charAt(i) != '1' && str.charAt(i) != '2' && str.charAt(i) != '8') {
				not = true;
			}
		}
		if(not) {
			bw.write("0\n");
		}else {
			if(chk[0] > 0 && chk[1] > 0 && chk[2] > 0 && chk[8] > 0) {
				if(chk[0] == chk[1] && chk[1] == chk[2] && chk[2] == chk[8]) {
					bw.write("8\n");
				}else {
					bw.write("2\n");
				}
			}else {
				bw.write("1\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
