package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//승부 예측
public class BJ15997 {
	static class Game {
		int A, B;
		double W, D, L;
		Game(int A, int B, double W, double D, double L) {
			this.A = A;
			this.B = B;
			this.W = W;
			this.D = D;
			this.L = L;
		}
	}
	static class Info{
		int first, second;
		Info(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	static Info[] infos;
	static Map<String, Integer> m;
	static Game[] games;
	static int[] s;
	static double[] r;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		m = new HashMap<>();
		games = new Game[6];
		s = new int[4];
		r = new double[4];
		
		for(int i = 0; i < 4; i++) {
			m.put(st.nextToken(), i);
		}
		
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String A = st.nextToken(), B = st.nextToken();
			games[i] = new Game(m.get(A), m.get(B), Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		}
		
		infos = new Info[4];
		for(int i = 0; i < 4; i++) {
			infos[i] = new Info(i, 0);
		}
		
		solve(0, (double)1.0);
		
		for(int i = 0; i < 4; i++) {
			bw.write(r[i] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
		
	}
	static void solve(int n, double p) {
		if(n == 6) {	//6번의 경기를 마치고.
			for(int i = 0; i < 4; i++) {	//각 팀 점수와 인덱스를 가지고
				infos[i].first= s[i];
				infos[i].second = i;
			}
			Arrays.sort(infos, (a, b) -> a.first - b.first);	//정렬
			int A = infos[0].first, B = infos[1].first, C = infos[2].first, D = infos[3].first;
			int a = infos[0].second, b = infos[1].second, c = infos[2].second, d = infos[3].second;
			if (B != C) {	//B팀과 C팀의 점수가 다르면
				r[c] += p; r[d] += p;	//C와 D가 올라갈 확률.
			} else if (A == B && C == D) {	//A = B = C = D 인 경우
				r[a] += p/2.0; r[b] += p/2.0;	//4팀 중 2팀을 추첨을 하므로 확률은 1/2 줄어든다.
				r[c] += p/2.0; r[d] += p/2.0;
			} else if (A == B) {	//A = B = C인 경우
				r[a] += p/3.0; r[b] += p/3.0;	//D는 진출하고 3팀 중 1팀을 추첨하므로 확률은 1/3 줄어든다.
				r[c] += p/3.0; r[d] += p;
			} else if (C == D) {	//B = C = D인 경우
				r[b] += p*2.0/3.0; r[c] += p*2.0/3.0;	//3팀 중 2팀을 추첨하므로 확률은 2/3 줄어든다.
				r[d] += p*2.0/3.0;
			} else {	//B == C인 경우
				r[b] += p/2.0; r[c] += p/2.0;	//D는 진출하고 2팀 중 1팀을 추첨하므로 확률은 1/2 줄어든다.
				r[d] += p;
			}
			return;
		}
		int x = games[n].A, y = games[n].B;

		s[x] += 3;
		solve(n+1, p*games[n].W);
		s[x] -= 3;

		s[x] += 1; s[y] += 1;
		solve(n+1, p*games[n].D);
		s[x] -= 1; s[y] -= 1;

		s[y] += 3;
		solve(n+1, p*games[n].L);
		s[y] -= 3;
	}
}
