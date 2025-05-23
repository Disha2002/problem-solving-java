package DSA.Math;

public class RevereseInteger {

    public int reverse(int x) {

        long a = 0; // to make sure it won't ovrflow
        while (x != 0) {
            a = a * 10 + x % 10;
            x = x / 10;
        }
        if (a < Math.pow(-2, 31) || a > Math.pow(2, 31))// to handle edge case
            return 0;
        return (int) a;
    }
}