package String;

import java.util.Scanner;

class BMICalculator {

    // Method 1: Take input of weight and height for 10 persons
    static double[][] takeInput(int n) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[n][2]; // weight, height
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) for person " + (i+1) + ": ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i+1) + ": ");
            data[i][1] = sc.nextDouble();
        }
        return data;
    }

    // Method 2: Compute BMI and Status
    static String[][] computeBMI(double[][] data) {
        int n = data.length;
        String[][] result = new String[n][4]; // weight, height, BMI, status

        for (int i = 0; i < n; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0;

            double bmi = weight / (heightM * heightM);
            bmi = Math.round(bmi * 100.0) / 100.0; // round to 2 decimal places

            String status;
            if (bmi < 18.5) status = "Underweight";
            else if (bmi < 24.9) status = "Normal";
            else if (bmi < 29.9) status = "Overweight";
            else status = "Obese";

            result[i][0] = String.valueOf(weight);
            result[i][1] = String.valueOf(heightCm);
            result[i][2] = String.valueOf(bmi);
            result[i][3] = status;
        }
        return result;
    }

    // Method 3: Display BMI Table
    static void displayTable(String[][] result) {
        System.out.println("---------------------------------------------------------");
        System.out.println("Person\tWeight(kg)\tHeight(cm)\tBMI\tStatus");
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i < result.length; i++) {
            System.out.println((i+1) + "\t" +
                    result[i][0] + "\t\t" +
                    result[i][1] + "\t\t" +
                    result[i][2] + "\t" +
                    result[i][3]);
        }
    }

    // Main
    public static void main(String[] args) {
        int n = 10; // number of persons
        double[][] data = takeInput(n);
        String[][] result = computeBMI(data);
        displayTable(result);
    }
}
