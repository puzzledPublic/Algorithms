package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//Vending Machine
public class BJ17284 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] money = {0, 500, 800, 1000};
		int sum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		while(st.hasMoreTokens()) {
			sum += money[Integer.parseInt(st.nextToken())];
		}
		
		bw.write((5000 - sum) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
