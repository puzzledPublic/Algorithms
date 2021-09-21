package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//베르트랑 공준
public class BJ4948 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] arr = new boolean[(123456 * 2) + 1];
		for(int i = 2; i * i <= arr.length - 1; i++) {
			if(!arr[i]) {
				for(int j = i * 2; j <= arr.length - 1; j += i) {
					arr[j] = true;
				}
			}
		}
		int N, sum = 0;
		while ((N = Integer.parseInt(br.readLine())) != 0){
			for(int i = N + 1; i <= N * 2; i++) {
				if(!arr[i]) {
					sum++;
				}
			}
			bw.write(sum + "\n");
			sum = 0;
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
