package baekjoon.bj13000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//방 배정
public class BJ13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] students = new int[7][2];	//각 학년의 여학생, 남학생 수
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sex = Integer.parseInt(st.nextToken());
			int group = Integer.parseInt(st.nextToken());
			students[group][sex]++;
		}
		
		int count = 0;
		for(int i = 1; i <= 6; i++) {
			for(int j = 0; j < 2; j++) {
				count += students[i][j] / K + (students[i][j] % K > 0 ? 1 : 0);
			}
		}
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
