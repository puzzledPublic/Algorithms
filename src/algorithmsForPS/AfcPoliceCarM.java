package algorithmsForPS;

import java.io.File;
import java.util.Scanner;

public class AfcPoliceCarM {
	static int result = 987654321;
	static int N, accidentCount, counter;
	static int[][] accidentLocation;
	static int[][] policeLocation;
	
	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "\\src\\test\\AfcPoliceCarM";
		
		try(Scanner input = new Scanner(new File(path))) {
			
			N = input.nextInt();
			accidentCount = input.nextInt();
			policeLocation = new int[2][2];
			accidentLocation = new int[accidentCount][2];
			
			policeLocation[0][0] = policeLocation[0][1] = 1;
			policeLocation[1][0] = policeLocation[1][1] = N;
			for(int i = 0; i < accidentCount; i++) {
				accidentLocation[i][0] = input.nextInt();
				accidentLocation[i][1] = input.nextInt();
			}
			
			result = greedy_ans(policeLocation[0], policeLocation[1]);
			solve(0, 0);
			
			System.out.println(result);
			
			System.out.println(counter);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	static int greedy_ans(int[] policeLocation1, int[] policeLocation2) {
		int[] policeCar = policeLocation1.clone();
		int[] policeCar2 = policeLocation2.clone();
		int distance = 0 ;
		for(int i = 0; i < accidentCount; i++) {
			int a = calcDistance(accidentLocation[i][0], accidentLocation[i][1], policeCar[0], policeCar[1]);
			int b = calcDistance(accidentLocation[i][0], accidentLocation[i][1], policeCar2[0], policeCar2[1]);
			if(a > b) {
				distance += b;
				policeCar[0] = accidentLocation[i][0];
				policeCar[1] = accidentLocation[i][1];
			} else {
				distance += a;
				policeCar2[0] = accidentLocation[i][0];
				policeCar2[1] = accidentLocation[i][1];
			}
		}
		return distance;
	}
	static void solve(int distance, int count) {
		if(distance > result) {
			return;
		}
		counter++;
		if(count == accidentCount) {
			if(distance < result) {
				result = distance;
			}
			return;
		}
		int policeX, policeY;
		policeX = policeLocation[0][0];
		policeY = policeLocation[0][1];
		policeLocation[0][0] = accidentLocation[count][0];
		policeLocation[0][1] = accidentLocation[count][1];
		solve(distance + calcDistance(accidentLocation[count][0], accidentLocation[count][1], policeX, policeY), count + 1);
		policeLocation[0][0] = policeX;
		policeLocation[0][1] = policeY;
		
		policeX = policeLocation[1][0];
		policeY = policeLocation[1][1];
		policeLocation[1][0] = accidentLocation[count][0];
		policeLocation[1][1] = accidentLocation[count][1];
		solve(distance + calcDistance(accidentLocation[count][0], accidentLocation[count][1], policeX, policeY), count + 1);
		policeLocation[1][0] = policeX;
		policeLocation[1][1] = policeY;

	}
	
	static int calcDistance(int x, int y, int px, int py) {
		return (int)Math.abs(x - px) + (int)Math.abs(y - py);
	}
}
