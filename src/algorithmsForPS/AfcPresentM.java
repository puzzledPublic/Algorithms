package algorithmsForPS;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class AfcPresentM {
	static int N, d = 987654321, sum, counter;
	static int[] presents;
	static int[] result = new int[3];
	
	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "\\src\\test\\AfcPresentM";
		
		try(Scanner input = new Scanner(new File(path))) {
			N = input.nextInt();
			presents = new int[N];
			for(int i = 0; i < N; i++) {
				presents[i] = input.nextInt();
				sum += presents[i];
			}
			
			solve(0, 0, 0, 0);
			System.out.println(Arrays.toString(result));
			
			System.out.println(counter);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void solve(int a, int b, int c, int index) {
		if(c > sum / 3 || b > sum / 2) {
			return;
		}
		int rest = sum - (a + b + c); 
		if(a + rest < b ||  b + rest < c) {
			return;
		}
		if(a - (c + rest) > d) {
			return;
		}
		counter++;
		
		if(index < N) {
			solve(a, b, c + presents[index], index + 1);
			solve(a, b + presents[index], c, index + 1);
			solve(a + presents[index], b, c, index + 1);
		}
		else if((a >= b && b >= c) && a - c > 0 && a - c < d) {
			d = a - c;
			result[0] = a;
			result[1] = b;
			result[2] = c;
		}
	}
}
