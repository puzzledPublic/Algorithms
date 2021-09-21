package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//개미
public class BJ10158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		
		//x방향과 y방향을 따로 나눠 생각한다.
		//x는 w * 2초, y는 h * 2초가 지나면 원래 위치로 돌아오므로 시간을 줄인다.
		//그러면 최대 moveX < w * 2, moveY < h * 2초 내로만 움직이면 된다.
		int moveX = t % (w * 2), moveY = t % (h * 2);	
		
		//x에서 x축으로 moveX만큼 움직였을때
		int resultX = moveX + x;	
		if(resultX > w) {	//w를 넘는다면 반대 방향으로 돌아야한다.
			//이때 위치를 잘 보면 규칙을 찾을 수 있다. (개미 움직임은 0, 1, 2 ... w, w-1, w-2 ... 0, 1, 2...이 되고 (오르락내리락))
			//x에 moveX를 더하여 개미 움직임에 대응하면             0, 1, 2, ... w, w+1, w+2 ... w+w, w+w+1, w+w+2...이 된다.
			if(resultX <= w * 2) {
				resultX = (moveX + x) - ((moveX + x) - w) * 2;
			}else {
				resultX -= w * 2;
			}
		}
		//y에서 y축으로 moveY만큼 움직였을때
		int resultY = moveY + y;
		if(resultY > h) {	//h를 넘는다면 반대 방향으로 돌아야한다.
			if(resultY <= h * 2) {
				resultY = (moveY + y) - ((moveY + y) - h) * 2;
			}else {
				resultY -= h * 2;
			}
		}
		
		bw.write(resultX + " " + resultY + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
