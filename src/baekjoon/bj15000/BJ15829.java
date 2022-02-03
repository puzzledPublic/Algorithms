package baekjoon.bj15000;

import java.io.*;

//Hashing
public class BJ15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        long mod = 1_234_567_891;
        long prime = 1;
        long result = 0;
        for(int i = 0; i < L; i++) {
            long k = (str[i] - 96);
            result = (result + ((k * prime) % mod)) % mod;
            prime = (prime * 31) % mod;
        }

        bw.write(result + "\n");

        bw.close();
        br.close();
    }
}
