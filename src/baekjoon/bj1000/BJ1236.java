package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//성 지키기
public class BJ1236 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] row = new boolean[N];
		boolean[] col = new boolean[M];
		for(int i = 0; i < N; i++) {
			char[] chs = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				if(chs[j] == 'X') {
					row[i] = col[j] = true;
				}
			}
		}
		
		int r = 0;
		for(int i = 0; i < N; i++) {
			if(!row[i]) r++;
		}
		
		int c = 0;
		for(int i = 0; i < M; i++) {
			if(!col[i]) c++;
		}
		
		bw.write((r < c ? c : r) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
