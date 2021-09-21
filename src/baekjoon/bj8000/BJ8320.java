package baekjoon.bj8000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//직사각형을 만드는 방법
public class BJ8320 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		for(int i = 1; i <= n; i++) {	//i개를 모두 사용하여 만들 수 있는 직사각형의 종류 수
			for(int j = 1; j * j <= i; j++) {	//a*b = i일때 직사각형이 가능. a*b = b*a는 같으므로 제외한다. (i의 제곱근까지만 검사하면 제외됨)
				if(i % j == 0) {
					count++;
				}
			}
		}
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
