package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//주사위 던지기2
public class Jungol1175 {
	public static int N,M;
	public static List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		throwing(0);
	}
	private static void throwing(int n){
		if(n == N){
			if(M == sum(list)){
				for(int i : list){
					System.out.print(i+" ");
				}
				//list.forEach((a)->{System.out.print(a+" ");});
				System.out.println();
			}
			return;
		}
		
		for(int i = 1; i < 7; i++){
			list.add(i);
			throwing(n+1);
			list.remove(list.size()-1);
		}
		
	}
	private static int sum(List<Integer> list){
		int sum=0;
		for(int s : list){
			sum+=s;
		}
		return sum;
	}
}
