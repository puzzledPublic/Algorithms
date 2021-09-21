package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//간단한 소인수분해
public class SWEA1945 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] num = {2, 3, 5, 7, 11};
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			bw.write("#" + i + " ");
			for(int j = 0; j < num.length; j++) {
				int count = 0;
				while(N % num[j] == 0) {
					count++;
					N /= num[j];
				}
				bw.write(count + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
