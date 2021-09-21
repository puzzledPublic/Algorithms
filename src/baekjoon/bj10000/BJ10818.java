package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//최소, 최대
public class BJ10818 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int t, min = 1000001, max = -10000001;
		for(int i = 0; i < N; i++) {
			t = Integer.parseInt(st.nextToken());
			if(t < min) {
				min = t;
			}
			if(t > max) {
				max = t;
			}
		}
		bw.write(min + " " + max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
