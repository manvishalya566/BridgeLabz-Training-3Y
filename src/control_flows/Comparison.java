package control_flows;
import java.util.Scanner;

class FriendsComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input ages
        System.out.print("Enter Amar's age: ");
        int ageAmar = sc.nextInt();
        System.out.print("Enter Akbar's age: ");
        int ageAkbar = sc.nextInt();
        System.out.print("Enter Anthony's age: ");
        int ageAnthony = sc.nextInt();

        // Input heights
        System.out.print("Enter Amar's height: ");
        int heightAmar = sc.nextInt();
        System.out.print("Enter Akbar's height: ");
        int heightAkbar = sc.nextInt();
        System.out.print("Enter Anthony's height: ");
        int heightAnthony = sc.nextInt();

        // Find youngest
        String youngest;
        if (ageAmar <= ageAkbar && ageAmar <= ageAnthony) {
            youngest = "Amar";
        } else if (ageAkbar <= ageAmar && ageAkbar <= ageAnthony) {
            youngest = "Akbar";
        } else {
            youngest = "Anthony";
        }

        // Find tallest
        String tallest;
        if (heightAmar >= heightAkbar && heightAmar >= heightAnthony) {
            tallest = "Amar";
        } else if (heightAkbar >= heightAmar && heightAkbar >= heightAnthony) {
            tallest = "Akbar";
        } else {
            tallest = "Anthony";
        }

        // Output
        System.out.println("The youngest friend is: " + youngest);
        System.out.println("The tallest friend is: " + tallest);

        sc.close();
    }
}
