package baekjoon.bj12000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Circular Barn
public class BJ12000 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] barn = new int[N];
		for(int i = 0; i < N; i++) {
			barn[i] = Integer.parseInt(br.readLine());
		}
		long min = Long.MAX_VALUE, next = 0;
		for(int i = 0; i < N; i++) {	//각각 한 곳간에 문을 열어놓은 경우를 모두 탐색.
			int temp = 0;
			for(int j = 0; j < N; j++) {
				temp += barn[j] * ((next + j) % N);
			}
			if(min > temp) {
				min = temp;
			}
			next += (N - 1);
		}
		bw.write(min + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
