package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//초심자의 회문 검사
public class SWEA1989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			String str = br.readLine().trim();
			boolean chk = false;
			int s = 0, e = str.length() - 1;
			while(s < e) {
				if(str.charAt(s) != str.charAt(e)) {
					chk = true;
				}
				s++;
				e--;
			}
			if(chk) {
				bw.write("#" + i + " 0\n");
			}else{
				bw.write("#" + i + " 1\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
