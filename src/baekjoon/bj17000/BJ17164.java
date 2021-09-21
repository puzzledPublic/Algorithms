package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Rainbow Beads
public class BJ17164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String beads = br.readLine();
		int maxLength = 1;
		int count = 1;
		for(int i = 0; i < beads.length(); i++) {
			if(i + 1 < beads.length() && (beads.charAt(i + 1) == beads.charAt(i) || beads.charAt(i + 1) == 'V' || beads.charAt(i) == 'V')) {
				if(maxLength < count) {
					maxLength = count;
				}
				count = 1;
			}else {
				count++;
			}
		}
		if(maxLength < count - 1) {
			maxLength = count - 1;
		}
		bw.write(maxLength + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
