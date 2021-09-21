package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//욱제는 결정장애야!!
public class BJ14646 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[2 * N];
		boolean[] check = new boolean[N + 1];
		for(int i = 0; i < 2 * N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = -1;
		int count = 0;
		for(int i = 0; i < 2 * N; i++) {
			if(!check[arr[i]]) {	//스티커 안붙었으면
				count++;	//스티커 붙은 메뉴 +1
				check[arr[i]] = true;	//스티커 붙이기
			}else {	//스티커 붙어있으면
				count--;	//메뉴 제거
			}
			max = Math.max(max, count);
		}
		
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
