package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//집합
public class BJ11723 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Set<Integer> set = new HashSet<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String op = st.nextToken();
			int x = 0;
			if(st.hasMoreTokens()) {
				x = Integer.parseInt(st.nextToken());
			}
			switch(op) {
			case "add":
				set.add(x);
				break;
			case "remove":
				set.remove((Integer)x);
				break;
			case "check":
				if(set.contains((Integer)x)) {
					bw.write("1\n");
				}else{
					bw.write("0\n");
				}
				break;
			case "toggle":
				if(set.contains((Integer)x)) {
					set.remove((Integer)x);
				}else {
					set.add(x);
				}
				break;
			case "all":
				for(int j = 0; j < 21; j++) {
					set.add(j);
				}
				break;
			case "empty":
				set.clear();
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
