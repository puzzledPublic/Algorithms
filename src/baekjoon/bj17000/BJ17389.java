package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//보너스 점수
public class BJ17389 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String ox = br.readLine();
		
		int score = 0, bonus = 0;
		for(int i = 0; i < ox.length(); i++) {
			if(ox.charAt(i) == 'O') {	//문제를 맞췄으면
				score += (i + 1 + bonus);	//기본 점수 + 보너스 점수
				bonus++;	//보너스 점수 증가
			}else {	//문제를 못 맞췄으면
				bonus = 0;	//보너스 점수 초기화
			}
		}
		
		bw.write(score + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
