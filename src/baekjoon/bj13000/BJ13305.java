package baekjoon.bj13000;

import java.io.*;
import java.util.StringTokenizer;

//주유소
public class BJ13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] dist = new long[N - 1];  //거리
        long[] distSum = new long[N];   //거리의 부분합
        long[] price = new long[N];     //각 지점의 주유비

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N - 1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        for(int i = 1; i < N; i++) {
            distSum[i] = distSum[i - 1] + dist[i - 1];
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int currPosition = 0;   //현재 지점 인덱스
        long currPrice = price[0];  //현재 지점의 주유비
        long total = 0; //총 비용
        for(int i = 1; i < N; i++) {
            //현재 지점보다 더 낮은 주유비 지점까지만 이동하여 그때까지의 주유비 계산
            if(currPrice > price[i]) {
                total += (currPrice * (distSum[i] - distSum[currPosition]));    //두 지점간 거리는 부분합으로 빠르게 계산
                currPrice = price[i];
                currPosition = i;
            }
        }
        //끝 지점까지 못갔고 현재 지점보다 더 낮은 주유비 지점이 없는 경우
        if(currPosition != N - 1) {
            total += (currPrice * (distSum[N - 1] - distSum[currPosition]));
        }

        bw.write(total + "\n");

        bw.close();
        br.close();
    }
}
