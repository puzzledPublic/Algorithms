package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//QuickSum
public class BJ4613 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input;
		while(!(input = br.readLine()).equals("#")) {
			int sum = 0;
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) != ' ') {
					sum += (i + 1) * (input.charAt(i) - 'A' + 1);
				}
			}
			bw.write(sum + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
