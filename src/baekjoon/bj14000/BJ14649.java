package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//문홍안
public class BJ14649 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[101];
		
		int P = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int stone = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			if(dir == 'R') {	//오른쪽으로 이동
				while(stone < 100) arr[++stone]++;
			}else {	//왼쪽으로 이동
				while(stone > 1) arr[--stone]++;
			}
		}
		
		int[] count = new int[3];
		for(int i = 1; i <= 100; i++) {	//count index => 0=blue, 1=red, 2=green 
			count[arr[i] % 3]++;
		}
		
		for(int i = 0; i < 3; i++) {
			bw.write(String.format("%.2f\n", ((count[i] / 100.0D) * (double)P)));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
