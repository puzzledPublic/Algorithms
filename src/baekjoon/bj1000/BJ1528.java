package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//금민수의 합
public class BJ1528 {
	static int N, Len;
	static List<List<Integer>> list = new ArrayList<>();	//list.get(i) => 4와 7로 이루어진 i자리 수
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		Len = (int)Math.log10((double)N) + 1;
		
		for(int i = 0; i < Len + 1; i++) {
			list.add(new ArrayList<>());
		}
		
		makeNum(0);
		
		dp = new int[N <= 7 ? 10 : N + 1];	//dp[i] = 4와 7로 이루어진 수들의 합으로 i를 만들 때 수들의 최소 개수.
		Arrays.fill(dp, 1000000);
		dp[4] = dp[7] = 1;	//4와 7은 1개.
		dp[0] = 0;
		for(int i = 8; i <= N; i++) {
			int len = (int)Math.log10((double)i) + 1;	//해당 자리수 이하의 수들만 탐색.
			for(int j = 1; j <= len; j++) {
				for(int k = 0; k < list.get(j).size(); k++) {
					if(i - list.get(j).get(k) >= 0 && dp[i - list.get(j).get(k)] != 1000000) {
						dp[i] = Math.min(dp[i], dp[i - list.get(j).get(k)] + 1);
					}
				}
			}
		}
		
		List<Integer> result = new ArrayList<>();
		
		//N부터 거꾸로 돌며 수들을 복원.
		int p = N;
		while(dp[p] != 0) {
			int c = Integer.MAX_VALUE;
			int index = p; 
			int num = 0;
			//사전 순으로 앞서는 것이 필요하므로 큰 자리 수 부터 탐색하며 갱신한다.
			for(int i = Len; i > 0; i--) {
				for(int j = list.get(i).size() - 1; j >= 0 ; j--) {
					if(p - list.get(i).get(j) >= 0 && dp[p - list.get(i).get(j)] != 1000000) {
						if(dp[p] - 1 == dp[p - list.get(i).get(j)]) {	//이전 개수 바로 아래라면 갱신.				
							c = dp[p - list.get(i).get(j)];
							index = p - list.get(i).get(j);
							num = list.get(i).get(j);
						}
					}
				}
			}
			if(index == p) {	//더이상 탐색이 안되는 경우 4와 7로 이루어진 수의 합으로 표현이 안된다.
				result.clear();
				break;
			}
			result.add(num);
			p = index;
		}
		
		if(result.isEmpty()) {
			bw.write("-1\n");
		}else {
			result.sort(Integer::compare);
			for(int i = 0; i < result.size(); i++) {
				bw.write(result.get(i) + " ");
			}
			bw.write("\n");
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	//4와 7로 만들 수 있는 모든 수를 만든다.
	static void makeNum(int s) {
		int len = (int)Math.log10((double)s) + 1;
		if(s != 0) {
			list.get(len).add(s);
		}
		if(len == Len) {
			return;
		}
		makeNum(s * 10 + 4);
		makeNum(s * 10 + 7);
	}
}
