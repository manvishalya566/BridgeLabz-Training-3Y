package programming_elements;
public class TypeConversionExample {
    public static void main(String[] args) {
        int num = 10;
        double convertedNum = num; // Implicit conversion

        double value = 9.78;
        int intValue = (int) value; // Explicit casting

        System.out.println("Implicit conversion (int to double): " + convertedNum);
        System.out.println("Explicit casting (double to int): " + intValue);
    }
}