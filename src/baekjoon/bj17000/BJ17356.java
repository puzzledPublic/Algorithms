package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//욱 제
public class BJ17356 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		double A = Integer.parseInt(st.nextToken());
		double B = Integer.parseInt(st.nextToken());
		
		double result = 1d / (1d + Math.pow(10, (B - A) / 400));
		
		
		System.out.printf("%f\n", result);
		
		bw.flush();
		bw.close();
		br.close();
	}
}
