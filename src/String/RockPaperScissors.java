package String;

import java.util.Scanner;

class RockPaperScissors {

    static String computerChoice() {
        int val = (int)(Math.random() * 3);
        if (val == 0) return "rock";
        if (val == 1) return "paper";
        return "scissors";
    }

    static int findWinner(String user, String comp) {
        if (user.equals(comp)) return 0;
        if ((user.equals("rock") && comp.equals("scissors")) ||
                (user.equals("scissors") && comp.equals("paper")) ||
                (user.equals("paper") && comp.equals("rock"))) {
            return 1; // user wins
        }
        return -1; // comp wins
    }

    static String[][] playGames(int rounds) {
        Scanner sc = new Scanner(System.in);
        int userWins = 0, compWins = 0;
        String[][] log = new String[rounds + 1][3];

        for (int i = 0; i < rounds; i++) {
            System.out.print("Enter rock/paper/scissors: ");
            String user = sc.nextLine().toLowerCase();
            String comp = computerChoice();
            int res = findWinner(user, comp);

            log[i][0] = user;
            log[i][1] = comp;
            if (res == 1) {
                log[i][2] = "User Wins";
                userWins++;
            } else if (res == -1) {
                log[i][2] = "Computer Wins";
                compWins++;
            } else {
                log[i][2] = "Draw";
            }
        }

        double userPercent = (userWins * 100.0) / rounds;
        double compPercent = (compWins * 100.0) / rounds;

        log[rounds][0] = "Win%";
        log[rounds][1] = String.format("%.2f", userPercent);
        log[rounds][2] = String.format("%.2f", compPercent);

        return log;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rounds: ");
        int rounds = sc.nextInt(); sc.nextLine();

        String[][] results = playGames(rounds);

        System.out.println("User\tComputer\tResult");
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i][0] + "\t" + results[i][1] + "\t" + results[i][2]);
        }
    }
}
