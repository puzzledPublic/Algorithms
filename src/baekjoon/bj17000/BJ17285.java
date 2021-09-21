package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//XORChic
public class BJ17285 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] line = br.readLine().toCharArray();
		char key = (char)(line[0] ^ 'C');
		for(int i = 0; i < line.length; i++) {
			bw.write((line[i] ^ key));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
