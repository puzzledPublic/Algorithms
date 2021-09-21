package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//제로
public class BJ10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K = Integer.parseInt(br.readLine());
		int index = 0;
		int[] arr = new int[100001];
		for(int i = 0; i < K; i++) {
			int c = Integer.parseInt(br.readLine());
			if(c == 0 && index > 0) {
				arr[--index] = 0;	// 그냥 --index 해도 된다.
			}else {
				arr[index++] = c;
			}
		}
		long result = 0;	//1 <= K <= 100,000,  0 <= c <= 1,000,000이므로 int형을 넘을 수 있다.
		for(int i = 0; i < index; i++) {	//index까지의 합.
			result += arr[i];
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
