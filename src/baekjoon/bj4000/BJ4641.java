package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//Doubles
public class BJ4641 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			if(st.countTokens() == 1) {
				break;
			}
			Set<Integer> set = new HashSet<>();
			int a, count = 0;
			while((a = Integer.parseInt(st.nextToken())) != 0) {
				set.add(a);
			}
			for(Integer i : set) {
				if(set.contains(i * 2)) {
					count++;
				}
			}
			bw.write(count + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
