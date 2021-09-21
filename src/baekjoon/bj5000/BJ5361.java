package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//전투 드로이드 가격
public class BJ5361 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		double[] price = {350.34, 230.90, 190.55, 125.30, 180.90};
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			double result = 0;
			for(int i = 0; i < 5; i++) {
				result += (Double.parseDouble(st.nextToken()) * price[i]);
			}
			System.out.printf("$%.2f\n", result);
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
