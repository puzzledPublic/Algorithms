package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//에니그마
public class BJ17289 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		
		char[][] circle = new char[8][26];
		circle[0][0] = 'C';
		circle[1][0] = 'H';
		circle[2][0] = 'I';
		circle[3][0] = 'C';
		circle[4][0] = 'K';
		circle[5][0] = 'E';
		circle[6][0] = 'N';
		circle[7][0] = 'S';
		for(int i = 0; i < 8; i++) {
			for(int j = 1; j < 26; j++) {
				circle[i][j] = (char)(((circle[i][j - 1] - 'A' + 1) % 26) + 'A');
			}
		}
		for(int i = 0; i < line.length(); i++) {
			int nextPos = line.charAt(i) - 'A';
			for(int j = 0; j < 7; j++) {
				nextPos = circle[j][nextPos] - 'A';
			}
			char t = circle[0][0];
			for(int j = 1; j < 26; j++) {
				circle[0][j - 1] = circle[0][j];
			}
			circle[0][25] = t;
			bw.write(circle[7][nextPos]);
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
