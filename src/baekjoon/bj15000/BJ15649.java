package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//N과 M(1)	nCm
public class BJ15649 {
	static int N, M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		boolean[] chk = new boolean[N + 1];
		List<Integer> list = new ArrayList<>();
		solve(list, chk, 0, bw);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(List<Integer> list, boolean[] chk, int m, Writer w) throws IOException {
		if(m == M) {
			for(int i = 0; i < list.size(); i++) {
				w.write(list.get(i) + " ");
			}
			w.write('\n');
			return;
		}
		for(int i = 1; i < N + 1; i++) {
			if(!chk[i]) {
				chk[i] = true;
				list.add(i);
				solve(list, chk, m + 1, w);
				list.remove(list.size() - 1);
				chk[i] = false;
			}
		}
	}
	static void solve2(int[] ans, boolean[] chk, int m, Writer w) throws IOException {
		if(m == M) {
			for(int i = 0; i < ans.length; i++) {
				w.write(ans[i] + " ");
			}
			w.write('\n');
			return;
		}
		for(int i = 1; i < N + 1; i++) {
			ans[m] = i;		//list를 백트래킹 할 필요 없이 덮어씌워 성능향상
			if(!chk[i]) {
				chk[i] = true;
				solve2(ans, chk, m + 1, w);
				chk[i] = false;
			}
		}
	}
}
