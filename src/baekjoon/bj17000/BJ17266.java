package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//어두운 굴다리
public class BJ17266 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] light = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			light[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 1, end = N + 1;
		
		while(start < end) {
			int mid = (start + end) / 2;
			int s = 0;
			for(int i = 0; i < light.length; i++) {
				if(s >= light[i] - mid) {
					s = light[i] + mid;
				}else {
					break;
				}
			}
			if(s >= N) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		
		bw.write(start + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
