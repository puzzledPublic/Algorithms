package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//데구르르
public class BJ9494 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t;
		while((t = Integer.parseInt(br.readLine())) != 0) {
			int index = 0;	//다음번 떨어질때 열의 위치
			for(int i = 0; i < t; i++) {
				String s = br.readLine();
				int g;
				if(s.length() > index) {
					g = s.indexOf(" ", index);
					if(g == -1) {	//중간 공백이 없는 경우 문자열 끝까지 굴러간다.
						index = s.length();
					}else {	//중간 공백이 있으면 다음번 떨어질 위치를 갱신
						index = g;
					}
				}
			}
			bw.write((index + 1) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
