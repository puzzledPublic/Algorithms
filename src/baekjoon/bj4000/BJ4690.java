package baekjoon.bj4000;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//완전 세제곱
public class BJ4690 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[1_000_001];
		
		Arrays.fill(arr, -1);
		for(int i = 0; i <= 100; i++) {
			arr[i * i * i] = i; 
		}
		
		for(int a = 2; a <= 100; a++) {
			for(int b = 2; b <= 100; b++) {
				for(int c = b + 1; c <= 100; c++) {
					int d = (a * a * a) - (b * b * b) - (c * c * c);
					if(2 <= d && d <= 1_000_000 && arr[d] != -1 && c <= arr[d]) {
						bw.write("Cube = " + a + ", Triple = (" + b + "," + c + "," + arr[d] + ")\n");
					}
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
}
