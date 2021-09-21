package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//아!
public class BJ4999 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String say = br.readLine();
		String sayit = br.readLine();
		
		if(say.length() < sayit.length()) {
			bw.write("no\n");
		}else {
			bw.write("go\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
