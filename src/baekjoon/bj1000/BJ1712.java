package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//손익분기점
public class BJ1712 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		double A = Double.parseDouble(st.nextToken());
		double B = Double.parseDouble(st.nextToken());
		double C = Double.parseDouble(st.nextToken());
		
		//A + Bx < Cx라는 식이 성립하고. x에 관하여 풀면 A / (C - B) < x가 된다.
		if(B >= C) {
			bw.write("-1\n");
		}else {
			bw.write((int)((A / (C - B) + 1)) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
