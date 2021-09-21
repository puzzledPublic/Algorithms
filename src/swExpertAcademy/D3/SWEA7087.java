package swExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//문제 제목 붙이기
public class SWEA7087 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			boolean[] alpha = new boolean[27];
			int N = Integer.parseInt(br.readLine());
			for(int j = 0; j < N; j++) {
				alpha[br.readLine().trim().charAt(0) - 'A'] = true;
			}
			int count = 0;
			for(int j = 0; j < 27; j++) {	//A~Z까지 있다면 27까지 둬서 끝까지 셀 수 있게끔 해야함..
				if(!alpha[j]) {
					bw.write("#" + i + " " + count + "\n");
					break;
				}
				count++;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
