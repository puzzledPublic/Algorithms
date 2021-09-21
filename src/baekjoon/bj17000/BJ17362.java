package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//수학은 체육과목 입니다 2
public class BJ17362 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int r = N % 8;
		int result = -1;
		//1 2 3 4 5 6 7 8 9 10 11...
		//1 2 3 4 5 4 3 2 1  2  3...
		if(r == 1) {
			result = 1;
		}else if(r == 0 || r == 2) {
			result = 2;
		}else if(r == 3 || r == 7) {
			result = 3;
		}else if(r == 4 || r == 6) {
			result = 4;
		}else {
			result = 5;
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
