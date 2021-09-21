package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//FBI
public class BJ2857 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean exist = false;
		for(int i = 1; i <= 5; i++) {
			if(br.readLine().indexOf("FBI") != -1) {
				exist = true;
				bw.write(i + " ");
			}
		}
		if(!exist) {
			bw.write("HE GOT AWAY!\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
