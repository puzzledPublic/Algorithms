package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//빠른 A + B
public class BJ15552 {
	public static void main(String[] args) throws IOException {		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int n = Integer.parseInt(br.readLine().trim());
			
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
						
			int index = input.indexOf(" ");
			
			int n1 = Integer.parseInt(input.substring(0, index));
			
			int n2 = Integer.parseInt(input.substring(index+1, input.length()));
				
			bw.write((n1 + n2) + "\n");
		}
		bw.flush();
		br.close();

		bw.close();
	}
	/*//느린버전
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()), a, b;
		String[] s;
		for(int i = 0; i < T; i++) {
			s = br.readLine().split(" ");
			a = Integer.parseInt(s[0]);
			b = Integer.parseInt(s[1]);
			bw.write((a + b) + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}*/
}

