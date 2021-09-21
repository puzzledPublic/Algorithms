package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//비트가 흘러넘쳐
public class BJ17419 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String binary = br.readLine();
		//K = K-(K&((~K)+1))연산은 맨 오른쪽 1인 비트를 0으로 만드는 연산.
		//펜윅트리에서 사용하는 sum할 때 사용하는 연산.
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(binary.charAt(i) == '1') {
				count++;
			}
		}
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
