package baekjoon.bj19000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//독특한 계산기
public class BJ19591 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		String[] numStr = line.split("[+*-/]");	//숫자들
		String[] opStr = line.split("[\\d]+");	//연산자들
		
		if(opStr.length == 0) {	//숫자 하나면 그대로 출력.
			bw.write(Long.parseLong(numStr[0]) + "\n");
		} else {
			int os = 0, oe = opStr.length - 1, ns = 0, ne = numStr.length - 1;
			
			if("".equals(numStr[0])) {
				ns = 1;
			}
			long[] num = new long[numStr.length];
			for(int i = ns; i < numStr.length; i++) {
				num[i] = Long.parseLong(numStr[i]);
			}
			
			if("".equals(opStr[0])) {
				os = 1;
			}
		
			if("-".equals(opStr[os]) && (oe - os) == (ne - ns)) {	//첫 숫자 앞에 '-'가 붙어있다면 음수로 바꿔준다.
				num[ns] = -num[ns];
				os++;
			}
			
			while(os < oe) {
				//왼쪽 연산자, 오른쪽 연산자 우선순위 비교
				String leftOp = opStr[os], rightOp = opStr[oe];
				if(("*".equals(leftOp) || "/".equals(leftOp)) && ("+".equals(rightOp) || "-".equals(rightOp))) {	//왼쪽 우선
					long result = calc(leftOp, num[ns], num[ns + 1]);
					num[ns + 1] = result;
					ns++;
					os++;
				}else if(("*".equals(rightOp) || "/".equals(rightOp)) && ("+".equals(leftOp) || "-".equals(leftOp))) {	//오른쪽 우선
					long result = calc(rightOp, num[ne - 1], num[ne]);
					num[ne - 1] = result;
					ne--;
					oe--;
				}else {	//우선순위가 같으면.
					long leftCalc = calc(leftOp, num[ns], num[ns + 1]);
					long rightCalc = calc(rightOp, num[ne - 1], num[ne]);
					if(leftCalc < rightCalc) {	//연산한 숫자 크기 비교, 오른쪽이 더 크면 오른쪽 연산.
						num[ne - 1] = rightCalc;
						ne--;
						oe--;
					}else {	//같거나 왼쪽이 더 크면 왼쪽 연산.
						num[ns + 1] = leftCalc;
						ns++;
						os++;
					}
				}
			}
			
			if(ns == ne) {
				bw.write(num[ns] + "\n");
			}else {
				bw.write(calc(opStr[os], num[ns], num[ne]) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static long calc(String op, long left, long right) {
		switch(op) {
		case "+" :
			return left + right;
		case "-" :
			return left - right;
		case "*" :
			return left * right;
		default:
			return left / right;
		}
	}
}
