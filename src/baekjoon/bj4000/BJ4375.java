package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//1
public class BJ4375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str;
		while((str = br.readLine()) != null) {
			int N = Integer.parseInt(str);
			int count = 1;
			int Q = 1;
			while(Q % N != 0) {	//나눠 떨어질때까지 1을 붙여나간다.
				Q = (Q % N) * 10 + 1;
				count++;
			}
			bw.write(count + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
