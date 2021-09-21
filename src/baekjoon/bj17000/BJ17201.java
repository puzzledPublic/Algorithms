package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//자석 체인
public class BJ17201 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		boolean isAligned = true;
		
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == str.charAt(i - 1)) {
				isAligned = false;
				break;
			}
		}
		
		bw.write(isAligned ? "Yes\n" : "No\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
