package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//DNA
public class BJ1969 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] DNAs = new String[N];
		for(int i = 0; i < N; i++) {
			DNAs[i] = br.readLine();
		}
		int diff= 0;
		for(int i = 0; i < M; i++) {	
			int[][] dna = {{0, 'A'}, {0, 'C'}, {0, 'G'}, {0, 'T'}};
			for(int j = 0; j < N; j++) {	//j번째 DNA 문자열의 i번째 문자에따라 개수를 센다.
				switch(DNAs[j].charAt(i)) {
				case 'A':
					dna[0][0]++;
					break;
				case 'C':
					dna[1][0]++;
					break;
				case 'G':
					dna[2][0]++;
					break;
				default:
					dna[3][0]++;
				}
			}
			//가장 많은 뉴클레오티드를 쓰는게 헤밍거리가 짧아진다. (그리디)
			Arrays.sort(dna, (a, b) -> b[0] - a[0]);
			bw.write((char)dna[0][1]);
			diff += (dna[1][0] + dna[2][0] + dna[3][0]);
		}
		bw.write("\n" + diff + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
