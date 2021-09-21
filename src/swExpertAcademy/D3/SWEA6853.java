package swExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//직사각형과 점
public class SWEA6853 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(br.readLine());
			int c1 = 0, c2 = 0, c3 = 0;
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
				
				if((x1 < x && x < x2) && (y1 < y && y < y2)) {	//완전히 포함하는 경우
					c1++;
				}else if((x1 > x || x > x2) || (y1 > y || y > y2)) {	//경계에도 들어가지 않는 경우
					c3++;
				}else {	//경계에 있는 경우
					c2++;
				}
			}
			
			bw.write("#" + i + " " + c1 + " " + c2 + " " + c3 + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
