package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//지그재그 숫자
public class SWEA1986 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			for(int j = 1; j <= N; j++) {
				sum += (j % 2 == 0 ? -j : j);
			}
			bw.write("#" + i + " " + sum + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
