package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//공약수
public class BJ5618 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int gcd = n == 2 ? getGcd(nums[0], nums[1]) : getGcd(getGcd(nums[0], nums[1]), nums[2]);	//수들의 최대공약수
		
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i * i <= gcd; i++) {		//최대공약수의 약수들 구하기
			if(gcd % i == 0) {
				int t = gcd / i;
				if(t != i) {	//중복의 경우 제외. ex) gcd=25, t=5, i=5
					list.add(t);
				}
				bw.write(i + "\n");
			}
		}
		for(int i = list.size() - 1; i >= 0; i--) {
			bw.write(list.get(i) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int getGcd(int a, int b) {
		return b == 0 ? a : getGcd(b, a % b);
	}
}
