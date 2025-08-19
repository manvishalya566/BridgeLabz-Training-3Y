package programming_elements;

public class Pre{
    public static void main(String[] args) {
        int result = 10 + 2 * 5; // Multiplication first, then addition
        int resultWithBrackets = (10 + 2) * 5; // Brackets first

        System.out.println("Without brackets: " + result); 
        System.out.println("With brackets: " + resultWithBrackets);
    }
}