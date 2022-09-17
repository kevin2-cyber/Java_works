package algol.algol;

public class Euclid {

    public static int euclid(int m, int n) {
        int r = 0;
        while (n  != 0) {
            r = m % n;
            m = n;
            n = r;
        }
        return m;
    }
}
