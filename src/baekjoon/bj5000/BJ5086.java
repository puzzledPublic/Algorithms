package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//배수와 약수
public class BJ5086 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			if(first == 0 && second == 0) {
				break;
			}
			
			if(first <= second) {
				if(second % first == 0) {
					bw.write("factor\n");
				}else {
					bw.write("neither\n");
				}
			}else {
				if(first % second == 0) {
					bw.write("multiple\n");
				}else {
					bw.write("neither\n");
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
