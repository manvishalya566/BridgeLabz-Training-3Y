package control_flows;
class SpringSeason {
    public static void main(String[] args) {
        // Take month and day from command line arguments
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        // Check if date is in Spring Season (March 20 to June 20)
        boolean isSpring =
                (month == 3 && day >= 20 && day <= 31) ||   // March 20 - 31
                        (month == 4 && day >= 1 && day <= 30)  ||   // April
                        (month == 5 && day >= 1 && day <= 31)  ||   // May
                        (month == 6 && day >= 1 && day <= 20);      // June 1 - 20

        if (isSpring) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
