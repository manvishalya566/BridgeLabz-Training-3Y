package Arrays;

import java.util.Scanner;

class BMIMulti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[][] personData = new double[n][3]; // weight, height, bmi
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter weight(kg) and height(m) for person " + (i + 1) + ":");
            double w = sc.nextDouble();
            double h = sc.nextDouble();
            if (w <= 0 || h <= 0) {
                System.out.println("Invalid input. Try again.");
                i--; continue;
            }

            double b = w / (h * h);
            personData[i][0] = w;
            personData[i][1] = h;
            personData[i][2] = b;

            if (b < 18.5) status[i] = "Underweight";
            else if (b < 24.9) status[i] = "Normal";
            else if (b < 29.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + ": Height=" + personData[i][1] +
                    " Weight=" + personData[i][0] +
                    " BMI=" + personData[i][2] +
                    " Status=" + status[i]);
        }
    }
}
