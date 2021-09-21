package java8;

import java.util.Scanner;
import java.util.Stack;

//탑 (자료구조1)
public class Jungol1809 {
	//밑에 것에 비해 메모리 up, 시간 down
	
	static class Top{
		int index;
		int size;
		public Top(int index, int size) {
			this.index = index;
			this.size = size;
		}
	}
	static Stack<Top> stack = new Stack<Top>();
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder str = new StringBuilder();
		int n, c;
		n = input.nextInt();
		
		for(int i = 1 ; i <= n ; i++){
			c = input.nextInt();
			while(!stack.isEmpty()){
				if(stack.peek().size > c){
					str.append(stack.peek().index+" ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()){
				str.append("0 ");
			}
			stack.push(new Top(i, c));
		}
		
		System.out.println(str);
	}
	
	//자료구조 없이 푼 경우 (통과는 하지만 시간, 메모리를 많이 씀. stringbuilder 써서 메모리를 더 먹는듯)
	/*
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		StringBuilder str = new StringBuilder();
		
		int n, pointer = 0;
		n = input.nextInt();
		int[] arr = new int[n];
		
		
		for(int i = 0 ; i < n ; i++){
			arr[i] = input.nextInt();
		}
		str.append("0 ");
		for(int i = 1 ; i < n ; i++){
			if(arr[i - 1] < arr[i]){
				pointer = i - 2;
				while(pointer != -1 && arr[pointer] < arr[i]){
					pointer--;
				}
				if(pointer == -1){
					str.append("0 ");
				}
				else{
					str.append((pointer + 1) + " ");
				}
			}
			else{
				str.append(i + " ");
			}
		}
		
		System.out.println(str);
	}*/
	
}
