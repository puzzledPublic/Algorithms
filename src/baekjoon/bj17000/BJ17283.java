package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//I am Groot
public class BJ17283 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		double L = Integer.parseInt(br.readLine());
		double R = Integer.parseInt(br.readLine());
		
		int level = 1;
		int sum = 0;
		while((int)(L * (R / 100)) > 5) {
			level *= 2;
			sum += level * (int)(L * (R / 100));
			L = L * (R / 100);
			L = (int)L;
		}
		
		bw.write(sum + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
