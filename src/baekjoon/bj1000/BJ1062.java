package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//가르침
public class BJ1062 {
	static int N, K, max;
	static String[] words;	//단어 리스트
	static boolean[] chk;	//dfs를 위한 체크 배열
	static Set<Character> list;	//배운 알파벳 리스트
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(K >= 5) {	//anta로 시작하고 tica로 끝나므로 'a', 'c', 'i', 'n', 't'는 무조건 알아야한다. 그러므로 K가 5개 미만이면 알 수 있는 단어 개수는 0개
			words = new String[N];
			chk = new boolean[26];
			chk[0] = chk[2] = chk[8] = chk[13] = chk[19] = true;
			list = new HashSet<>();
			list.add('a');
			list.add('c');
			list.add('i');
			list.add('n');
			list.add('t');
			for(int i = 0; i < N; i++) {
				words[i] = br.readLine();
			}
			solve(0, 0);
			
			bw.write(max + "\n");
		}else {
			bw.write("0\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int n, int next) {
		if(n == K - 5) {	//다 배웠으면 각 단어를 알 수 있는지 검사.
			int sum = 0;
			for(int i = 0; i < words.length; i++) {
				boolean educated = true;
				for(int j = 4; j < words[i].length() - 4; j++) {	//anta tica는 제외하고 검사
					if(!list.contains(words[i].charAt(j))) {
						educated = false;
						break;
					}
				}
				if(educated) {	//알 수 있으면 개수 증가.
					sum++;
				}
			}
			if(max < sum) {	//알 수 있는 단어 최대 개수 갱신
				max = sum;
			}
			return;
		}
		
		for(int i = next; i < 26; i++) {
			if(!chk[i]) {	//배운 알파벳 개수가 (K-5)개가 아직 안됐고 i번째 알파벳을 배우지 않았다면 배운다.
				chk[i] = true;
				list.add((char)(i + 97));
				solve(n + 1, i + 1);
				list.remove((char)(i + 97));	//백트래킹.
				chk[i] = false;
			}
		}
	}
}
