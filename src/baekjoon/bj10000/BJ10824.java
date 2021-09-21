package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//네 수
public class BJ10824 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String s1 = st.nextToken() + st.nextToken();
		String s2 = st.nextToken() + st.nextToken();
		
		bw.write((Long.parseLong(s1) + Long.parseLong(s2)) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
