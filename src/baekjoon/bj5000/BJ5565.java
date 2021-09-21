package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//영수증
public class BJ5565 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int total = Integer.parseInt(br.readLine()), others = 0;
		for(int i = 0; i < 9; i++) {
			others += Integer.parseInt(br.readLine());
		}
		bw.write((total - others) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
