package baekjoon.bj19000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//가뭄
public class BJ19572 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int d1 = Integer.parseInt(st.nextToken());
		int d2 = Integer.parseInt(st.nextToken());
		int d3 = Integer.parseInt(st.nextToken());
		
		//d1 = a + b, d2 = a + c, d3 = b + c; 
		double a = (d1 + d2 - d3);
		double b = (d1 - d2 + d3);
		double c = (-d1 + d2 + d3);
		
		if(a <= 0 || b <= 0 || c <= 0) {
			bw.write("-1\n");
		}else {
			bw.write("1\n");
			bw.write((a / 2.0) + " " + (b / 2.0) + " " + (c / 2.0) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
