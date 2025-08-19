package java_fundamentals;

import java.util.Scanner;

public class Conversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double cel = sc.nextDouble();
        double fer= (cel*9.0/5.0)+32.0;
        System.out.println(fer);

    }
}
