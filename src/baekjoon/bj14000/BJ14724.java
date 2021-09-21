package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//관리자는 누구?
public class BJ14724 {
	static String[] clubNames = {"PROBRAIN", "GROW", "ARGOS", "ADMIN", "ANT", "MOTION", "SPG", "COMON", "ALMIGHTY"};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int captainClub = 0, maxInClubs = 0;	//동아리 관리자가 속한 동아리 번호, 동아리들 중 가장 많이 푼 문제 수
		
		for(int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int maxInClub = 0;	//동아리 내 가장 많이 푼 문제 수
			for(int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(maxInClub < num) {
					maxInClub = num;
				}
			}
			if(maxInClubs < maxInClub) {
				maxInClubs = maxInClub;
				captainClub = i;
			}
		}
		
		bw.write(clubNames[captainClub] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
