package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//태보태보 총난타
public class BJ17249 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] taebo = br.readLine().split("0");
		int[] afterImage = new int[2];
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < taebo[i].length(); j++) {
				if(taebo[i].charAt(j) == '@') {
					afterImage[i]++;
				}
			}
		}
		
		bw.write(afterImage[0] + " " + afterImage[1] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
