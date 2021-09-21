package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//주사위
public class BJ1041 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long N = Long.parseLong(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int F = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		list.add(A);
		list.add(B);
		list.add(C);
		list.add(D);
		list.add(E);
		list.add(F);
		list.sort((a, b) -> a - b);
		long d1 = list.get(0);	//제일 낮은 수
		long d4 = list.stream().limit(5).reduce((a, b) -> a + b).get();	//4면의 수들의 최소 합.
		list.clear();
		list.add(A + B + C);
		list.add(A + B + D);
		list.add(A + C + E);
		list.add(A + D + E);
		list.add(B + C + F);
		list.add(B + D + F);
		list.add(C + E + F);
		list.add(D + E + F);
		list.sort((a, b) -> a - b);
		long d3 = list.get(0);	//3면의 수들의 최소합.
		list.clear();
		list.add(A + B);
		list.add(A + C);
		list.add(A + E);
		list.add(A + D);
		list.add(B + C);
		list.add(B + D);
		list.add(B + F);
		list.add(C + E);
		list.add(C + F);
		list.add(D + E);
		list.add(D + F);
		list.add(E + F);
		list.sort((a, b) -> a - b);
		long d2 = list.get(0);	//2면의 수들의 최소합.
		
		if(N == 1) {
			bw.write(d4 + "\n");
		}else {
			bw.write( (d3 * 4L) //3면인 경우는 4개.
					+ d2 * (4L * (N - 1) + 4L * (N - 2)) //2면이 있는 경우는 4(N-1) + 4(N-2)개
					+ d1 * (4L * (N - 1) * (N - 2) + (N - 2) * (N - 2)) + "\n");	//1면이 있는 경우는 4(N-1)(N-2)+(N-2)(N-2)개
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
