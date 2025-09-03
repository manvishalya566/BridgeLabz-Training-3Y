package ClassandObject;
public class PalindromeChecker {
    // Attribute
    private String text;

    // Constructor
    public PalindromeChecker(String text) {
        this.text = text;
    }

    // Method to check if the text is a palindrome
    public boolean isPalindrome() {
        String cleanText = text.replaceAll("[\\W_]", "").toLowerCase(); // Removes spaces and punctuation
        String reversedText = new StringBuilder(cleanText).reverse().toString();
        return cleanText.equals(reversedText);
    }

    // Method to display the result
    public void displayResult() {
        if (isPalindrome()) {
            System.out.println("✅ \"" + text + "\" is a palindrome.");
        } else {
            System.out.println("❌ \"" + text + "\" is not a palindrome.");
        }
    }

    // Main method
    public static void main(String[] args) {
        PalindromeChecker checker1 = new PalindromeChecker("A man a plan a canal Panama");
        PalindromeChecker checker2 = new PalindromeChecker("Hello");
        PalindromeChecker checker3 = new PalindromeChecker("Madam, in Eden, I'm Adam");

        checker1.displayResult();
        checker2.displayResult();
        checker3.displayResult();
    }
}

