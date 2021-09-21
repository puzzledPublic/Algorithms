package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
//키로거 (stack)
public class BJ5397 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			Stack<Character> stack1 = new Stack<>();
			Stack<Character> stack2 = new Stack<>();
			for(int j = 0; j < str.length(); j++) {
				char curr = str.charAt(j);
				switch(curr) {
				case '-':
					if(!stack1.isEmpty()) {
						stack1.pop();
					}
					break;
				case '<':
					if(!stack1.isEmpty()) {
						stack2.push(stack1.pop());
					}
					break;
				case '>':
					if(!stack2.isEmpty()) {
						stack1.push(stack2.pop());
					}
					break;
				default:
					stack1.push(curr);
					break;
				}
			}
			for(int j = 0; j < stack1.size(); j++) {
				bw.write(stack1.get(j));
			}
			while(!stack2.isEmpty()) {
				bw.write(stack2.pop());
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
/*//키로거 (LinkedList)
public class BJ5397 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			LinkedList<Character> list = new LinkedList<>();
			String str = br.readLine();
			int current = 0;
			for(int j = 0; j < str.length(); j++) {
				char curr = str.charAt(j);
				switch(curr) {
				case '-':
					if(current - 1 >= 0) {
						list.remove(current - 1);
					}
					if(current > 0) {
						current--;
					}
					break;
				case '<':
					if(current > 0) {
						current--;
					}
					break;
				case '>':
					if(current < list.size()) {
						current++;
					}
					break;
				default:
					list.add(current++, curr);
				}
			}
			for(Character ch : list) {
				bw.write(ch);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}*/
