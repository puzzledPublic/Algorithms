package baekjoon.bj19000;

import java.io.*;

//반복
public class BJ19564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        char ch = line.charAt(0);   //첫번째 글자
        int count = 1;  //첫번째 글자는 무조건 누른다.
        for(int i = 1; i < line.length(); i++) {
            if(ch >= line.charAt(i)) {  //글자를 누르면 a~z까지 한번에 입력되므로 다음 입력 글자가 현재 글자보다 알파벳 순서상 앞이면 입력하는 수 밖에 없다.
                count++;
            }
            ch = line.charAt(i);
        }

        bw.write(count + "\n");

        bw.close();
        br.close();
    }
}
