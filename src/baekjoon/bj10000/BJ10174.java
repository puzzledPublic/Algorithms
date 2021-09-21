package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//팰린드롬
public class BJ10174 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String str = br.readLine().toLowerCase();
			int s = 0, e = str.length() - 1;
			boolean isPalindrom = true;
			while(s < e) {
				if(str.charAt(s) != str.charAt(e)) {
					isPalindrom = false;
					break;
				}
				s++;
				e--;
			}
			bw.write(isPalindrom ? "Yes\n" : "No\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
