package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//새로운 불면증 치료법
public class SWEA1288 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			boolean[] chk = new boolean[10];	//체크된 숫자 배열
			int count = 0, c = 1;
			int n = Integer.parseInt(br.readLine());
			while(true) {
				if(count >= 10) {	//10개 모두 체크 됐으면 출력
					bw.write("#" + i + " " + (n * (c - 1)) + "\n");
					break;
				}
				int t = n * c;
				while(t > 0) {	//숫자 체크
					if(!chk[t % 10]) {
						chk[t % 10] = true;
						count++;
					}
					t /= 10;
				}
				c++;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
