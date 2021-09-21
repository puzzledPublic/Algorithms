package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//The Deeper, The Better
public class BJ17287 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		
		int currentScore = 0;
		int maxScore = 0;
		for(int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if('0' <= ch && ch <= '9') {
				if(maxScore < currentScore) {
					maxScore = currentScore;
				}
			}else if(ch == '(' || ch == '{' || ch == '[') {
				if(ch == '(') {
					currentScore += 1;
				}else if(ch == '{') {
					currentScore += 2;
				}else {
					currentScore += 3;
				}
			}else {
				if(ch == ')') {
					currentScore -= 1;
				}else if(ch == '}') {
					currentScore -= 2;
				}else {
					currentScore -= 3;
				}
			}
		}
		
		bw.write(maxScore + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
