
public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (Math.abs(k) > n) return 0;
        else {
            long[][] tri = new long[n + 1][n + 2];
            tri[0][0] = 1;
            for (int i = 1; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    tri[i][j] = tri[i - 1][Math.abs(j - 1)] + tri[i - 1][j] + tri[i - 1][j + 1];
                }
            }
            return tri[n][Math.abs(k)];
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}
