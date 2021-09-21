package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//배스킨라빈스 31
public class BJ14429 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine().trim());
		int min = Integer.MAX_VALUE;
		int num = -1, len = -1;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int j = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int r = (j - 1) % (m + 1);
			int count = 0;
			while(r < j) {
				r += (m + 1);
				count++;
			}
			if(min > count) {
				num = i + 1;
				min = len = count;
			}
		}
		
		bw.write(num + " " + (len + len) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
