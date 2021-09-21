package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//5와 6의 차이
public class BJ2864 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String A = st.nextToken();
		String B = st.nextToken();
		
		int A5 = Integer.parseInt(A.replace('6', '5'));
		int A6 = Integer.parseInt(A.replace('5', '6'));
		int B5 = Integer.parseInt(B.replace('6', '5'));
		int B6 = Integer.parseInt(B.replace('5', '6'));
		
		bw.write((A5 + B5) + " " + (A6 + B6));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
