package baekjoon.bj7000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//회사에 있는 사람
public class BJ7785 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			if(s[1].equals("enter")) {
				set.add(s[0]);
			}else {
				set.remove(s[0]);
			}
		}
		String[] result = set.toArray(new String[set.size()]);
		Arrays.sort(result, (a, b) -> -a.compareTo(b));
		for(int i = 0; i < result.length; i++) {
			bw.write(result[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
