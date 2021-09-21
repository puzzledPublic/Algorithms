package baekjoon.bj8000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//악수
public class BJ8394 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[3];
		arr[0] = arr[1] = 1;
		for(int i = 2; i <= N; i++) {
			arr[i % 3] = (arr[(i - 1) % 3] + arr[(i - 2) % 3]) % 10;
		}
		
		bw.write(arr[N % 3] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
