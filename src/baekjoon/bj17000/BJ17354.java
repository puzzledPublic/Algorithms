package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//DVD
public class BJ17354 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int ys = Integer.parseInt(st.nextToken());
		int xs = Integer.parseInt(st.nextToken());
		
		long d1 = H - h;
		long d2 = W - w;
		
		long a1 = xs < 0 ? x : d1 - x;
		long a2 = ys < 0 ? y : d2 - y;
		
		//a1 + (x - 1) * d1, a2 + (y - 1) * d2
		
		boolean can = false;
		int i;
		for(i = 1; i <= d2; i++) {
			if((d1 * (i - 1) + d2 + a1 - a2) % d2 == 0) {
				can = true;
				break;
			}
		}
		bw.write((can ? (d1 * (i - 1) + a1) : -1) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
