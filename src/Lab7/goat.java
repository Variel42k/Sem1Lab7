import java.util.*;

public class Main {
    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Point[] trees = new Point[N];
        for (int i = 0; i < N; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            trees[i] = new Point(x, y);
        }

        // Вычисляем максимальные радиусы для каждого дерева
        double[] maxR = new double[N];
        for (int i = 0; i < N; i++) {
            double minDist = Double.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                double dist = distance(trees[i], trees[j]);
                if (dist < minDist) {
                    minDist = dist;
                }
            }
            maxR[i] = Math.min(50.0, minDist);
        }

        double bestArea = 0.0;
        final double EPS = 1e-9;

        // Перебираем все пары деревьев
        for (int i = 0; i < N; i++) {
            if (maxR[i] < 1.0 - EPS) continue; // Пропускаем если нельзя привязать

            for (int j = i + 1; j < N; j++) {
                if (maxR[j] < 1.0 - EPS) continue; // Пропускаем если нельзя привязать

                double d = distance(trees[i], trees[j]);

                // Если круги не пересекаются, берем максимальные радиусы
                if (maxR[i] + maxR[j] <= d + EPS) {
                    double area = Math.PI * (maxR[i] * maxR[i] + maxR[j] * maxR[j]);
                    if (area > bestArea) {
                        bestArea = area;
                    }
                }
                // Если круги пересекаются, находим оптимальные радиусы
                else if (d >= 2.0 - EPS) {
                    // Пробуем разные комбинации радиусов
                    double candidate1 = calculateOptimalArea(maxR[i], maxR[j], d);
                    double candidate2 = calculateOptimalArea(maxR[j], maxR[i], d);
                    double area = Math.PI * Math.max(candidate1, candidate2);

                    if (area > bestArea) {
                        bestArea = area;
                    }
                }
            }
        }

        System.out.printf("%.4f\n", bestArea);
    }

    static double distance(Point a, Point b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    static double calculateOptimalArea(double r1, double r2, double d) {
        // r1 + r2 = d для касающихся кругов
        // Ограничения: 1 <= r1 <= maxR1, 1 <= r2 <= maxR2
        double best = 0.0;

        // Случай 1: r1 максимально возможное, r2 = d - r1
        if (d - r1 >= 1.0) {
            double candidate = r1 * r1 + (d - r1) * (d - r1);
            if (candidate > best && (d - r1) <= r2) {
                best = candidate;
            }
        }

        // Случай 2: r2 максимально возможное, r1 = d - r2
        if (d - 1.0 <= r1) {
            double candidate = (d - 1.0) * (d - 1.0) + 1.0;
            if (candidate > best) {
                best = candidate;
            }
        }

        // Случай 3: равные радиусы
        if (d / 2.0 >= 1.0 && d / 2.0 <= r1 && d / 2.0 <= r2) {
            double candidate = 2.0 * (d / 2.0) * (d / 2.0);
            if (candidate > best) {
                best = candidate;
            }
        }

        return best;
    }
}