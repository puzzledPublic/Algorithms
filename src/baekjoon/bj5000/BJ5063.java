package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//TGN
public class BJ5063 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()), r, e, c;
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if(r > e - c) {
				bw.write("do not advertise\n");
			}else if(r < e - c) {
				bw.write("advertise\n");
			}else {
				bw.write("does not matter\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
