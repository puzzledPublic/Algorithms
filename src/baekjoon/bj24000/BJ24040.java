package baekjoon.bj24000;

import java.io.*;

//예쁜 케이크
public class BJ24040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //w(width) * h(height) = N라 하면 둘레는 2w + 2h가 된다.
        //3개의 색으로 같은 횟수만큼 칠해야하므로 (2w + 2h) % 3 == 0이어야 한다.
        //(w + h) % 3 == 0과 같은데
        //w + h가 3의 배수가 되려면 w = 3*p, h = 3*q 또는 w = 3*p+1, h = 3*p+2의 경우로 생각해 볼 수 있다.
        //w * h = N = 9pq 또는 3(3pq + 2p + q) + 2가 되며 결국 N은 9의 배수 또는 3으로 나눴을때 나머지가 2가 되는 경우다.
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            long N = Long.parseLong(br.readLine());
            if((N % 9 == 0) || (N % 3 == 2)) {
                bw.write("TAK\n");
            }else {
                bw.write("NIE\n");
            }
        }

        bw.close();
        br.close();
    }
}
