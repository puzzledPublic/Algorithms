package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2진수 8진수
public class BJ1373 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String binary = br.readLine();
		
		int beginIndex = 0;
		int endIndex = binary.length() % 3 == 0 ? 3 : binary.length() % 3;	//자르기 시작할 위치.
		
		while(endIndex <= binary.length()) {
			//3자리씩 잘라 8진수로 변환.
			bw.write(Integer.toOctalString(Integer.parseInt(binary.substring(beginIndex, endIndex), 2)));
			beginIndex = endIndex;
			endIndex += 3;
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
