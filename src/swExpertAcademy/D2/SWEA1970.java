package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//쉬운 거스름돈
public class SWEA1970 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			int[] count = new int[8];
			int N = Integer.parseInt(br.readLine());
			int k = 0;
			while(k < 8) {
				if(N >= money[k]) {
					count[k] = N / money[k];
					N %= money[k];
				}
				k++;
			}
			
			bw.write("#" + i + "\n");
			for(int j = 0; j < money.length - 1; j++) {
				bw.write(count[j] + " ");
			}
			bw.write(count[7] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
