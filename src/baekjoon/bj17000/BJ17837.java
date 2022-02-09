package baekjoon.bj17000;

import java.io.*;
import java.util.StringTokenizer;

//새로운 게임 2
public class BJ17837 {
    static int[][] D = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] chess = new int[N + 2][N + 2];
        Piece[] pieces = new Piece[K + 1];
        for (int i = 0; i <= N + 1; i++) {
            for (int j = 0; j <= N + 1; j++) {
                chess[i][j] = 2;
            }
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                chess[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pieces[i] = new Piece(i, x, y, d);
        }

        int trialCount = 0;
        boolean close = false;
        while (true) {
            trialCount++;
            if (trialCount > 1000) break;

            for (int i = 1; i <= K; i++) {
                Piece piece = pieces[i];
                int nextX = piece.x + D[piece.d][0];
                int nextY = piece.y + D[piece.d][1];

                Piece pp = null, pa = null;
                switch (chess[nextX][nextY]) {
                    case 0:
                        pp = piece.prev;
                        if (pp != null) {
                            pp.next = null;
                            piece.prev = null;
                        }
                        pa = findPiece(pieces, nextX, nextY);
                        piece.moveTo(nextX, nextY);
                        if (pa != null) {
                            pa.next = piece;
                            piece.prev = pa;
                        }
                        break;
                    case 1:
                        pp = piece.prev;
                        if (pp != null) {
                            pp.next = null;
                            piece.prev = null;
                        }
                        pa = findPiece(pieces, nextX, nextY);
                        piece.moveTo(nextX, nextY);
                        Piece root = piece.reverse();
                        if (pa != null) {
                            pa.next = root;
                            root.prev = pa;
                        }
                        break;
                    case 2:
                        piece.changeDirection();
                        nextX = piece.x + D[piece.d][0];
                        nextY = piece.y + D[piece.d][1];
                        switch (chess[nextX][nextY]) {
                            case 0:
                                pp = piece.prev;
                                if (pp != null) {
                                    pp.next = null;
                                    piece.prev = null;
                                }
                                pa = findPiece(pieces, nextX, nextY);
                                piece.moveTo(nextX, nextY);
                                if (pa != null) {
                                    pa.next = piece;
                                    piece.prev = pa;
                                }
                                break;
                            case 1:
                                pp = piece.prev;
                                if (pp != null) {
                                    pp.next = null;
                                    piece.prev = null;
                                }
                                pa = findPiece(pieces, nextX, nextY);
                                piece.moveTo(nextX, nextY);
                                Piece iroot = piece.reverse();
                                if (pa != null) {
                                    pa.next = iroot;
                                    iroot.prev = pa;
                                }
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        throw new RuntimeException();
                }

                for(int j = 1; j <= K; j++) {
                    int count = count(pieces[j]);
                    if (count >= 4) {
                        close = true;
                        break;
                    }
                }
                if(close) break;
            }

            if (close) break;
        }

        if (trialCount > 1000) {
            bw.write("-1\n");
        } else {
            bw.write(trialCount + "\n");
        }

        bw.close();
        br.close();
    }

    static Piece findPiece(Piece[] ps, int x, int y) {
        for (int i = 1; i < ps.length; i++) {
            if (ps[i].x == x && ps[i].y == y && ps[i].next == null) {
                return ps[i];
            }
        }
        return null;
    }

    static int count(Piece p) {
        if (p.next == null) {
            return 1;
        }
        return count(p.next) + 1;
    }

    static class Piece {
        int n, x, y, d;
        Piece prev, next;

        Piece(int n, int x, int y, int d) {
            this.n = n;
            this.x = x;
            this.y = y;
            this.d = d;
            this.prev = null;
            this.next = null;
        }

        void moveTo(int x, int y) {
            this.x = x;
            this.y = y;
            if (this.next != null) {
                this.next.moveTo(x, y);
            }
        }

        Piece reverse() {
            if (this.next == null) {
                Piece temp = this.next;
                this.next = this.prev;
                this.prev = temp;
                return this;
            }
            Piece reversedRoot = this.next.reverse();
            Piece temp = this.next;
            this.next = this.prev;
            this.prev = temp;
            return reversedRoot;
        }

        void changeDirection() {
            if (this.d == 1 || this.d == 3) {
                this.d++;
            } else {
                this.d--;
            }
        }
    }
}
