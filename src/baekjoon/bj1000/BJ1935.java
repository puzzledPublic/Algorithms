package baekjoon.bj1000;

import java.io.*;
import java.util.Stack;

//후위 표기식 2
public class BJ1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] exps = br.readLine().toCharArray();
        double[] nums = new double[N];
        for(int i = 0; i < N; i++) {
          nums[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < exps.length; i++) {
            if('A' <= exps[i] && exps[i] <= 'Z') {
                stack.push((double)(nums[exps[i] - 'A']));
            }else {
                double b = stack.pop();
                double a = stack.pop();
                double c = 0.0d;
                switch (exps[i]) {
                    case '+':
                        c += (a + b);
                        break;
                    case '-':
                        c += (a - b);
                        break;
                    case '*':
                        c += (a * b);
                        break;
                    case '/':
                        c += (a / b);
                        break;
                }
                stack.push(c);
            }
        }

        bw.write(String.format("%.2f\n", stack.pop()));

        bw.close();
        br.close();
    }
}
