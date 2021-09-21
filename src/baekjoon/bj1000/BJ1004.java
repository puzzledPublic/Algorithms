package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//어린 왕자
public class BJ1004 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int sx, sy, dx, dy, sn, dn, N, x, y ,r;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			dx = Integer.parseInt(st.nextToken());
			dy = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(br.readLine());
			sn = 0;
			dn = 0;
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());
				boolean c1 = isInside(sx, sy, x, y, r);
				boolean c2 = isInside(dx, dy, x, y, r);
				if(c1 && c2) {	//좌표와 반지름이 주어졌을때 원을 구하고 시작점과 도착점이 그 원 안에 있다면 벗어나거나 들어갈 필요가 없다.
					continue;
				}else if(c1 && !c2) {	//시작점만 원 안에 있다면 한번은 들어가거나 벗어난다.
					sn++;
				}else if(!c1 && c2) {	//도착점만 원 안에 있다면 한번은 들어가거나 벗어난다.
					dn++;
				}
			}
			bw.write((sn + dn) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean isInside(int x, int y, int ix, int iy, int r) {
		return (ix - x) *(ix - x) + (iy - y) * (iy - y) <= r * r;
	}
}
