package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//반올림
public class BJ2033 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int A = 10;
		
		while(N >= A) {	//A보다 큰 경우
			int B = A / 10;
			int num = (N % A) / B;	// (A/10)의 자리에서 반올림 할 숫자
			if(num >= 5) {	//반올림해야 하면 반올림 한다.
				N += A;
			}
			N -= B * num;	//(A/10)의 자리는 0으로
			A *= 10;	//다음 A
		}
		
		bw.write(N + "\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
