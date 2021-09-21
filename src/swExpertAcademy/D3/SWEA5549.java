package swExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//홀수일까 짝수일까
public class SWEA5549 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			String str = br.readLine();
			bw.write("#" + i + " ");
			if((str.charAt(str.length() - 1) - '0') % 2 == 0) {
				bw.write("Even\n");
			}else {
				bw.write("Odd\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
