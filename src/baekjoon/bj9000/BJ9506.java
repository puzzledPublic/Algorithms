package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

//약수들의 합
public class BJ9506 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == -1) break;
			
			List<Integer> list = new ArrayList<>();
			int sum = 0;
			for(int i = 1; i * i <= N; i++) {
				if(N % i == 0) {
					list.add(i);
					list.add(N / i);
					sum += (i + (N / i));
				}
			}
			
			sum -= N;
			list.sort((a, b) -> a - b);
			
			if(sum != N) {
				bw.write(N + " is NOT perfect.\n");
			}else {
				bw.write(N + " = ");
				for(int i = 0; i < list.size() - 2; i++) {
					bw.write(list.get(i) + " + ");
				}
				bw.write(list.get(list.size() - 2) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
