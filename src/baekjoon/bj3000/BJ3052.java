package baekjoon.bj3000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//나머지
public class BJ3052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[42];
		for(int i = 0; i < 10; i++) {
			arr[Integer.parseInt(br.readLine()) % 42]++;
		}
		int count = 0;
		for(int i = 0; i < 42; i++) {
			if(arr[i] > 0) {
				count++;
			}
		}
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
