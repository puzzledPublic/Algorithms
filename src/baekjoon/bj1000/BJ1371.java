package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//가장 많은 글자
public class BJ1371 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] alphabet = new int[26];
		String str = null;
		while((str = br.readLine()) != null) {
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if(('a' <= ch && ch <= 'z')) {
					alphabet[ch - 'a']++;
				}
			}
		}
		
		int max = 0; 
		for(int i = 0; i < 26; i++) {
			if(max < alphabet[i]) {
				max = alphabet[i];
			}
		}
		
		for(int i = 0; i < 26; i++) {
			if(max == alphabet[i]) {
				bw.write((i + 'a'));
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
