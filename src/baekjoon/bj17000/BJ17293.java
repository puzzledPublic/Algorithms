package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//맥주 99병
public class BJ17293 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = N; i > 0; i--) {
			bw.write(i + (i == 1 ? " bottle" : " bottles") + " of beer on the wall, " + i + (i == 1 ? " bottle" : " bottles") + " of beer.\n" + 
					"Take one down and pass it around, "+ (i - 1 == 1 ? (i - 1) + " bottle" : (i - 1 == 0 ? "no more bottles" : (i - 1) + " bottles")) + " of beer on the wall.\n\n");
		}
		bw.write("No more bottles of beer on the wall, no more bottles of beer.\n" + 
				"Go to the store and buy some more, " + N + (N == 1 ? " bottle" : " bottles") + " of beer on the wall.");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
