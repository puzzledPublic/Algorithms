package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//최빈수 구하기
public class SWEA1204 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			br.readLine();
			int[] score = new int[101];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while(st.hasMoreTokens()) {
				int s = Integer.parseInt(st.nextToken());
				score[s]++;	//점수 s의 개수
			}
			int max = -1, maxScore = 0;
			for(int j = 0; j < 101; j++) {
				if(max <= score[j]) {
					max = score[j];
					maxScore = j;
				}
			}
			bw.write("#" + i + " " + maxScore + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
