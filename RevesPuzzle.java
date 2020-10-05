
public class RevesPuzzle {

    private static void hanoi(int n, int k, String from, String temp, String to) {
        if (n == 0) return;
        hanoi(n - 1, k, from, to, temp);
        StdOut.println("Move disc " + (n + k) + " from " + from + " to " + to);
        hanoi(n - 1, k, temp, from, to);
    }

    private static void reves(int n, String from, String temp1, String temp2, String to) {
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
        if (n == 1) StdOut.println("Move disc " + n + " from " + from + " to " + to);
        else if (n == 2) {
            StdOut.println("Move disc " + (n - 1) + " from " + from + " to " + temp1);
            StdOut.println("Move disc " + n + " from " + from + " to " + to);
            StdOut.println("Move disc " + (n - 1) + " from " + temp1 + " to " + to);
        }
        else {
            reves(k, from, to, temp2, temp1);
            hanoi(n - k, k, from, temp2, to);
            reves(k, temp1, from, temp2, to);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, "A", "B", "C", "D");
    }
}
