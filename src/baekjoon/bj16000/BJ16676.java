package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//근우의 다이어리 꾸미기
public class BJ16676 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String n = br.readLine();
		
		int len = n.length();
		
		String str = "";
		for(int i = 0; i < len; i++) {
			str += 1;
		}
		int a = Integer.parseInt(n);
		int b = Integer.parseInt(str);
		if(a >= b) {
			bw.write(len + "\n");
		}else {
			if(len == 1) {
				bw.write(len + "\n");
			}else {
				bw.write((len - 1) + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
