package Lab7;

import java.util.*;

public class KnightTour {
    static int N;
    static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        if (N == 1) {
            System.out.println("a1");
            return;
        }
        if (N == 2 || N == 3 || N == 4) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        List<int[]> path = new ArrayList<>();
        for (int startY = 0; startY < N; startY++) {
            for (int startX = N - 1; startX >= 0; startX--) {
                int[][] board = new int[N][N];
                path.clear();
                if (solve(board, startX, startY, 1, path)) {
                    for (int[] cell : path) {
                        char letter = (char)('a' + cell[1]);
                        int number = N - cell[0];
                        System.out.println(letter + "" + number);
                    }
                    return;
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    static boolean solve(int[][] board, int x, int y, int moveCount, List<int[]> path) {
        board[x][y] = moveCount;
        path.add(new int[]{x, y});

        if (moveCount == N * N) {
            return true;
        }

        List<int[]> nextMoves = getNextMoves(board, x, y);
        if (nextMoves.isEmpty()) {
            board[x][y] = 0;
            path.remove(path.size() - 1);
            return false;
        }

        nextMoves.sort((a, b) -> {
            int degA = getDegree(board, a[0], a[1]);
            int degB = getDegree(board, b[0], b[1]);
            return Integer.compare(degA, degB);
        });

        for (int[] move : nextMoves) {
            if (solve(board, move[0], move[1], moveCount + 1, path)) {
                return true;
            }
        }

        board[x][y] = 0;
        path.remove(path.size() - 1);
        return false;
    }

    static List<int[]> getNextMoves(int[][] board, int x, int y) {
        List<int[]> moves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == 0) {
                moves.add(new int[]{nx, ny});
            }
        }
        return moves;
    }

    static int getDegree(int[][] board, int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == 0) {
                count++;
            }
        }
        return count;
    }
}
