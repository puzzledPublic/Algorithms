package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//쉽게 푸는 문제
public class BJ1292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[1001];
		int i = 1, n = 1;
		while(i < 1001) {	//1000까지므로 수열을 직접 만든다.
			for(int j = 0; j < n && i < 1001; j++) {
				arr[i++] = n;
			}
			n++;
		}
		
		int sum = 0;		//A ~ B 구간의 합을 구한다.
		for(int j = A; j <= B; j++) {
			sum += arr[j];
		}
		
		bw.write(sum + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
