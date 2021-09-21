package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//평균은 넘겠지
public class BJ4344 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()), m, sum, s; 
		int[] student;	//학생들 점수
		for(int i = 0 ; i < T; i++) {
			m = sum = 0;	//평균, 합 초기화
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());	//학생 수
			student = new int[s];
			int k = 0;
			while(st.hasMoreTokens()) {
				sum += (student[k++] = Integer.parseInt(st.nextToken()));
			}
			m = sum / s;	//평균 계산
			int ss = 0;
			for(int j = 0; j < s; j++) {
				if(student[j] > m) {	//평균보다 높으면
					ss++;
				}
			}
			System.out.printf("%.3f%%\n", (double)ss / s * 100);	//소수점 셋째자리까지
		}
	}
}
