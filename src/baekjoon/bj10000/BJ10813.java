package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//공 바꾸기
public class BJ10813 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[] box = new int[N + 1];
		for(int i = 1; i < N + 1; i++) {	//1~N까지 채운다.
			box[i] = i;
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			int t = box[a];	//a박스와 b박스를 교환
			box[a] = box[b];
			box[b] = t;
		}
		for(int i = 1; i < N + 1; i++) {	//출력
			bw.write(box[i] + " ");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
