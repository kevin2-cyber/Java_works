package kevin.codelab.java.methods;

public class SpeedConverter {

    public static long toMilesPerHour(double kilometersPerHour) {

        if (kilometersPerHour < 0) {
            System.out.println("invalid value");
            return -1;
        } else {
            return Math.round(kilometersPerHour / 1.609);
        }
    }


    // 1 Mile per Hour is 1.609 kilometers per hour
    public static void printConversion(double kilometersPerHour) {

    }
}
