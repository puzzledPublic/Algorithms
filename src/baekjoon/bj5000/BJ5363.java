package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//요다
public class BJ5363 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String[] words;
		for(int i = 0; i < N; i++) {
			words = br.readLine().split(" ");
			for(int j = 2; j < words.length; j++) {
				bw.write(words[j]+ " ");
			}
			bw.write(words[0] + " " + words[1] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
