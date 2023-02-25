package org.example;

import net.jafama.FastMath;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author NieGestorben
 * Copyright© (c) ${YEAR}, All Rights Reserved.
 */
public class Main {
    public static void main(String[] args) {
        double a = 20.215125;
        double b = 30.1251251;
        long time1;
        long time2;
        double result;
        time1 = System.nanoTime();
        System.out.println(time1);
        result = getGcd(a, b);
        time2 = System.nanoTime();
        System.out.println(time2);
        System.out.println("Time GCD: " + (time2 - time1) + " Result:" + result);

        time1 = System.nanoTime();
        result = getGcdFastMath(a, b);
        time2 = System.nanoTime();
        System.out.println("Time FastMath GCD: " + (time2 - time1) + " Result:" + result);

        time1 = System.nanoTime();
        result = gcd(a, b);
        time2 = System.nanoTime();
        System.out.println("Time GCD Type 1: " + (time2 - time1) + " Result:" + result);

        time1 = System.nanoTime();
        result = gcd2(a, b);
        time2 = System.nanoTime();
        System.out.println("Time GCD Type 2: " + (time2 - time1) + " Result:" + result);

        time1 = System.nanoTime();
        result = gcd3(a, b);
        time2 = System.nanoTime();
        System.out.println("Time GCD Type 3: " + (time2 - time1) + " Result:" + result);
    }

    public static double getGcd(final double a, final double b) {
        if (a < b) {
            return getGcd(b, a);
        }

        if (Math.abs(b) < 0.001) {
            return a;
        } else {
            return getGcd(b, a - Math.floor(a / b) * b);
        }
    }

    public static double getGcdFastMath(final double a, final double b) {
        if (a < b) {
            return getGcd(b, a);
        }

        if (FastMath.abs(b) < 0.001) {
            return a;
        } else {
            return getGcd(b, a - FastMath.floor(a / b) * b);
        }
    }

    public static double gcd(double a, double b)
    {
        // stores minimum(a, b)
        double i = Math.min(a, b);

        // take a loop iterating through smaller number to 1
        for (i = i; i > 1; i--) {

            // check if the current value of i divides both
            // numbers with remainder 0 if yes, then i is
            // the GCD of a and b
            if (a % i == 0 && b % i == 0)
                return i;
        }

        // if there are no common factors for a and b other
        // than 1, then GCD of a and b is 1
        return 1;
    }

    // gcd method returns the GCD of a and b
    static double gcd2(double a, double b)
    {
        // if b=0, a is the GCD
        if (b == 0)
            return a;

            // call the gcd() method recursively by
            // replacing a with b and b with
            // difference(a,b) as long as b != 0
        else
            return gcd2(b, Math.abs(a - b));
    }

     public static double gcd3(double a, double b)
    {
        // if b=0, a is the GCD
        if (b == 0)
            return a;

            // call the gcd() method recursively by
            // replacing a with b and b with
            // modulus(a,b) as long as b != 0
        else
            return gcd3(b, a % b);
    }

}