package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//삼각 김밥
public class BJ2783 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		double price = Integer.parseInt(st.nextToken()), gram = Integer.parseInt(st.nextToken());
		double base = price / gram;	//가장 낮은 가격/그램의 비율
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double p = Integer.parseInt(st.nextToken()), g = Integer.parseInt(st.nextToken());
			if(base > (p / g)) {
				base = (p / g);
				price = p;
				gram = g;
			}
		}
		double result = (price * 1000) / (gram);	//1000그램을 구매하기 위한 가격	(price : gram = result : 1000)
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
