package algol.algol;

public class Test {
    public static void main(String[] args) {
        int eu = euclid(60, 24);
        System.out.println(eu);
        int test2 = euclid(90, 40);
        System.out.println(test2);
    }

    private static int euclid(int m, int n) {
        int r = 0;
        while (n  != 0) {
            r = m % n;
            m = n;
            n = r;
        }
        return m;
    }
}
