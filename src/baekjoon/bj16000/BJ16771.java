package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//Back and Forth
//월 10 -> 10, 화 9 <- 11, 수 10 -> 10, 목 9 <- 11, 금 10 -> 10
//10 x 11 x 10 x 11 x 10 = 121000이므로 완전탐색으로 풀 수 있다.
public class BJ16771 {
	static boolean[] milkTank = new boolean[2001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		List<Integer>[] barn = new List[2];
		for(int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			barn[i] = new ArrayList<>();
			for(int j = 0; j < 10; j++) {
				barn[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		solve(1, 1000, barn[0], barn[1]);
		
		int count = 0;
		for(int i = 0; i <= 2000; i++) {
			if(milkTank[i]) {
				count++;
			}
		}
		
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	//1 - tue, 2 - wed, 3 - thu, 4 - fri, 
	static void solve(int n, int amount, List<Integer> barn1, List<Integer> barn2) {
		if(n == 5) {	//금요일이 지난후 농장1의 우유탱크 높이 체크
			milkTank[amount] = true;
			return;
		}
		
		boolean oneTwo = n % 2 == 1;	//홀수번째는 화,목 짝수번째는 수,금
		
		if(oneTwo) {	//농장1 -> 농장2로 가는 경우
			for(int i = 0; i < barn1.size(); i++) {
				int milk = barn1.get(i);
				List<Integer> new_barn1 = new ArrayList<>(barn1);
				new_barn1.remove(i);
				List<Integer> new_barn2 = new ArrayList<>(barn2);
				new_barn2.add(milk);
				solve(n + 1, amount - milk, new_barn1, new_barn2);
			}
		}else {	//농장2 -> 농장1로 가는 경우
			for(int i = 0; i < barn2.size(); i++) {
				int milk = barn2.get(i);
				List<Integer> new_barn2 = new ArrayList<>(barn2);
				new_barn2.remove(i);
				List<Integer> new_barn1 = new ArrayList<>(barn1);
				new_barn1.add(milk);
				solve(n + 1, amount + milk, new_barn1, new_barn2);
			}
		}
	}
}
