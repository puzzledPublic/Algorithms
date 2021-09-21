package algorithmsForPS;

import java.io.File;
import java.util.Scanner;

//거스름 돈(M) 
//거슬러 줘야 할 돈과 동전들이(갯수 무제한) 주어졌을때 거슬러 줄 수 있는 최소의 동전 개수
public class AfcChangeMoneyM {
	
	static int M, N, counter;
	static int[] moneys;
	static int result =987654321;
	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "\\src\\test\\AfcChangeMoneyM";
		try(Scanner input = new Scanner(new File(path))) {
			
			//입력
			M = input.nextInt();
			N = input.nextInt();
			moneys = new int[N];
			for(int i = 0; i < N; i++) {
				moneys[i] = input.nextInt();
			}
			
			//계산
			result = greed_ans(0); //단순 탐욕적으로 근사 해를 구해 기준을 세운다.
			solve(0, 0);
			
			//출력
			System.out.println(result);
			
			System.out.println(counter); //얼마나 재귀를 도는지 계산하는 카운터
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	static int greed_ans(int m) {	//액수가 큰 동전부터 추가한다. (그리디)
		int ans = 0;
		/*for(int i = moneys.length - 1; i > -1; i--) {
			while(m + moneys[i] <= M) {
				m += moneys[i];
				ans++;
			}
			if(m == M) {
				break;
			}
		}*/
		m = M;
		while(m > 0) {
			for(int i = moneys.length - 1; i > -1; i--) {
				ans += (m / moneys[i]);
				m %= moneys[i];
			}
		}
		return ans;
	}
	static void solve(int amount, int m) {
		if(amount > result || m > M) {
			return;
		}
		counter++;
		if(m == M) {
			if(amount < result) {
				result = amount;
			}
			return;
		}
		
		for(int i = 0; i < moneys.length; i++) {
			solve(amount + 1, m + moneys[i]);
		}
	}
}
