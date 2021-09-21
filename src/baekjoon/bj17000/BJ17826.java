package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//나의 학점은?
public class BJ17826 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] scores = new int[51];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int score = Integer.parseInt(br.readLine());
		int num = -1;
		for(int i = 1; i <= 50; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
			if(score == scores[i]) {
				num = i;
			}
		}
		
		String grade = "F";
		if(num <= 5) {
			grade = "A+";
		}else if(num <= 15) {
			grade = "A0";
		}else if(num <= 30) {
			grade = "B+";
		}else if(num <= 35) {
			grade = "B0";
		}else if(num <= 45) {
			grade = "C+";
		}else if(num <= 48) {
			grade = "C0";
		}
		
		bw.write(grade + "\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
