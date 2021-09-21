package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//핸드폰 번호 궁합
public class BJ17202 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		int[] arr = new int[16];
		for(int i = 0; i < 8; i++) {
			arr[i * 2] = s1.charAt(i) - '0';
			arr[i * 2 + 1] = s2.charAt(i) - '0';
		}
		for(int i = 16; i > 2; i--) {
			for(int j = 1; j < i; j++) {
				arr[j - 1] = (arr[j] + arr[j - 1]) % 10;
			}
		}
		
		bw.write(arr[0] + "" + arr[1] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
