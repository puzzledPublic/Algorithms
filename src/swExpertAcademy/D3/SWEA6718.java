package swExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//희성이의 원근법
public class SWEA6718 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int d = Integer.parseInt(br.readLine());
			bw.write("#" + t + " ");
			if(d < 100) {
				bw.write("0\n");
			}else if(100 <= d && d < 1000) {
				bw.write("1\n");
			}else if(1000 <= d && d < 10000) {
				bw.write("2\n");
			}else if(10000 <= d && d < 100000) {
				bw.write("3\n");
			}else if(100000 <= d && d < 1000000) {
				bw.write("4\n");
			}else {
				bw.write("5\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
