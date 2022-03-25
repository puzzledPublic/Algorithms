package baekjoon.bj1000;

import java.io.*;
import java.util.*;

//보석도둑
public class BJ1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        //보석 무게 순으로 오름차순 정렬
        PriorityQueue<Jewel> jewels = new PriorityQueue<>((a, b) -> a.m - b.m);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(M, V));
        }

        List<Integer> bags = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }
        //가방 무게 순으로 오름차순 정렬
        bags.sort((a, b) -> a - b);

        PriorityQueue<Jewel> pq = new PriorityQueue<>((a, b) -> b.v - a.v);

        long total = 0;
        //가방 무게 오름차순으로 순회한다.
        for (Integer bag : bags) {
            while(!jewels.isEmpty()) {
                if(bag >= jewels.peek().m) { //가방에 넣을 수 있는 보석들을 큐에 넣으며 이때 보석 가치로 내림차순 정렬(우선순위큐).
                    pq.add(jewels.poll());
                }else { //오름차순으로 정렬 돼 있으므로 더 찾아볼 필요 없다.
                    break;
                }
            }
            if(!pq.isEmpty()) {
                total += (long)(pq.poll().v);   //현재 가방에 넣을 수 있는 가장 큰 가치의 보석.
            }
        }

        bw.write(total + "\n");

        bw.close();
        br.close();
    }

    static class Jewel {
        int m, v;

        Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
}
