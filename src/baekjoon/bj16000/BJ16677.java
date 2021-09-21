package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//악마 게임
public class BJ16677 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String word = br.readLine();
		int N = Integer.parseInt(br.readLine());
		String[] strs = new String[N];
		double[] value = new double[N];
		int[][] alpha = new int[N][26];
		int[] wordAlpha = new int[26];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			strs[i] = st.nextToken();
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < word.length(); i++) {
			wordAlpha[word.charAt(i) - 'A']++;
		}
		double max = 0;
		int index = -1;
		for(int i = 0; i < strs.length; i++) {
			for(int j = 0; j < strs[i].length(); j++) {
				alpha[i][strs[i].charAt(j) - 'A']++;
			}
			int excep = 0;
			boolean flag = false;
			for(int j = 0; j < 26; j++) {
				if(wordAlpha[j] > alpha[i][j]) {
					flag = true;
					break;
				}
				excep += (alpha[i][j] - wordAlpha[j]);
			}
			
			if(!flag) {
				if(max < (value[i] / excep)) {
					max = (value[i] / excep);
					index = i;
				}
			}
		}
		if(index != -1) {
			bw.write(strs[index] + "\n");
		}else {
			bw.write("No Jam\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
