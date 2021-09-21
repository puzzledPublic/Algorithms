package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//아기 석환 뚜루루 뚜루
public class BJ15947 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] strs = {" ", "baby", "sukhwan", "tururu", "turu", "very", "cute", "tururu", "turu", "in", "bed", "tururu", "turu", "baby", "sukhwan"};
		int N = Integer.parseInt(br.readLine());
		
		int k = N / 14;	//몇 번째 반복인지
		int i = (N - 1) % 14 + 1;	//해당 출력 위치
		if(i == 3 || i == 7 || i == 11) {	//tururu
			k += 2;
		}else if(i == 4 || i == 8 || i == 12) {	//turu
			k += 1;
		}else {	//그외
			k = -1;
			bw.write(strs[i] + "\n");
		}
		if(k != -1) {	//tu+ru인 경우
			if(k >= 5) {	//ru가 5 이상이면
				bw.write("tu+ru*" + k + "\n");
			}else {	//ru가 5 미만이면
				bw.write("tu");
				for(int j = 0; j < k; j++) {
					bw.write("ru");
				}
				bw.write("\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
