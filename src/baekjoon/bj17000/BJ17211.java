package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//좋은 날 싫은 날
public class BJ17211 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		char feel = st.nextToken().charAt(0);
		double[][] days = new double[N + 1][2];	//days[i][j] = i번째날에 기분(j)이 좋을 확률(0), 나쁠 확률(1)
		
		st = new StringTokenizer(br.readLine(), " ");
		double GoodToGood = Double.parseDouble(st.nextToken());	//좋은날 -> 좋은날
		double GoodToBad = Double.parseDouble(st.nextToken());	//좋은날 -> 구린날
		double BadToGood = Double.parseDouble(st.nextToken()); 	//구린날 -> 좋은날
		double BadToBad = Double.parseDouble(st.nextToken());	//구린날 -> 구린날
		
		if(feel == '0') {	//현재 기분이 좋을때
			days[0][0] = 1;
		}else {
			days[0][1] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			days[i][0] = days[i - 1][0] * GoodToGood + days[i - 1][1] * BadToGood;	//i번째 날에 기분이 좋으려면 전날 기분이 좋고 오늘 기분이 좋을 확률 + 전날 기분이 나쁘고 오늘 기분이 좋을 확률
			days[i][1] = days[i - 1][0] * GoodToBad + days[i - 1][1] * BadToBad;	//i번째 날에 기분이 나쁘려면 전날 기분이 좋고 오늘 기분이 나쁠 확률 + 전날 기분이 나쁘고 오늘 기분이 나쁠 확률
		}
		
		bw.write((int)(days[N][0] * 1000 + 0.5) + "\n" + (int)(days[N][1] * 1000 + 0.5) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
