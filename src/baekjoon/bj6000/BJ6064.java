package baekjoon.bj6000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//카잉 달력
public class BJ6064 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), bw);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int m, int n, int x, int y, Writer w) throws IOException {
		if(x == y) {	//x와 y가 같은 경우 x번째 해가 된다. (x <= m이므로)
			w.write(x + "\n");
			return;
		}
		
		if(m > n) {	//m <= n이 되도록 바꾼다 (x, y도 마찬가지)
			int temp = m;
			m = n;
			n = temp;
			temp = x;
			x = y;
			y = temp;
		}
		int xx, yy = 1;
		if(x > y) {	//<x,y>(x <= y)가 <xx, 1>이 되도록 만든다. 여기서 xx는 x를 (y-1)만큼 감산해야한다.
			xx = x - (y - 1);
		}else {
			xx = m - ((y - 1 - x) % m); 
		}
		if(xx == 1) {	//xx = 1이면 <1, 1>부터 시작되어 <x,y>까지 왔다는 뜻이므로 y번째 해가 된다.
			w.write(y + "\n");
			return;
		}
		
		int i = 1, diff = n - m, count = 1;
		boolean flag = false;
		do {	//규칙을 찾아보면 <1, 1>부터 시작하여 <(i+(m-n))%m, 1>씩 주기를 가지고 결국 <1, 1>로 돌아온다.
			i = (i + diff) % m == 0 ? m: (i + diff) % m;
			if(i == xx) {	//구한 <xx,1>이 주기에 포함 된다면 카잉달력에 포함된다.
				flag = true;
				break;
			}
			count++;
		}while(i != 1);
		
		if(!flag) {	//카잉달력에 포함 안되므로  -1
			w.write(-1 + "\n");
		}else {	//카잉달력에 포함되면 (주기 횟수 * 주기 당 해의 횟수) + 구하는 y의 날짜
			int result = count * n + y;
			w.write(result + "\n");
		}
	}
}
