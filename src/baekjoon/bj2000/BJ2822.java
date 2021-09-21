package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

//점수 계산
public class BJ2822 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] arr = new int[8][2];
		for(int i = 0; i < 8; i++) {
			arr[i][1] = i + 1;
			arr[i][0] = Integer.parseInt(br.readLine());
		}
		solve(arr, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int[][] arr, Writer w) throws IOException {
		for(int i = 0; i < 7; i++) {
			for(int j = i + 1; j < 8; j++) {
				if(arr[i][0] < arr[j][0]) {
					int temp = arr[i][0];
					arr[i][0] = arr[j][0];
					arr[j][0] = temp;
					temp = arr[i][1];
					arr[i][1] = arr[j][1];
					arr[j][1] = temp;
				}
			}
		}
		int sum = 0;
		for(int i = 0; i < 4; i++) {
			sum += arr[i][0];
			for(int j = i + 1; j < 5; j++) {
				if(arr[i][1] > arr[j][1]) {
					int temp = arr[i][1];
					arr[i][1] = arr[j][1];
					arr[j][1] = temp;
				}
			}
		}
		sum += arr[4][0];
		w.write(sum + "\n");
		for(int i = 0; i < 5; i++) {
			if(i != 4) {
				w.write(arr[i][1] + " ");
			}else {
				w.write(arr[i][1] + "");
			}
		}
	}
}
