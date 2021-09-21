package baekjoon.bj12000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//Starman
public class BJ12791 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int Q = Integer.parseInt(br.readLine());
		int[] years = {1967, 1969, 1970, 1971, 1972, 1973, 1973, 1974, 1975, 1976, 1977, 1977, 1979, 1980, 1983, 1984, 1987, 1993, 1995, 1997, 1999, 2002, 2003, 2013, 2016};
		String[] albums = {"DavidBowie","SpaceOddity","TheManWhoSoldTheWorld","HunkyDory","TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars","AladdinSane"
				,"PinUps","DiamondDogs","YoungAmericans","StationToStation","Low","Heroes","Lodger","ScaryMonstersAndSuperCreeps","LetsDance","Tonight","NeverLetMeDown"
				,"BlackTieWhiteNoise","1.Outside","Earthling","Hours","Heathen","Reality","TheNextDay","BlackStar"};
		for(int i = 0; i < Q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
			int ss = 0, ee = albums.length - 1;
			if(e < 1967) {	//끝 년도가 1967 미만이면 출력할게 없다.
				bw.write("0\n");
				continue;
			}
			while(s > years[ss]) {	//시작 년도 탐색
				ss++;
			}
			while(e < years[ee]) {	//끝 년도 탐색
				ee--;
			}
			if(ee - ss >= 0) {
				bw.write((ee - ss + 1) + "\n");
				for(int j = ss; j <= ee; j++) {
					bw.write(years[j] + " " + albums[j] + "\n");
				}
			}else {	//해당 년도 안에 앨범이 없는 경우
				bw.write("0\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
