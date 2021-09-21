package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//단어의 개수	//앞, 뒤 공백이 들어오는 경우, 공백만 들어오는 경우를 조심하라.
public class BJ1152 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine().trim();
		if(s.isEmpty()) {
			bw.write(0 + "\n");
		}else {
			bw.write(s.split(" ").length + "\n");
		}
		bw.close();
		br.close();
	}
}
